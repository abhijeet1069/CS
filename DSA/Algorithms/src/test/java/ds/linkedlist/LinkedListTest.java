package ds.linkedlist;

import ds.linkedList.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    @Test
    public void testEmptyList(){
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());
    }
}
