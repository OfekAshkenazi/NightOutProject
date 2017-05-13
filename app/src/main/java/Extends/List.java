package Extends;

/**
 * Created by Ofek on 17-Apr-17.
 */


public class List<T> {
    Node<T> head;
    Node<T> tail;

    public List() {
        this.head = null;
        this.tail=null;
    }
    public int lengh(){
        Node<T> pos=this.head;
        int count=0;
        while (pos!=null) {
            count++;
            pos=pos.getNext();
        }
        return count;
    }
    boolean isEmpty() {
        return (head == null);
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> listSearch(T x) {
        Node<T> pos = this.head;                  /*select search. not efficient. improve late.*/
        Node<T> pos2 = pos.getNext();                          /*searching for a T element in the list*/
        do {
            if (pos.getInfo()==x)
                return pos;
        }
        while (pos.getInfo() != x && pos.getNext() != null);{
            if (pos2.getInfo() == x)
                return pos2;
            pos = pos2;
            pos2 = pos.getNext();
        }
        return null;                            /*return null if not exist*/
    }
    public Node<T> InsertToEnd(Node<T> Y){
        Node<T> pos=this.tail;
        if (this.head==null) {                      //inserting node to the end of the list
            this.head = Y;                             // if the list empty the node become the head of the list
            this.tail= this.head;
        }
        else {
            pos.setNext(Y);
            this.tail = pos.getNext();
        }
        return this.tail;
    }


    public Node<T> InsertToEnd(T x) {
        Node<T> Y = new Node<T>(x, null);
        Y=InsertToEnd(Y);                          //creating new node and insert him to the last of the list
        return Y;                         // if the list empty the node become the head of the list
    }

    public Node<T> Remove(T clear) {
        Node<T> pos = listSearch(clear);                        /*searching for the element and removes him from the list*/
            if (pos!=null)                                      /*returns null if the element not exist in the list*/
                pos.setNext(pos.getNext().getNext());
        System.out.println("the node is not in the list");
        return null;
    }

}

