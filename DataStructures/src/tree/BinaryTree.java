//Binary Tree implementation
package tree;

class BTNode{
	BTNode left;
	BTNode right;
	int data;
	
	BTNode(int data){
		this.data = data;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}

public class BinaryTree {
	
	BTNode root;
	
	public void insert(int data) {
		root = insert(root,data);
	}
	private BTNode insert(BTNode node,int data) {
		if(node == null) {
			node = new BTNode(data);
		}else if(node.getRight() == null) {
			node.right = insert(node.getRight(),data);
		}else {
			node.left = insert(node.getLeft(),data);
		}
		return node;
	}
	
	public void inOrder() {
		System.out.println("InOrder Traversal");
		inOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	private void inOrder(BTNode node) {
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
	private void preOrder(BTNode node) {
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
	private void postOrder(BTNode node) {
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
	public boolean search(int data) {
		return search(root,data);
	}
	private boolean search(BTNode node,int data) {
		if(node != null) {
			if(node.data == data)
				return true;
			if(node.getLeft() != null) {
				if(search(node.getLeft(),data));
					return true;
			}
			if(node.getRight() != null) {
				if(search(node.getRight(),data));
					return true;
			}
		}
		return false;
	}
	public int countNodes() {
		if(root != null)
			return countNodes(root);
		else
			return 0;
	}
	private int countNodes(BTNode node) {
		int count = 0;
		if(node != null)
			count++;
		if(node.getLeft() != null)
			count += countNodes(node.getLeft());
		if(node.getRight() != null)
			count += countNodes(node.getRight());
		
		return count;
	}
	public boolean isEmpty() {
		if(root == null)
			return true;
		else
			return false;
	}
	public void clear() {
		root = null;
	}
}