package collection.third;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("one");
        set.add("two");
        System.out.println(set);
    }
}
