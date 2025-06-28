package thread.lockAPI;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class LockAPI {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 1. 可重入锁   Lock  ReentrantLock  synchronized  锁都是可重入锁
         *      
         * 2. 独占锁和共享锁
         *      独占锁   WriteLock  ReentrantLock synchronized  
         *      共享锁   ReadLock
         * 3. 公平锁和非公平锁
         *      是否先来后到，有没有优先级
         * 
         */
        Lock lock1 = new ReentrantLock(); // 默认为非公平锁

        // 创建锁1  拿不到锁一直等待拿到为止
        lock1.lock();
        // 创建锁2  拿不到返回false 拿不到返回true
        lock1.tryLock();
        // 创建锁3  拿不到锁等待一定的时间，时间到了就放弃返回false
        lock1.tryLock(10, TimeUnit.MILLISECONDS);
        // 创建锁4 拿不到锁就一直等待，中途可以被其他线程中断
        lock1.lockInterruptibly();
        // 解锁
        lock1.unlock();
        // 创建一个等待队列
        lock1.newCondition();


        ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();
        Lock readLock1 = lock2.readLock();
        Lock readLock2 = lock2.readLock();
        Lock writeLock1 = lock2.writeLock();
        Lock writeLock2 = lock2.writeLock();

        System.out.println(readLock1 == readLock2); // 返回的同意把锁
        System.out.println(writeLock1 == writeLock2);

        Lock lock3 = new ReentrantLock();
        Lock lock4 = new ReentrantLock();
        Lock lock5 = new ReentrantLock();
    }
}
