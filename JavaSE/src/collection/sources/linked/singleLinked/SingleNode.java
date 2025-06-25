package collection.sources.linked.singleLinked;

public class SingleNode<T> {
    private Object data;
    private SingleNode next;

    public SingleNode() {
    }

    public SingleNode(Object data, SingleNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
