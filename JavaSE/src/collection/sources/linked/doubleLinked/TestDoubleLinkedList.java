package collection.sources.linked.doubleLinked;

import collection.sources.List;

import java.util.LinkedList;

public class TestDoubleLinkedList {
    public static void main(String[] args) {
        List<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("22");
        list.add("333");
        list.add("4444");
        list.add("55555");
        list.add(3,"插入第三个位置");

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println(list.get(2));
        System.out.println(list.toString());

        // TODO 没有实现的功能 测试
//        list.remove(0);
//        System.out.println(list.get(0));
//
//        System.out.println(list.contains("1"));
//        System.out.println(list.indexOf("333"));


    }
}
