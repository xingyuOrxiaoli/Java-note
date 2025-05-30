package thread;

public class RunnableTest1 {
    public static void main(String[] args) {

        Runnable runnable1 = new Student1Runnable();
        Runnable runnable2 = new Student2Runnable();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        
        while(true){
            System.out.println("老师在跑，加油\t" + Thread.currentThread().getName() + "  " +  Thread.currentThread().getPriority());
        }
    }
}

// 线程类
class Student1Runnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("学生1 在跑，加油 \t" + Thread.currentThread().getName() + "  " + Thread.currentThread().getPriority());
        }
    }
}
class Student2Runnable implements Runnable{
@Override
    public void run() {
        while (true) {
            System.out.println("学生2 在跑，加油 \t" +  Thread.currentThread().getName() + "  " + Thread.currentThread().getPriority());
        }
    }
}
