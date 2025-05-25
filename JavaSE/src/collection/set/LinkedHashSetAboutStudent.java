package collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetAboutStudent {
    public static void main(String[] args) {
        Set<Student> set = new LinkedHashSet<Student>();

        Student student1 = new Student(1, "小李1号", 18, 80);
        Student student2 = new Student(2, "小李2号", 19, 81);
        Student student3 = new Student(3, "小李3号", 20, 82);
        Student student4 = new Student(4, "小李4号", 21, 83);
        Student student5 = new Student(1, "小李1号", 18, 80);

        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);
        System.out.println(set.size());

        set.forEach(System.out::println);

    }
}
