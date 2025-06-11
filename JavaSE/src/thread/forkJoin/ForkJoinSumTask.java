package thread.forkJoin;

import java.util.Locale;
import java.util.concurrent.*;

public class ForkJoinSumTask extends RecursiveTask<Long> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int n = 1000000000;
        long sum_for = 0;

        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            sum_for += i;
        }
        System.out.println("for循环实现 一个核执行其他的看着 :" + sum_for);
        long end = System.currentTimeMillis();
        System.out.println("for循环花费的时间\t" + (end - start));

        start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();

        RecursiveTask task = new ForkJoinSumTask(1,n,n / 10000 + 1);

        Future<Long> future = pool.submit(task);

        Long res = future.get();
        System.out.println("forkJoin实现 :" + res);

        pool.shutdown();

        end = System.currentTimeMillis();
        System.out.println("forkJoin花费的时间\t" + (end - start));
    }

    private int start ;
    private int end;
    private int step;

    public ForkJoinSumTask(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    protected Long compute() {

        Long res = 0l;
        if(end - start <= step) {
            for (int i = start; i <= end; i++) {
                res += i;
            }
        }else{
            int mid = (end + start) >> 1;
            ForkJoinSumTask left = new ForkJoinSumTask(start, mid, step);
            ForkJoinSumTask right = new ForkJoinSumTask(mid + 1, end, step);

            left.fork();
            right.fork();

            Long leftRes  = left.join();
            Long rightRes = right.join();
            res = leftRes + rightRes;
        }

        return res;
    }
}
