package collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();

        // 添加元素
        set.add("Java");
        set.add("Java"); // 唯一
        set.add("MySQL");
        set.add("JavaEE");
        set.add("SSM");
        set.add("HTML");


        // 有序应该为 : [HTML, Java, JavaEE, MySQL, SSM]   -> String比较的顺序
        // 输出的为   : [Java, MySQL, JavaEE, SSM, HTML]  -> 添加顺序
        System.out.println(set);

    }

}
