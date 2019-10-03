package Tree;

import java.util.Arrays;

class HNode {
	HNode left;
	HNode right;
	int data;

	public HNode(int data) {
		super();
		this.data = data;
	}

	public HNode getLeft() {
		return left;
	}

	public void setLeft(HNode left) {
		this.left = left;
	}

	public HNode getRight() {
		return right;
	}

	public void setRight(HNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

public class MaxHeap {
	int[] heap;
	HNode root;

	MaxHeap(int[] arr) {
		heap = arr;
		insert();
		root = convertToTree(root, heap, 0);
	}

	private void insert() {
		for (int i = 1; i < heap.length; i++) {
			int parentIndex = (i - 1) / 2;
			int j = i;
			while (parentIndex >= 0) {
				if (heap[parentIndex] < heap[j]) {
					int temp = heap[parentIndex];
					heap[parentIndex] = heap[j];
					heap[j] = temp;
					j = parentIndex;
					parentIndex = (j - 1) / 2;
				} else {
					parentIndex = -1;
				}
			}
		}
	}

	private HNode convertToTree(HNode node, int[] heap, int index) {
		node = new HNode(heap[index]);
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (leftChild <= heap.length - 1)
			node.setLeft(convertToTree(node.getLeft(), heap, leftChild));
		if (rightChild <= heap.length - 1)
			node.setRight(convertToTree(node.getRight(), heap, rightChild));

		return node;
	}

	public void inOrder() {
		System.out.println("InOrder Traversal");
		inOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}

	private void inOrder(HNode node) {
		if (node == null) {
			System.out.println("No data");
		} else {
			if (node.getLeft() != null)
				inOrder(node.getLeft());
			System.out.print(node.data + " ");
			if (node.getRight() != null)
				inOrder(node.getRight());
		}
	}

	public void preOrder() {
		System.out.println("PreOrder Traversal");
		preOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}

	private void preOrder(HNode node) {
		if (node == null) {
			System.out.println("No data");
		} else {
			System.out.print(node.data + " ");
			if (node.getLeft() != null)
				preOrder(node.getLeft());
			if (node.getRight() != null)
				preOrder(node.getRight());
		}
	}

	public void postOrder() {
		System.out.println("PostOrder Traversal");
		postOrder(root);
		System.out.println();
		System.out.println("---------------------------------------");
	}

	private void postOrder(HNode node) {
		if (node == null) {
			System.out.println("No data");
		} else {
			if (node.getLeft() != null)
				postOrder(node.getLeft());
			if (node.getRight() != null)
				postOrder(node.getRight());
			System.out.print(node.data + " ");
		}

	}

	public int countNodes() {
		if (root != null)
			return countNodes(root);
		else
			return 0;
	}

	private int countNodes(HNode node) {
		int count = 0;
		if (node != null)
			count++;
		if (node.getLeft() != null)
			count += countNodes(node.getLeft());
		if (node.getRight() != null)
			count += countNodes(node.getRight());

		return count;
	}

	public boolean isEmpty() {
		if (root == null)
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

	public void delete() {
		delete(heap, 0);
	}

	private void delete(int[] heap, int index) {
		if (isEmpty()) {
			System.out.println("Tree is empty");
			return;
		}
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (countNodes() == 1) {
			heap = null;
			return;
		} else if (countNodes() == 2) {
			heap[index] = heap[leftChild];
			return;
		}
		heap[index] = heap[heap.length - 1];
		while (rightChild < heap.length) {
			int swappingIndex = 0;
			if (rightChild > heap.length - 1) {
				if (heap[index] < heap[leftChild])
					swappingIndex = leftChild;
			} else {
				swappingIndex = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
			}
			int temp = heap[index];
			heap[index] = heap[swappingIndex];
			heap[swappingIndex] = temp;
			index = swappingIndex;
			leftChild = (2 * index) + 1;
			rightChild = (2 * index) + 2;
		}
		heap = Arrays.copyOfRange(heap, 0, heap.length - 2);
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(new int[] { 10, 20, 30, 40, 34, 60 });
		for (int i = 0; i < maxHeap.heap.length; i++) {
			System.out.print(maxHeap.heap[i] + " ");
		}
		maxHeap.inOrder();
		maxHeap.preOrder();
		maxHeap.postOrder();
		System.out.println(maxHeap.countNodes());
		System.out.println(maxHeap.height());
		System.out.println(maxHeap.isEmpty());
		maxHeap.delete();
		for (int i = 0; i < maxHeap.heap.length; i++) {
			System.out.print(maxHeap.heap[i] + " ");
		}
	}

}