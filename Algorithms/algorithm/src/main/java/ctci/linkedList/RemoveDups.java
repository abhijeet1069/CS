package ctci.linkedList;

import ctci.linkedList.basics.LinkedList;
import ctci.linkedList.basics.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    public static void removeDups(LinkedList list){
        Node left = list.getHead();
        Node right = list.getHead();
        Set<Integer> set = new HashSet<>();
        while(right != null){
            if(set.contains(right.getData()))
                left.setNext(right.getNext());
            else{
                set.add(right.getData());
                left = right;
            }
            right = right.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.print();
        removeDups(list);
        list.print();
    }
}
