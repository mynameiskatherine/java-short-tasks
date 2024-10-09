package Multithreading;

import java.util.Random;

import static java.lang.Thread.sleep;

public class TestThreading {
    public static volatile boolean count = true;
    public static Random rnd = new Random();

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();

        Thread myThread2 = new Thread(new MyRunningThread());
        myThread2.start();

//        try {
//            myThread1.join();
//            myThread2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (TestThreading.count) {
            int i = TestThreading.rnd.nextInt(100);
            System.out.println("Print from thread " + this.getClass().toString() + " number " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i > 50) {
                TestThreading.count = false;
            }
        }
        System.out.println("Count set to false. I'm stopping " + this.getClass().toString());
    }
}

class MyRunningThread implements Runnable {

    @Override
    public void run() {
        while (TestThreading.count) {
            int i = TestThreading.rnd.nextInt(1000);
            System.out.println("Print from thread " + this.getClass().toString() + " number " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Count set to false. I'm stopping " + this.getClass().toString());
    }
}
