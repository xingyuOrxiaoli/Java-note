package collection.sources;

public interface Map<K,V> {

    public int size();

    public void put(K key, V value);
    public V get(K key);
    public boolean isEmpty();

    interface Entry<K,V> {
        K getKey();
        V getValue();
//        V setValue(V value);
//        boolean equals(Object o);
//        int hashCode();
    }
}
