package collection;


import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        Set<String> set = new TreeSet<String>();

        // 添加元素
        set.add("Java");
        set.add("Java"); // 唯一
        set.add("MySQL");
        set.add("JavaEE");
        set.add("SSM");
        set.add("HTML");


        // 有序应该为 : [HTML, Java, JavaEE, MySQL, SSM]
        // 输出的为   : [HTML, Java, JavaEE, MySQL, SSM]
        System.out.println(set);

    }

}
