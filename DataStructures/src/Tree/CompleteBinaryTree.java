package Tree;

class CBTNode extends Node{
	CBTNode(int data){
		this.data = data;
	}	
}

public class CompleteBinaryTree extends Tree{
	public void insert(int[] arr) {
		root = insert(root,arr,0);
	}
	private Node insert(Node node,int[] arr,int index) {
		node = new CBTNode(arr[index]);
		int leftChild = (2*index)+1;
		int rightChild = (2*index)+2;
		if(leftChild <= arr.length-1)
			node.setLeft(insert(node.getLeft(),arr,leftChild));
		if(rightChild <= arr.length-1)
			node.setRight(insert(node.getRight(),arr,rightChild));
		
		return node;
	}
	public void inOrder() {
		System.out.println("InOrder Traversal");
		inOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	private void inOrder(Node node) {
		if(node == null) {
			System.out.println("No data");
		}else {
			if(node.getLeft() != null)
				inOrder(node.getLeft());
			System.out.print(node.data+" ");
			if(node.getRight() != null)
				inOrder(node.getRight());
		}
	}
	public void preOrder() {
		System.out.println("PreOrder Traversal");
		preOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	private void preOrder(Node node) {
		if(node == null) {
			System.out.println("No data");
		}else {
			System.out.print(node.data+" ");
			if(node.getLeft() != null)
				preOrder(node.getLeft());
			if(node.getRight() != null)
				preOrder(node.getRight());
		}
	}
	public void postOrder() {
		System.out.println("PostOrder Traversal");
		postOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	private void postOrder(Node node) {
		if(node == null) {
			System.out.println("No data");
		}else {
			if(node.getLeft() != null)
				postOrder(node.getLeft());
			if(node.getRight() != null)
				postOrder(node.getRight());
			System.out.print(node.data+" ");
		}
		
	}
}
