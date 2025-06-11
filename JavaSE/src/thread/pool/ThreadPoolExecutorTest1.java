package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池执行大量的Runnable命令/任务
 */
public class ThreadPoolExecutorTest1 {

    public static void main(String[] args) {

        // 线程池只有一个线程
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        // 线程池中的有固定数量的线程
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        // 线程池中线程的数量可以动态的变化
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        // 定时任务，用来执行大量的定时任务(几点执行，间隔执行)
        ExecutorService executorService4 = Executors.newScheduledThreadPool(10);


        int n = 100;
        ExecutorService pool = executorService1;
        for(int i = 0 ; i < n ; i  ++){
            Runnable runnable = new MyRunnable(i);
            // new Thread(runnable).start();
            pool.execute(runnable);
        }
        pool.shutdown();



    }

}

class MyRunnable implements Runnable{
    private int num ;

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("任务"+this.num+"开始");


        System.out.println("任务"+this.num+"结束");
    }
}