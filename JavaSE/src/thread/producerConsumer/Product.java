package thread.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private String name;
    private double price;
    private String color;
    private boolean status;
    private int produceNumber;
    private int consumerNumber;

    private int produceIndex;

    private final String[] names    = new String[] {"大馒头","玉米饼","紫薯饼"};
    private final double[] prices   = new double[] {0.8,2.0,3.5};
    private final String[] colors   = new String[] {"白色","黄色","紫色"};


    /** 三种方法
     * 同步代码块方法
     * 同步方法
     * Lock锁的方法
     */


    /** 实现线程通信的方式
     * 方法1 : wait notifyAll  同步方法/同步代码块
     * 方法2 : lock 和生产消费队列
     *
     */

    private Lock lock = new ReentrantLock();
    // 生产   等待队列
    private Condition produceCondition = lock.newCondition();
    // 消费者 等待队列
    private Condition consumerCondition = lock.newCondition();

    public Product() {
    }

    public Product(int number) {
        this.produceNumber = number;
        this.consumerNumber = number;
    }

    public void produce(){

        lock.lock();
        if(this.status){
            try {
//                this.wait();
                produceCondition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.name = names[this.produceIndex % 3];
        this.price = prices[this.produceIndex % 3];
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.color = colors[this.produceIndex % 3];


        System.out.println(Thread.currentThread().getName()+"\t生产者生产了商品 ：" + this.name  + "\t" + this.color);
//        System.out.println("生产者生产了商品 ：" + this.name + " 价格为 ： " + this.price + "商品的颜色为： " + this.color + "  产品状态：" + this.status);

        this.status = true;

        this.produceIndex++;


        consumerCondition.signal();
//        this.notifyAll();
        lock.unlock();
    }

    public void consumer(){

        lock.lock();
        if(!this.status){
            try {
                consumerCondition.await();
//                this.wait();  //让出了cpu ， 并且让出了锁(还开锁)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println(Thread.currentThread().getName()+"\t消费者消费了商品 ：" + this.name  + "\t" + this.color);
//        System.out.println("消费者生产了商品 ：" + this.name + " 价格为 ： " + this.price + "商品的颜色为： " + this.color + "产品状态：" + this.status);
        this.name= "已消费";
        this.status = false;

//        this.notifyAll();
        produceCondition.signal(); // 唤醒任意一个
        lock.unlock();
    }

}
