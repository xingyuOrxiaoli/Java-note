package thread;

public class ThreadTest1 {
    public static void main(String[] args) {

        Thread thread1 = new Student1Thread();
        Thread thread2 = new Student2Thread();

        thread1.start();
        thread2.start();
        while(true){
            System.out.println("老师在跑，加油\t" + Thread.currentThread().getName() + "  " +  Thread.currentThread().getPriority());
        }
    }
}

// 线程类
class Student1Thread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("学生1 在跑，加油 \t" + this.getName() + "  " + this.getPriority());
        }
    }
}
class Student2Thread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("学生2 在跑，加油 \t" + this.getName() + "  " + this.getPriority());
        }
    }
}
