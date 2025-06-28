package thread.producerConsumer.V1_1;

public class ProductRunnable implements Runnable{
    private Product product;
    private int index ;
    private int number;

    public ProductRunnable(Product product , int number) {
        this.product = product;
        this.number = number;
    }

    @Override
    public void run() {

        while(this.number > 0 ) {

            product.produce();
            this.number --;
        }


    }
}
