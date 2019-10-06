package queue;

public class Queues {
	int front = -1;
	int rear = -1;
	int size;
	int capacity;
	int[] queue;
	
	
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int[] getQueue() {
		return queue;
	}


	public void setQueue(int[] queue) {
		this.queue = queue;
	}


	public int getFront() {
		return front;
	}


	public void setFront(int front) {
		this.front = front;
	}


	public int getRear() {
		return rear;
	}


	public void setRear(int rear) {
		this.rear = rear;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	public boolean isFull() {
		return (front == 0 && rear == capacity - 1) ? true : false;
	}
	public boolean isEmpty() {
		return (front == -1 && rear == -1) ? true : false;
	}
	public boolean containsOneElement() {
		return (front == rear && front == 0) ? true: false;
	}
	@Override
	public String toString() {
		String q = "";
		for(int i=front;i<=rear;i++) {
			q = q + queue[i]+" ";
		}
		return q;
	}
}
