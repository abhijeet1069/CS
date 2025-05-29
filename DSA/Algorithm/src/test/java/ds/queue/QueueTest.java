package ds.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testEnqueue() {
		Queue<String> queue = new Queue<>();
		String[] strArr = "When a cowboy trades his spurs for wings".split(" ");
		for(String str : strArr)
			queue.enqueue(str);
		assertEquals(8,queue.getSize());
	}

	@Test
	void testDequeue() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(7);
		int el = queue.dequeue();
		assertEquals(2,el);
	}

	@Test
	void testIsEmpty() {
		Queue<Integer> queue = new Queue<>();
		assertTrue(queue.isEmpty());
		
		queue.enqueue(12);
		assertFalse(queue.isEmpty());
	}

	@Test
	void testPeek() {
		Queue<Integer> queue = new Queue<>();
		IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
			queue.peek();
        });
		assertEquals("Queue is empty", ex.getMessage());
		
		queue.enqueue(12);
		queue.enqueue(22);
		assertEquals(12, queue.peek());
	}

	@Test
	void testGetSize() {
		Queue<Integer> queue = new Queue<>();
		assertEquals(0,queue.getSize());
		
		queue.enqueue(12);
		queue.enqueue(22);
		queue.enqueue(24);
		queue.dequeue();
		assertEquals(2, queue.getSize());
	}

}
