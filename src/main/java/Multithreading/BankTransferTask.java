package Multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransferTask {

    public static void main(String[] args) throws InterruptedException {

        Account account1 = new Account();
        Account account2 = new Account();
        Random rnd = new Random();
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Account.transfer(account1, account2, rnd.nextInt(100));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Account.transfer(account2, account1, rnd.nextInt(100));
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println(account1.getBalance() + account2.getBalance());
    }
}

class Account {
    private int balance;
    private Lock lock;

    public Account() {
        balance = 10000;
        lock = new ReentrantLock();
    }

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public Lock getLock() {
        return this.lock;
    }

    public static void transfer(Account from, Account to, int amount) {
        boolean fromAccLocking = false;
        boolean toAccLocking = false;

        while (true) {
            try {
                fromAccLocking = from.getLock().tryLock();
                toAccLocking = to.getLock().tryLock();
                if (fromAccLocking && toAccLocking) {
                    from.setBalance(from.getBalance() - amount);
                    to.setBalance(to.getBalance() + amount);
                    return;
                }
            } finally {
                if (fromAccLocking) {
                    from.getLock().unlock();
                }
                if (toAccLocking) {
                    to.getLock().unlock();
                }
            }
        }
    }
}
