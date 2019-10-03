package Tree;

class BSTNode extends Node{	
	BSTNode(int data){
		this.data = data;
	}
}

public class BinarySearchTree extends Tree{
	
	public void insert(int data) {
		root = insert(root,data);
	}
	private Node insert(Node node,int data) {
		if(node == null)
			node = new BSTNode(data);
		else if(node.getData() > data)
			node.left = insert(node.getLeft(),data);
		else
			node.right = insert(node.getRight(),data);
		
		return node;
	}
	
	public boolean search(int data) {
		return search(root,data);
	}
	private boolean search(Node node,int data) {
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
	
	public void delete(int data) {
		if(this.search(data) == true)
			root = delete(root,data);
		else
			System.out.println("The element is not presemt in the tree");
	}
	private Node delete(Node node,int data) {
		if(node == null) {
			return null;
		}else if(node.getData() == data) {
			if(Trees.isLeafNode(node))
				return null;
			else if((node.getRight() != null) && (node.getLeft() != null)){
				Node leftElementRoot = node.getRight();
				Node prevLeftRoot = node.getLeft();
				Node tempElement = node;
				while(!Trees.isLeafNode(tempElement.getRight())) {
					tempElement = tempElement.getRight();
				}
				Node replacingElement = tempElement.getRight();
				tempElement.setRight(null);
				replacingElement.setLeft(leftElementRoot);
				node = replacingElement;
				Node lastLeftElement = leftElementRoot;
				while(lastLeftElement.getLeft() != null) {
					lastLeftElement = lastLeftElement.getLeft();
				}
				lastLeftElement.setLeft(prevLeftRoot);
			}else {
				if(node.getLeft() != null)
					return node.getLeft();
				else
					return node.getRight();
			}
		}else {
			if(node.getData() > data)
				node.setLeft(delete(node.getLeft(),data));
			else
				node.setRight(delete(node.getRight(),data));
		}
		return node;
	}	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(90);
		tree.insert(100);
		tree.insert(40);
		tree.insert(10);
		tree.insert(70);
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		System.out.println(tree.countNodes());
		System.out.println(tree.isEmpty());
		tree.delete(40);
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		System.out.println(tree.isEmpty());
		tree.clear();
		System.out.println(tree.isEmpty());
	}
	
}
