package thread.blackingQueue;

import thread.producerConsumer.Vn_n_lock.ProductFactory;

public class ProductRunnable implements Runnable{

    private ProductFactory productFactory;

    public ProductRunnable() {
    }

    public ProductRunnable(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }
    @Override
    public void run() {
        int index = 0 ;
        while (true){
            try {
                Thread.sleep(100);
                productFactory.produce("商品" +index);
                index ++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
