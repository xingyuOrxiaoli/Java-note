package thread.volatile_guanJianZi;

public class TestVolatile {

    volatile  static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (flag){
//                    System.out.println("==========");
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flag = false;
    }
}
