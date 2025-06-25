package collection.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class OtherTest {
    public static void main(String[] args) {
        // 第一代
        Vector<String> v1 = new Vector();
        v1.add("a");
        v1.add("b");
        System.out.println(v1.get(1));

        // 第二代
        ArrayList<String> v2 = new ArrayList<String>();
        v2.add("a");
        v2.add("b");
        System.out.println(v2.get(1));

        // 第二代变成安全
        List<String> v2_s = Collections.synchronizedList(v2);
        System.out.println(v2_s == v2);

    }
}
