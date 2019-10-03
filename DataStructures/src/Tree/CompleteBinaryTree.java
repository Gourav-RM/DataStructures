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
}
