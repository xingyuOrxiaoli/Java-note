package thread.producerConsumer.Vn_n_lock;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductFactory {


    // 存储商品
    List<String> list = new LinkedList<>(); // 因为生产和消费使用到大量的添加和删除，查询操作比较少，为此使用链表

    int max = 10;


    Lock lock = new ReentrantLock();

    Condition produceCondition = lock.newCondition();
    Condition consumeCondition = lock.newCondition();

    // 生成商品
    public void produce(String productName) throws InterruptedException {

        lock.lock();
        while (list.size() == max) {
            produceCondition.await();
        }
        list.add(productName);
        System.out.println(Thread.currentThread().getName()+"\t生产了商品\t"+productName + "\t当前商品数量为:"+list.size());

        consumeCondition.signalAll();
        lock.unlock();
    }

    // 消费商品
    public void consume() throws InterruptedException {


        lock.lock();
        while (list.size() == 0) {
            consumeCondition.await();
        }
        String consumeName = list.remove(0);
        System.out.println(Thread.currentThread().getName()+"\t消费了商品\t"+consumeName + "\t当前商品数量为:"+list.size());

        produceCondition.signalAll();

        lock.unlock();
    }
}
