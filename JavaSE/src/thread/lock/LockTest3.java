package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest3 {

    public static void main(String[] args) {
        AccountRunnable accountRunnable = new LockTest3.AccountRunnable(11000);

        Thread thread1 = new Thread(accountRunnable,"小李 LockTest3");
        Thread thread2 = new Thread(accountRunnable,"小赵 LockTest3");

        thread1.start();
        thread2.start();
    }

    static class AccountRunnable implements Runnable {
        private Account account;

        private Lock lock = new ReentrantLock();  // re-entrant 可重入锁
        public AccountRunnable(int balance) {
            this.account = new Account(balance);
        }
        @Override
        public void run() {

            lock.lock();
            if (this.account.getBalance() >= 10000){ // 余额足够
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                account.withDraw(10000);
                System.out.println(Thread.currentThread().getName() + " 取款成功,当前余额：" + account.getBalance());
            }else{
                System.out.println(Thread.currentThread().getName() + " 取款失败,余额不足,当前余额：" + account.getBalance());
            }
            lock.unlock();
        }
    }
    static class Account {
        private int balance; // 余额


        public Account(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }
        public void  withDraw(int amount) {  //
            this.balance -= amount;
        }
    }
}
