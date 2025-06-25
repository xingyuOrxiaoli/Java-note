package collection.sources.HashSet;


public class TestHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet();

        set.add("1");
        set.add("22");
        set.add("333");
        set.add("4444");
        set.add("55555");

        System.out.println(set.size());
        System.out.println(set.contains("1"));
        System.out.println(set);
    }
}
