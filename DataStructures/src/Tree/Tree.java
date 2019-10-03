package Tree;

public class Tree {
	Node root;
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
	public int countNodes() {
		if(root != null)
			return countNodes(root);
		else
			return 0;
	}
	private int countNodes(Node node) {
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
	public int height() {
		return Trees.height(root);
	}
}

