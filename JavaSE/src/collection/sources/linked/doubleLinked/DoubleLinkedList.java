package collection.sources.linked.doubleLinked;

import collection.sources.Iterator;
import collection.sources.List;

public class DoubleLinkedList<T> implements List<T> {

    private transient DoubleNode<T> first;

    // 源码中Node这部分是一个静态内部类
    private transient DoubleNode<T> last;

    private transient int size;

    public DoubleLinkedList() {
    }

    @Override
    public int size() {
        return this.size;
    }

    private DoubleNode getNode(int index){

        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        DoubleNode<T> start = this.first;
        while(start != null){
            res.append(start.getData() +",");
            start = start.getNext();
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("索引超出范围 "+ index);
        }

        return this.node(index).getData();
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
        return 0;
    }

    @Override
    public void add(int index, T element) {


        if(index == this.size)
            this.linkLast(element);
        else
            this.linkBefore(element, this.node(index));
    }



    @Override
    public void add(T element) {
        linkLast(element);
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
        return null;
    }

    private void linkLast(T element) {
        final DoubleNode<T> end  = this.last;
        final DoubleNode<T> newNode = new DoubleNode<>(end,element,null);
        this.last = newNode;
        if(end == null){
            this.first = newNode;
        }else{
            end.setNext(newNode);
        }
        this.size++;
    }

    private void linkBefore(T element, DoubleNode<T> node) {
        final DoubleNode<T> prev  = node.getPrev();
        final DoubleNode<T> newNode = new DoubleNode<>(prev,element,node);
        node.setPrev(newNode);

        if(prev == null){
            this.first = newNode;
        }else{
            prev.setNext(newNode);
        }
        this.size++;
    }
    // 找到指定索引的元素
    private DoubleNode<T> node(int index) {
        if(index < (size >> 1)){ // 前一半的节点   从开始节点寻找
            DoubleNode<T> start = this.first;
            for(int i = 0 ; i < index ;  i++){
                start = start.getNext();
            }
            return start;
        }else{ // 后一半的节点  从最后一个节点逆向寻找
            DoubleNode<T> end = this.last;
            for(int i = this.size - 1 ; i > index ; i--){
                end = end.getPrev();
            }
            return end;
        }
    }
}
