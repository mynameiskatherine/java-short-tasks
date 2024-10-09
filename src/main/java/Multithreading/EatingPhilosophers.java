package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EatingPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        List<Fork> forks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < Fork.COUNT; i++) {
            forks.add(new Fork(i, new ReentrantLock()));
        }
        for (int i = 0; i < Philosopher.COUNT; i++) {
            philosophers.add(new Philosopher(i,
                    forks.get(i),
                    (i + 1) >= Philosopher.COUNT ? forks.get(0) : forks.get(i + 1))
            );
        }

//        long end = System.currentTimeMillis() + 5000;

        ExecutorService executorService = Executors.newFixedThreadPool(philosophers.size());

        for (int i = 0; i < philosophers.size(); i++) {
            executorService.submit(philosophers.get(i));
        }
        executorService.shutdown();
        executorService.awaitTermination(50000, TimeUnit.MILLISECONDS);

        for (Philosopher p : philosophers) {
            System.out.println("P " + p.id + " ate " + p.timesAte);
        }

    }
}

class Fork {
    public static final int COUNT = 5;
    public int id;
    private volatile boolean onTable;
    public volatile int holdingPhilosopher;
    public Lock lock;

    public Fork(int id, Lock lock) {
        this.id = id;
        this.onTable = true;
        this.holdingPhilosopher = -1;
        this.lock = lock;
    }

//    public void takeFork(int philosopher) {
//        try {
//            this.lock.lock();
//            this.onTable = false;
//            this.holdingPhilosopher = philosopher;
//        } finally {
//            this.lock.unlock();
//        }
//    }
//    public void putFork() {
//        try {
//            this.lock.lock();
//            this.onTable = true;
//            this.holdingPhilosopher = -1;
//        } finally {
//            this.lock.unlock();
//        }
//    }
}

class Philosopher implements Runnable {
    public static final int COUNT = 5;
    public int id;
    public Status status;
    public Fork right;
    public Fork left;
    public int timesAte = 0;

    public Philosopher(int id, Fork right, Fork left) {
        this.id = id;
        this.status = Status.THINKS;
        this.right = right;
        this.left = left;
    }

    private void doThink() throws InterruptedException {
        System.out.printf("Philosopher %d: I'm thinking...%n", this.id);
        Thread.sleep(1000);
    }
    private void doWaitForForks() throws InterruptedException {
        boolean rightForkLocked = false;
        boolean leftForkLocked = false;

        while (true) {
            System.out.printf("Philosopher %d: I'm waiting for forks...%n", this.id);
            try {
                rightForkLocked = this.right.lock.tryLock();
                leftForkLocked = this.left.lock.tryLock();
            } finally {
                if (rightForkLocked && leftForkLocked) {
                    return;
                }
                if (rightForkLocked) {
                    this.right.lock.unlock();
                }
                if (leftForkLocked) {
                    this.left.lock.unlock();
                }
                Thread.sleep(100);
            }
//            if (this.right.holdingPhilosopher == -1) {
//                right.takeFork(this.id);
//            }
//            if (this.left.holdingPhilosopher == -1) {
//                left.takeFork(this.id);
//            }
//            if (right.holdingPhilosopher == this.id && left.holdingPhilosopher == this.id) {
////                System.out.printf("Philosopher %d: Finally have forks...", this.id);
//                return;
//            } else {
//                Thread.sleep(500);
//            }
        }
    }
    private void doEat() throws InterruptedException {
        try {
            System.out.printf("Philosopher %d: I'm eating...%n", this.id);
            Thread.sleep(1000);
        } finally {
            this.right.lock.unlock();
            this.left.lock.unlock();
            this.timesAte++;
        }

//        this.right.putFork();
//        this.left.putFork();

    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + 20000;
        while (System.currentTimeMillis() < end) {
            try {
                doThink();
                doWaitForForks();
                doEat();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}

enum Status {
    THINKS,
    WAITING_FORK,
    EATS
}


