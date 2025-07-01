package jdkVersion.jdk8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        Collections.addAll(list,"z","a", "b","c","d","e","f","g","h");
        Stream<String> stream = list.stream();

        stream.forEach(System.out::println); // stream已经被消费了
        System.out.println("===================");

        stream = list.stream(); // 一个新的stream
        stream.filter(value -> value.compareTo("c") >= 0).forEach(System.out::println);
        System.out.println("===================");

        stream = list.stream(); // 一个新的stream
        stream.filter(value -> value.compareTo("d") >= 0)
                .sorted() // 排序
                .limit(3)
                .forEach(System.out::println);



    }
}
