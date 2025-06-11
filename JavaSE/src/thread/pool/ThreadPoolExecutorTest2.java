package thread.pool;

import java.lang.reflect.AnnotatedWildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用线程池执行大量的Callable任务
 */
public class ThreadPoolExecutorTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 线程池只有一个线程
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        // 线程池中的有固定数量的线程
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        // 线程池中线程的数量可以动态的变化
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        // 定时任务，用来执行大量的定时任务(几点执行，间隔执行)
        ExecutorService executorService4 = Executors.newScheduledThreadPool(10);


        int n = 100;
        ExecutorService pool = executorService3;
        List<Future<Integer>> results = new ArrayList<>();  // 任务分配和运行分离开
        for(int i = 0 ; i < n ; i  ++){
            Callable<Integer> task = new MyCallable(i);
            // new Thread(runnable).start();
            Future<Integer> future = pool.submit(task);
//            Integer res = future.get();
//            System.out.println(res);
            results.add(future);
        }
        results.forEach(res -> {
            try {
                System.out.println(res.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        pool.shutdown();
    }
}
class MyCallable implements Callable<Integer> {
    private int sum  ;

    public MyCallable(int sum) {
        this.sum = sum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("任务开始 "+ this.sum);
        Thread.sleep(1000);
        return new Random().nextInt(10);
    }
}
