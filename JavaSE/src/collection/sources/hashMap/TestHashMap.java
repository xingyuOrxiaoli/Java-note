package collection.sources.hashMap;

import java.util.Arrays;
//import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"value1");
        map.put(2,"value2");
        map.put(3,"value3");
        map.put(4,"value4");
        map.put(5,"value5");
        map.put(6,"value6");
        map.put(7,"value7");
        map.put(7,"value7副本");

        System.out.println(map.size());
//        System.out.println(Arrays.toString(map.table));
        System.out.println(map.get(7));
        System.out.println(map.get(9));
        System.out.println(map);

    }
}
