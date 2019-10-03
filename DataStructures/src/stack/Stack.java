package stack;

public class Stack {
	
	int[] stack;
	int size;
	int top;
	
	public int[] getStack() {
		return stack;
	}
	public void setStack(int[] stack) {
		this.stack = stack;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	Stack(){
		top = -1;
	}
	Stack(int[] stack){
		this.stack = stack;
		setTop(getStack().length-1);
		setSize(getTop()+1);
	}
	public boolean isEmpty() {
		return getTop() < 0 ? true : false;
	}
	public boolean isFull() {
		return getTop() == stack.length -1 ? true : false;
	}
	public void push(int data) {
		if(isFull()) {
			System.out.println("Tree is full");
			return;
		}else {
			setTop(getTop()+1);
			stack[top] = data;
			setSize(getSize()+1);
		}
	}
	public void pop() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
			return;
		}else {
			setTop(getTop()-1);
			setSize(getSize()-1);
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
		return getSize();
	}
	public void show() {
		if(isEmpty()) {
			System.out.println("Tree is empty");
		}else {
			for(int i=getTop();i>=0;i--) {
				System.out.println(stack[i]);
			}
		}
	}
}
