package collection.sources.arrayList;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

import collection.sources.Iterator;
import collection.sources.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("22");
        list.add("333");
        list.add("4444");
        list.add("55555");

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.contains("1"));
        System.out.println(list.indexOf("333"));
        System.out.println(list.toString());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

    }
}
