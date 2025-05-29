package ds.stack;

public class Stack<T> {
	
	private static class Node<T>{
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> top;
	private int size;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public T pop() {
		if(isEmpty())
			throw new IllegalStateException("Stack is empty");
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}
	
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Stack is empty");
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	
    	Node<T> current = top;
    	while(current != null) {
    		sb.append(current.data);
    		if(current.next != null) {
    			sb.append("->");
    		}
    		current = current.next;
    	}
    	sb.append("]");
    	return sb.toString();
    }
}
