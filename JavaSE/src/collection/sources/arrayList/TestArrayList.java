package collection.sources.arrayList;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        list.remove(0);

    }
}
