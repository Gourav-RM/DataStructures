package queue;

public class CircularQueue extends Queues{

	public CircularQueue(int length) {
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
		}else if(front == 0){
			rear += 1;
			queue[rear] = data;
			size++;
		}else {
			rear= 0;
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
	@Override
	public String toString() {
		String q = "";
		if(rear < front) {
			for(int i=front;i<size;i++) {
				q = q + queue[i]+" ";
			}
			for(int i=0;i<=rear;i++) {
				q = q + queue[i]+" ";
			}
		}else {
			for(int i=front;i<=rear;i++) {
				q = q + queue[i]+" ";
			}
		}
		
		return q;
	}
}
