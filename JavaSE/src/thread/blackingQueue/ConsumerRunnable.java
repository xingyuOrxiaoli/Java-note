package thread.blackingQueue;

import thread.producerConsumer.Vn_n_lock.ProductFactory;

public class ConsumerRunnable implements Runnable{

    private ProductFactory productFactory;

    public ConsumerRunnable() {
    }

    public ConsumerRunnable(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1);
                productFactory.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
