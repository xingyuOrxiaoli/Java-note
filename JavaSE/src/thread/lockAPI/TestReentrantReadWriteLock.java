package thread.lockAPI;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 1：多个读操作可以同时进行
 * 2：写写操作互斥的
 */
public class TestReentrantReadWriteLock {
    public static void main(String[] args) throws InterruptedException {

        final Operator operator = new Operator();
        // 创建五个读线程
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                operator.read();
            }
        };
        int n = 10;
        for (int i = 0 ; i < n ; i ++){
            new Thread(runnable1,"读线程:\t" + i).start();
        }

        // 创建五个写线程
        int m = 10;
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                operator.write();
            }
        };
        for(int i = 0 ; i < m ; i++){
            new Thread(runnable2,"写线程:\t" + i).start();
        }


    }
}


class Operator{

//    private Lock lock = new ReentrantLock();
    private ReadWriteLock rwLock  = new ReentrantReadWriteLock();  // 实现读读一起执行
    public void read(){
//        lock.lock();
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t读数据开始...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("读数据结束");
        }finally {
//            lock.unlock();
            rwLock.readLock().unlock();
        }
    }

    public void write(){
        rwLock.writeLock().lock();
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t写数据开始...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("写数据结束");
        }finally {
            rwLock.writeLock().unlock();
//            lock.unlock();
        }
    }
}
