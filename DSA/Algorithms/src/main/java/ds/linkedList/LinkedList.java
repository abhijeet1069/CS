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

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node<T> curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    public T get(int index){
        checkIndex(index);
        Node<T> curr = head;
        for(int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: "+index+" for a list of size: "+size);
    }

    public T remove(int index){
        checkIndex(index);
        T removedData;
        if(index == 0){
            removedData = head.data;
            head = head.next;
        }
        else{
            Node<T> prev = head;
            for(int i = 0; i < index-1; i++)
                prev = prev.next;
            removedData = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removedData;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
