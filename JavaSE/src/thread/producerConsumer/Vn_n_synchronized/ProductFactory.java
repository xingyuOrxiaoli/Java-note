package thread.producerConsumer.Vn_n_synchronized;


import java.util.LinkedList;
import java.util.List;

public class ProductFactory {


    // 存储商品
    List<String> list = new LinkedList<>(); // 因为生产和消费使用到大量的添加和删除，查询操作比较少，为此使用链表

    int max = 10;

    // 生成商品
    public synchronized void produce(String productName) throws InterruptedException {

        while (list.size() == max){
            this.wait();
        }
        list.add(productName);
        System.out.println(Thread.currentThread().getName()+"\t生产了商品\t"+productName + "\t当前商品数量为:"+list.size());

        if(list.size() == max){
            this.notifyAll();
        }
    }

    // 消费商品
    public synchronized void consume() throws InterruptedException {

        while(list.size() == 0){
            this.wait();
        }
        String consumeName = list.remove(0);
        System.out.println(Thread.currentThread().getName()+"\t消费了商品\t"+consumeName + "\t当前商品数量为:"+list.size());
        if(list.size() == 0){
            this.notifyAll();
        }
    }
}
