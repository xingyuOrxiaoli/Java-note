package thread.producerConsumer.V1_1;

public class ProducerConsumerTest1V1 {
    public static void main(String[] args) {
        Product product = new Product();

        Runnable runnable1 = new ProductRunnable(product,100);
        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = new ConsumerRunnable(product,100);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
