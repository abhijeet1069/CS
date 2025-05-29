package ds.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testPush() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertTrue("[4->3->2->1]".equals(stack.toString()));
	} 

	@Test
	void testPop() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		assertTrue("[2->1]".equals(stack.toString()));
	}
	
	@Test
	void testPopWithException() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		
		IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
			stack.pop();
        });
		assertEquals("Stack is empty", ex.getMessage());
	}

	@Test
	void testPeek() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1,stack.peek());
	}

	@Test
	void testIsEmpty() {
		Stack<String> stack = new Stack<>();
		stack.push("Plate1");
		stack.push("Plate2");
		stack.push("Plate3");
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testGetSize() {
		Stack<String> stack = new Stack<>();
		stack.push("Plate1");
		stack.push("Plate2");
		stack.push("Plate3");
		stack.pop();
		stack.pop();
		assertEquals(1,stack.getSize());
	}

}
