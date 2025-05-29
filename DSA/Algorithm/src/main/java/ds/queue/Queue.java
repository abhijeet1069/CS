package ds.queue;

public class Queue<T> {
	
	private static class Node<T>{
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if(rear != null) 
			rear.next = newNode;
		rear = newNode;
		if(front == null)
			front = newNode;
		size++;
	}
	
	public T dequeue() {
		if(isEmpty())
			throw new IllegalStateException("Queue is empty");
		T data = front.data;
		front = front.next;
		if(front == null)
			rear = null;
		size--;
		return data;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return front.data;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	
    	Node<T> current = front;
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
