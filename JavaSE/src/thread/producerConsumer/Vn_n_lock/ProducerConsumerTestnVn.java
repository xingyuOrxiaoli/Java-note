package thread.producerConsumer.Vn_n_lock;

public class ProducerConsumerTestnVn {


    public static void main(String[] args) {

        ProductFactory productFactory = new ProductFactory();

        int n = 10 ; // 生产者的数量
        ProductRunnable productRunnable = new ProductRunnable(productFactory);
        for(int  i = 0 ; i < n ; i ++){
            new Thread(productRunnable,"生产者 "  + i).start();
        }

        ConsumerRunnable consumerRunnable = new ConsumerRunnable(productFactory);
        int m = 10 ; // 消费者的数量
        for(int  i = 0 ; i < m ; i ++){
            new Thread(consumerRunnable, "消费者 " + i).start();
        }


    }
}
