package com.basejava.webapp;

public class DeadLock {
    static void deadLock(Object object1, Object object2) {
            new Thread(() -> {
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + " get " + object1 + " thread");
                    System.out.println(Thread.currentThread().getName() + " trying get " + object2 + " thread");
                    synchronized (object2) {
                        System.out.println(Thread.currentThread().getName() + " get " + object2 + " thread");
                    }
                }
            }).start();
    }
}
