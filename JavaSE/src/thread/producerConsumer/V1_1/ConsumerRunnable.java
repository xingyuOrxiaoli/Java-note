package thread.producerConsumer.V1_1;

public class ConsumerRunnable implements Runnable{
    private Product product;
    private int number;

    public ConsumerRunnable(Product product , int number) {
        this.product = product;
        this.number = number;
    }
    @Override
    public void run() {
        while(this.number > 0 ) {
            this.product.consumer();
            this.number--;
        }
    }
}
