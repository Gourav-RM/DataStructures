package tree;

import java.util.Arrays;

class MHNode extends Node{
	public MHNode(int data) {
		super();
		this.data = data;
	}
}

public class MinHeap extends Tree{
	int[] heap;

	MinHeap(int[] arr) {
		heap = arr;
		insert();
		root = convertToTree(root, heap, 0);
	}

	private void insert() {
		for (int i = 1; i < heap.length; i++) {
			int parentIndex = (i - 1) / 2;
			int j = i;
			while (parentIndex >= 0) {
				if (heap[parentIndex] > heap[j]) {
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

	private Node convertToTree(Node node, int[] heap, int index) {
		node = new MHNode(heap[index]);
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (leftChild <= heap.length - 1)
			node.setLeft(convertToTree(node.getLeft(), heap, leftChild));
		if (rightChild <= heap.length - 1)
			node.setRight(convertToTree(node.getRight(), heap, rightChild));

		return node;
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
				if (heap[index] > heap[leftChild])
					swappingIndex = leftChild;
			} else {
				swappingIndex = heap[leftChild] < heap[rightChild] ? leftChild : rightChild;
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
		MinHeap maxHeap = new MinHeap(new int[] { 60,50,40,35,20,10 });
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
