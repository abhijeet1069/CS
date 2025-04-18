package ctci.linkedList.basics;

public class LinkedList {
    Node head;

    public LinkedList(int data){
        this.head = new Node(data);
    }

    public void add(int data){
        Node end = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = end;
    }

    public void print() {
        Node temp = this.head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void deleteNode(int data){
        Node temp = head;
        if(temp.data == data)
            head = head.next;

        while(temp.next != null){
            if(temp.next.data == data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }
    public Node getHead() {
        return head;
    }
}
