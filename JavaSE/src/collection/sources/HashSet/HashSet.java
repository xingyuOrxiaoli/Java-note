package collection.sources.HashSet;


import collection.sources.Set;
import collection.sources.hashMap.HashMap;

public class HashSet<T> implements Set<T> {

    private HashMap<T,Object> map;
    private static final Object PRESENT = new Object();

    public HashSet() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(T value) {
        map.put(value,PRESENT);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean contains(T value) {
        return this.map.get(value) != null;
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}
