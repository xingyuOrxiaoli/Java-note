package thread.blackingQueue;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductFactory {


    int max = 10;
    // 存储商品
    BlockingQueue<String> queue ;

    public ProductFactory() {
        this.queue = new ArrayBlockingQueue<String>(this.max);

        queue.add(null);

        try {
            queue.put(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        queue.offer(null);

    }

    Lock lock = new ReentrantLock();

    Condition produceCondition = lock.newCondition();
    Condition consumeCondition = lock.newCondition();

    // 生成商品
    public void produce(String productName) throws InterruptedException {

        queue.add(productName);
        System.out.println(Thread.currentThread().getName()+"\t生产了商品\t"+productName + "\t当前商品数量为:"+queue.size());

    }

    // 消费商品
    public void consume() throws InterruptedException {

        String consumeName = queue.remove();
        System.out.println(Thread.currentThread().getName()+"\t消费了商品\t"+consumeName + "\t当前商品数量为:"+queue.size());

    }
}
