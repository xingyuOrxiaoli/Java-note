package collection.sources;

public interface List<T> {


    // 返回线性表的大小，即数据元素的个数
    public int size();

    // 返回线性表中序列号为i的数据元素
    public T get(int index);

    // 判断线性表是否为null
    public boolean isEmpty();


    // 判断线性表时候包含元素
    public boolean contains(T element);

    // 返回元素在线性表中的序号
    public int indexOf(T element);

    // 将数据元素查到线性表中index的位置
    public void add(int index, T element);

    // 插入元素到线性表的末尾
    public void add(T element);

    // 将数据元素插入到element1之前
    public boolean addBefore(T element1 , T element2);

    // 将数据元素插入到element1之后
    public boolean addAfter(T element1 , T element2);

    // 删除线性表序列号为index的元素
    public T remove(int index);

    // 替换线性表i中的元素，并返回原数据元素
    public T replace(int index, T element);

    // 返回一个迭代器
    public Iterator<T> iterator();

}
