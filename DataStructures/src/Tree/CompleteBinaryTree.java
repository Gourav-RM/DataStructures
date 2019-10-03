package Tree;

class CBTNode{
	CBTNode left;
	CBTNode right;
	int data;
	
	CBTNode(int data){
		this.data = data;
	}

	public CBTNode getLeft() {
		return left;
	}

	public void setLeft(CBTNode left) {
		this.left = left;
	}

	public CBTNode getRight() {
		return right;
	}

	public void setRight(CBTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}

public class CompleteBinaryTree {
	
	CBTNode root;
	
	public void insert(int[] arr) {
		root = insert(root,arr,0);
	}
	private CBTNode insert(CBTNode node,int[] arr,int index) {
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
	private void inOrder(CBTNode node) {
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
	private void preOrder(CBTNode node) {
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
	private void postOrder(CBTNode node) {
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
	private int countNodes(CBTNode node) {
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
		return CBTrees.height(root);
	}
	public static void main(String[] args) {
		CompleteBinaryTree tree = new CompleteBinaryTree();
		int[] arr = new int[] {10,20,30,40,50,60};
		tree.insert(arr);
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		System.out.println(tree.countNodes());
		System.out.println(tree.height());
		tree.clear();
		System.out.println(tree.countNodes());
		
	}

}
