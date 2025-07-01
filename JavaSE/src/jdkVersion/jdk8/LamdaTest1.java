package jdkVersion.jdk8;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class LamdaTest1 {
    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("=====");
        }).start();

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        TreeSet<String> set = new TreeSet<>(stringComparator);  //使用匿名内部类实现 降序

        set = new TreeSet<>((o1,o2)-> o2.compareTo(o1)); // 使用lamda表达式实现上述匿名内部类实现的功能
        Collections.addAll(set, "a", "b", "c");
        System.out.println(set);


    }
}

@FunctionalInterface
interface FunctionInterface{
    public void fun();

    default void fun2(){
        System.out.println("fun2");
    }

}
