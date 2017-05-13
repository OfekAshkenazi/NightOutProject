package Extends;

/**
 * Created by Ofek on 17-Apr-17.
 */
public class Node<T> {
    private T info;
    private Node<T> next;

    public Node(T initialData, Node<T> initialLink) {
        info = initialData;
        next = initialLink;
    }


    public void setNext(Node<T> next) {
        this.next=next;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }


    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}