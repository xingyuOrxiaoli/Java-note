package collection.third;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.put("1","1");
        map.put("2","22");
        map.put("3","333");

        System.out.println(map);
    }
}
