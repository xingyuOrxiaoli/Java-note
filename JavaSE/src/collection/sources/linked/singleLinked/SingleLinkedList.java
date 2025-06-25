package collection.sources.linked.singleLinked;

import collection.sources.Iterator;
import collection.sources.List;
import collection.sources.IndexOutOfBoundsException;


public class SingleLinkedList<T> implements List<T> {

    private SingleNode head = new SingleNode();

    private int size ;



    @Override
    public int size() {
        return this.size;
    }
    private SingleNode getNode(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        SingleNode curNode = this.head;
        while(index != -1){
            curNode = curNode.getNext();
            index --;
        }
        return curNode;
    }
    @Override
    public T get(int index) {
        SingleNode node = this.getNode(index);
        return (T) node.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public void add(int index, Object element) {
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException("指定添加元素的索引太大或者太小"+ index);
        }

        SingleNode curNode = this.head;
        if(index > 0){
             curNode = this.getNode(index - 1);
        }

        SingleNode newNode = new SingleNode(element,curNode.getNext());
        curNode.setNext(newNode);
        this.size ++;

    }

    @Override
    public void add(Object element) {
        this.add(this.size,element);
    }

    @Override
    public boolean addBefore(Object element1, Object element2) {
        return false;
    }

    @Override
    public boolean addAfter(Object element1, Object element2) {
        return false;
    }

    @Override
    public T remove(int index) {
        SingleNode curNode = this.head;
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("超过数组的长度  "+ index);
        }
        if(index > 0){
            curNode = this.getNode(index - 1);
        }
        curNode.setNext(curNode.getNext().getNext());
        this.size -- ;
        return null;
    }

    @Override
    public Object replace(int index, Object element) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        SingleNode curNode = this.head.getNext();
        while(curNode != null){
            res.append(curNode.getData() +",");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }
}
