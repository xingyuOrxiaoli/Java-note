package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetAboutStudent {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<Student>();

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

        System.out.println("======== 使用外部比较类  进行降序 优先使用外部比较器========");
        // 使用外部比较类  进行降序
        Set<Student> set2 = new TreeSet<>(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return -(o1.getSno() - o2.getSno());
            }
        });
        set2.add(student1);
        set2.add(student2);
        set2.add(student3);
        set2.add(student4);
        set2.add(student5);

        set2.forEach(System.out::println);

    }
}
