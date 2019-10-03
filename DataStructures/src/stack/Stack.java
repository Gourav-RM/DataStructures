package stack;

public class Stack {
	
	int[] stack;
	int size;
	int top;
	Stack(){
		top = -1;
	}
	Stack(int[] stack){
		this.stack = stack;
		top = stack.length - 1;
		size = top + 1;
	}
	public boolean isEmpty() {
		return top < 0 ? true : false;
	}
	public boolean isFull() {
		return top == stack.length -1 ? true : false;
	}
	public void push(int data) {
		if(isFull()) {
			System.out.println("Tree is full");
			return;
		}else {
			top += 1;
			stack[top] = data;
			size++;
		}
	}
	public void pop() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
			return;
		}else {
			top = top - 1;
			size--;
		}
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
			return -1;
		}else {
			return stack[top];
		}
	}
	public int size() {
		return size;
	}
	public void show() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
		}else {
			for(int i=top;i>=0;i--) {
				System.out.println(stack[i]);
			}
		}
	}
}
