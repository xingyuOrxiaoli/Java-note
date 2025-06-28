package thread.producerConsumer.Vn_n_synchronized;

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
                productFactory.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
