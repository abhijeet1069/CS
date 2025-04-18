package knowJava.collections;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Unlike an arraylist which uses a dynamic array to store the elements, a linked list stores its elements as nodes in a
 * doubly linked list.
 *
 * Performance Considerations:
 * - Insertions and Deletions : LinkedList is better for frequent insertions and deletions in the middle of the list as it
 *     does not require shifting of elements as in ArrayList.
 * - Random Access : LinkedList has slower random access (get(index)) compared to ArrayList as it has to traverse the list
 *     from beginning to reach the desired index.
 * - Memory Overhead : LinkedList requires more memory than ArrayList as each node in a linked list requires extra memory
 *     to store references to the next and previous nodes.
 * */
public class KnowLinkedList {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog","Elephant"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
