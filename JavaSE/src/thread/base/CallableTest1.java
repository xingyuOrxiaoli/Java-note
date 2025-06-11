package thread.base;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTest1 {
     public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> randomCallable = new RandomCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(randomCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.isDone()); // 是否已经完成
        Integer res = futureTask.get(3, TimeUnit.SECONDS); //  等待3s还是没有返回值 输出异常
        System.out.println(futureTask.isDone());

        System.out.println(res);

    }
}
// 返回一个随机值
class RandomCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return new Random().nextInt(10);
    }
}
