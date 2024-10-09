package Multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

public class RobotTask {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 4; i++)
        {
            new Thread(new NewLeg(i)).start();
        }
    }
}

class NewLeg implements Runnable {
    private final int name;

    public static volatile int currentLeg = 1;
    public static final int MAXNUMBEROFLEGS = 4;

    private Lock lock;


    public void run()
    {
        while (true)
        {
            if (this.name == currentLeg) {
                lock.lock();
                System.out.println("Leg " + name);
                currentLeg = currentLeg == MAXNUMBEROFLEGS ? 1 : (currentLeg + 1);
                lock.unlock();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public NewLeg(int name)
    {
        this.name = name;
        this.lock = new ReentrantLock();
    }
}
