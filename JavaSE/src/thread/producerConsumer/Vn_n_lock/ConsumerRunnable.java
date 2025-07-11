package thread.producerConsumer.Vn_n_lock;

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
                Thread.sleep(10);
                productFactory.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
