package queue;

public class Queue extends Queues{
	
	public Queue(int length) {
		capacity = length;
		setQueue(new int[length]);
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}else if(isEmpty()){
			front++;
			rear++;
			queue[rear] = data;
			size++;
		}else {
			rear += 1;
			queue[rear] = data;
			size++;
		}
	}
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}else if(containsOneElement()) {
			front--;
			rear--;
			size--;
		}else {
			front++;
			size--;
		}
	}	
}
