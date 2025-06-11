package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketTest {
    public static void main(String[] args) {

        Runnable runnable = new TicketRunnable3(100000);

        Thread thread1 = new Thread(runnable,"小李");
        Thread thread2 = new Thread(runnable,"小赵");
        Thread thread3 = new Thread(runnable,"小李一号");
        Thread thread4 = new Thread(runnable,"小赵一号");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
// 同步代码块
class TicketRunnable1 implements Runnable {

    private int ticketNumber;

    public TicketRunnable1(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (this.ticketNumber > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第 " + this.ticketNumber + "张票");
                this.ticketNumber--;
            }
        }
    }
}

// 同步方法
class TicketRunnable2 implements Runnable {

    private int ticketNumber;

    public TicketRunnable2(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void run() {
        this.sellTicket();
    }
    private synchronized void sellTicket(){
        while (this.ticketNumber > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +"卖出了第 "+ this.ticketNumber +"张票");
            this.ticketNumber --;
        }
    }
}
// Lock锁
class TicketRunnable3 implements Runnable {

    private int ticketNumber;
    private Lock lock = new ReentrantLock();

    public TicketRunnable3(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void run() {
        lock.lock();
        while (this.ticketNumber > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +"卖出了第 "+ this.ticketNumber +"张票");
            this.ticketNumber --;
        }
        lock.unlock();
    }
}