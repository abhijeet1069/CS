package ds.linkedList;

public class LinkedList<T> {

    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;


}
