package ru.gb.HW5;

import java.util.Random;
import java.util.concurrent.locks.Lock;


public class Philosopher extends Thread {
    private final String name;
    private int countEating = 0;
    private final int maxCountEating;
    private boolean isHungry;
    private final Lock lock;
    private final Random rnd;


    public Philosopher(String name, int maxCountEating, Lock lock) {
        this.maxCountEating = maxCountEating;
        this.name = name;
        this.lock = lock;
        this.isHungry = true;
        this.rnd = new Random();
    }

    public void eating() {
        try {
            System.out.println("Philosopher " + name + " begin eating " + (countEating + 1) + " times");
            Thread.sleep(500);
            System.out.println("Philosopher " + name + " finish eating " + (countEating + 1) + " times");
            isHungry = false;
            this.countEating++;
        } catch (InterruptedException e) {
            throw new RuntimeException("Philosopher " + name + "can`t finishing eating " + (countEating + 1) + " times");
        }
    }

    public void thinking() {
        try {
            System.out.println("Philosopher " + name + " begin thinking");
            Thread.sleep(rnd.nextInt(2000));
            System.out.println("Philosopher " + name + " finish thinking");
            isHungry = true;
        } catch (InterruptedException e) {
            throw new RuntimeException("Philosopher " + name + " can`t finishing thinking");
        }
    }


    @Override
    public void run() {
        while (countEating < maxCountEating) {
            if (isHungry && lock.tryLock()) {
                try {
                    eating();
                } finally {
                    lock.unlock();
                }
            } else {
                thinking();
            }
        }
    }
}
