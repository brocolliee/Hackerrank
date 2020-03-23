# Stacks and Queues

*Hackerrank Data Structures Stacks and Queues강의 참고*

#### Commons

- both linear data structure
- flexible size



#### Differences

- how elements are removed 
  - **Last In First Out => stack**
  - **First In first out => queue**



### Stacks

~~~java
public class Stack {
	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		return top.data;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}
	
}
// null point exception is not handled. If exception handling is needed add code.
~~~



### Queue

~~~~java
public class Queue {
	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int peek() {
		return head.data;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if( tail != null) {
			tail.next = node;
		}
		tail = node;
		if( head == null) {
			head = node;
		}
	}
	
	public int remove() {
		int data = head.data;
		head = head.next;
		if( head == null) {
			tail = null;
		}
		return data;
	}
}

~~~~

