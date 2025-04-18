package ctci.linkedList.basics;

public class Node{
    int data;
    Node next;

    public Node(int d){
        this.data = d;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
