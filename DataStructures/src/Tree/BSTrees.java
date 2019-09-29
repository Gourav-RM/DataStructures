package Tree;

public class BSTrees {
	public static int height(BSTNode node) {
		int lheight = 1;
		int rheight = 1;
		if(node == null)
			return 0;
		else if(node.getLeft() != null)
			lheight += height(node.getLeft());
		else if(node.getRight() != null)
			rheight += height(node.getRight());
		
	if(lheight > rheight)
		return lheight;
	else
		return rheight;
	}
	public static boolean isLeafNode(BSTNode node) {
		if((node.getLeft() == null) && (node.getRight() == null))
			return true;
		else
			return false;
	}
}
