package ru.gb.HW5;

import java.util.Random;
import java.util.concurrent.locks.Lock;


public class Philosopher extends Thread {
    private final String name;
    private int countEating = 1;
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
            System.out.println("Philosopher " + name + " begin eating " + countEating + " times");
            sleep(500);
            System.out.println("Philosopher " + name + " finish eating " + countEating + " times");
            isHungry = false;
            this.countEating++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void thinking() {
        try {
            System.out.println("Philosopher " + name + " begin thinking");
            sleep(rnd.nextInt(2000));
            System.out.println("Philosopher " + name + " finish thinking");
            isHungry = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        while (countEating <= maxCountEating) {
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
