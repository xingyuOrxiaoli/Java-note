package thread.lock;

public class SynchronizedTest2 {

    public static void main(String[] args) {
        AccountRunnable accountRunnable = new SynchronizedTest2.AccountRunnable(11000);

        Thread thread1 = new Thread(accountRunnable,"小李 SynchronizedTest2");
        Thread thread2 = new Thread(accountRunnable,"小赵 SynchronizedTest2");

        thread1.start();
        thread2.start();
    }

    static class AccountRunnable implements Runnable {
        private Account account;
        public AccountRunnable(int balance) {
            this.account = new Account(balance);
        }
        @Override
        public void run() {
            this.account.withDraw(10000);
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
        public synchronized void  withDraw(int amount) {  //
            if (this.getBalance() >= amount){ // 余额足够
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 取款成功,当前余额：" + this.getBalance());
            }else{
                System.out.println(Thread.currentThread().getName() + " 取款失败,余额不足,当前余额：" + this.getBalance());
            }
        }
    }
}
