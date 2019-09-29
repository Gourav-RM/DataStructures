package Tree;

class BSTNode{
	BSTNode left;
	BSTNode right;
	int data;
	
	BSTNode(int data){
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}

public class BinarySearchTree {
	
	BSTNode root;
	
	public void insert(int data) {
		root = insert(root,data);
	}
	private BSTNode insert(BSTNode node,int data) {
		if(node == null)
			node = new BSTNode(data);
		else if(node.getData() > data)
			node.left = insert(node.getLeft(),data);
		else
			node.right = insert(node.getRight(),data);
		
		return node;
	}
	public void inOrder() {
		System.out.println("InOrder Traversal");
		inOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}
	private void inOrder(BSTNode node) {
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
	private void preOrder(BSTNode node) {
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
	private void postOrder(BSTNode node) {
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
	private boolean search(BSTNode node,int data) {
		if(node == null)
			return false;
		if(node.getData() == data)
			return true;
		else if((node.getLeft() !=null) && (node.getData() > data)) {
			if(search(node.getLeft(),data))
				return true;
		}else if((node.getRight() !=null) && (node.getData() < data)) {
			if(search(node.getRight(),data))
				return true;
		}
		return false;
	}
	public int countNodes() {
		if(root != null)
			return countNodes(root);
		else
			return 0;
	}
	private int countNodes(BSTNode node) {
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
		return BSTrees.height(root);
	}
	public void delete(int data) {
		if(this.search(data) == true)
			root = delete(root,data);
		else
			System.out.println("The element is not presemt in the tree");
	}
	private BSTNode delete(BSTNode node,int data) {
		if(node == null) {
			return null;
		}else if(node.getData() == data) {
			if(BSTrees.isLeafNode(node))
				return null;
			else if((node.getRight() != null) && (node.getLeft() != null)){
				BSTNode leftElementRoot = node.getRight();
				BSTNode prevLeftRoot = node.getLeft();
				BSTNode tempElement = node;
				while(!BSTrees.isLeafNode(tempElement.getRight())) {
					tempElement = tempElement.getRight();
				}
				BSTNode replacingElement = tempElement.getRight();
				tempElement.setRight(null);
				replacingElement.setLeft(leftElementRoot);
				node = replacingElement;
				BSTNode lastLeftElement = leftElementRoot;
				while(lastLeftElement.getLeft() != null) {
					lastLeftElement = lastLeftElement.getLeft();
				}
				lastLeftElement.setLeft(prevLeftRoot);
			}
		}else {
			if(node.getData() > data)
				node.setLeft(delete(node.getLeft(),data));
			else
				node.setRight(delete(node.getRight(),data));
		}
		return node;
	}	
}
