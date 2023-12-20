package ru.gb.HW5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int COUNT_EATING = 3;

    public static void main(String[] args) {
        Lock eat = new ReentrantLock();
        Philosopher philosopher1 = new Philosopher("Архимед", COUNT_EATING, eat);
        Philosopher philosopher2 = new Philosopher("Аристотель", COUNT_EATING, eat);
        Philosopher philosopher3 = new Philosopher("Диоген", COUNT_EATING, eat);
        Philosopher philosopher4 = new Philosopher("Софокл", COUNT_EATING, eat);
        Philosopher philosopher5 = new Philosopher("Сократ", COUNT_EATING, eat);

        System.out.println("Lets begin");
        System.out.println("-------------------");
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();

        try {
            philosopher1.join();
            philosopher2.join();
            philosopher3.join();
            philosopher4.join();
            philosopher5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------------");
        System.out.println("All philosophers eated " + COUNT_EATING + " times");
    }
}
