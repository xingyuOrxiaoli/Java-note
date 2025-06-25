package collection.sources.arrayList;

import collection.sources.IndexOutOfBoundsException;
import collection.sources.Iterator;
import collection.sources.List;

public class ArrayList<T> implements List<T> {

    // 底层数组的引用
    private transient Object[] elementData;

    // 元素个数
    private int size;

    private int capacity;

    public ArrayList(){
        this(2); // JDK7默认的为 10
    }
    public ArrayList(int capacity) {
        this.capacity = capacity;
        elementData = new Object[this.capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        if(index >= this.size || index < 0 ){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        return (T) elementData[index];
    }


    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < this.size; i++){
            if(element != null && get(i).equals(element)){
                return i;
            }else if(element == null && get(i) == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, T element) {
        if(this.size == this.capacity){
            grow();
        }
        for(int i = this.size ; i > index ; i--){
            elementData[i] = this.elementData[i - 1];
        }
        this.elementData[index] = element;
    }

    @Override
    public void add(T element) {
        if(this.size == this.capacity){
            grow();
        }
        elementData[this.size++] = element;
    }

    // 扩容代码
    private void grow() {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object[] newElementData = new Object[newCapacity];
        for (int i = 0 ; i < oldCapacity ; i++){
            newElementData[i] = this.elementData[i];
        }
        this.elementData = newElementData;
        this.capacity = newCapacity;

        // 代替的方式 下面一行就是上面代码实现的功能
//        this.elementData =
//                Arrays.copyOf(this.elementData , this.elementData.length + (this.elementData.length >> 1));

    }

    @Override
    public boolean addBefore(T element1, T element2) {
        return false;
    }

    @Override
    public boolean addAfter(T element1, T element2) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T replace(int index, T element) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0 ; i < this.size ; i++){
            builder.append(this.elementData[i]+",");
        }
        if(this.size > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    private class Itr implements Iterator<T> {
        private int cursor = 0 ;
        @Override
        public boolean hasNext() {
            return this.cursor != size;
        }

        @Override
        public T next() {
            if(this.cursor >= size){
                throw new IndexOutOfBoundsException("元素已经遍历完了。");
            }
            return (T) elementData[cursor++];
        }
    }
}
