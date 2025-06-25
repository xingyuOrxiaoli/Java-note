package collection.sources;

public interface Set<T> {

    public void add(T value);
    public int size();
    public boolean contains(T value);
    public boolean isEmpty();

}
