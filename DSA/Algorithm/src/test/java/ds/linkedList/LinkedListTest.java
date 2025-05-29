package ds.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class LinkedListTest {

	@Test
	public void testAdd() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertTrue("[1->2->3->4]".equals(list.toString()));
	}

	@Test
	public void testGet() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		IndexOutOfBoundsException ex1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });
		IndexOutOfBoundsException ex2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });
		
		assertEquals(new Integer(1), list.get(0));
		assertEquals(new Integer(2), list.get(1));
		assertEquals(new Integer(4), list.get(list.getSize()-1));
        assertEquals("Invalid index: 5 for a list of size: 4", ex1.getMessage());
        assertEquals("Invalid index: 4 for a list of size: 4", ex2.getMessage());
	}

	@Test
	public void testRemove() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(0);
		assertTrue("[2->3->4]".equals(list.toString()));
	}

	@Test
	public void testIsEmpty() {
		LinkedList<String> list = new LinkedList<>();
		list.add("Ini");
		list.add("Mini");
		list.remove(0);
		list.remove(0);
        assertTrue(list.isEmpty());
	}
	
	@Test
	public void testToString() {
		assertTrue("[Fe->Fi->Fo->Fum]".equals(getToStringForStringList()));
		assertTrue("[2->3->4]".equals(getToStringForIntegerList()));
	}
	
	private String getToStringForStringList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("Fe");
		list.add("Fi");
		list.add("Fo");
		list.add("Fum");
		return list.toString();
	}
	
	private String getToStringForIntegerList() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(0);
		return list.toString();
	}

}
