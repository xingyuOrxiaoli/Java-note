package collection.map;

import java.util.*;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new LinkedHashMap();

        // 添加k-v对
        map.put(3, "three");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");


        map.put(null,"null");

        // 输出数据
        System.out.println(map.get(1));
        map.forEach((k,v)->System.out.println(k + " == " + v));


        System.out.println(" ======== 自定义类做key ========");

        Map<Student,String> map2 = new LinkedHashMap();

        Student student1 = new Student(1, "小李1号");
        Student student2 = new Student(2, "小李2号");
        Student student3 = new Student(3, "小李3号");
        Student student4 = new Student(1, "小李1号");

        map2.put(student1,"小李1号");
        map2.put(student2,"小李2号");
        map2.put(student3,"小李3号");
        map2.put(student4,"小李4号");

        System.out.println(map2.size());
        System.out.println(map2.get(student4));

        map2.forEach((k,v)->System.out.println(k + " == " + v));
    }
}
