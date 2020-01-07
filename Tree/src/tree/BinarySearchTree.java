package tree;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

	private BinarySearchTreeNode<T> root = null;

	public void insert(T el) {
		BinarySearchTreeNode<T> node = new BinarySearchTreeNode<T>(el);
		if (root == null) {
			this.root = node;
		} else {
			BinarySearchTreeNode<T> currentNode = this.root;
			while (insertGetTarget(currentNode, node) != null && insertGetTarget(currentNode, node) != node) {
				currentNode = insertGetTarget(currentNode, node);
			}
			if (currentNode.getValue().compareTo(node.getValue()) < 0) {
				currentNode.setRight(node);
				node.setParent(currentNode);
			} else if (currentNode.getValue().compareTo(node.getValue()) > 0) {
				currentNode.setLeft(node);
				node.setParent(currentNode);
			}
		}

	}

	public BinarySearchTreeNode<T> insertGetTarget(BinarySearchTreeNode<T> node, BinarySearchTreeNode<T> insertedNode) {
		if (node.getValue().compareTo(insertedNode.getValue()) < 0) {
			return node.getRight();
		} else if (node.getValue().compareTo(insertedNode.getValue()) > 0) {
			return node.getLeft();
		} else {
			return insertedNode;
		}
	}

	public int countLeaves() {
		return countLeavesSubTree(this.root);
	}

	public static int countLeavesSubTree(BinarySearchTreeNode<?> root) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		} else {
			return countLeavesSubTree(root.getLeft()) + countLeavesSubTree(root.getRight());

		}

	}

	public int getDepth() {
		return getDepthSubTree(this.root);
	}

	public static int getDepthSubTree(BinarySearchTreeNode<?> root) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		} else {
			return Math.max(getDepthSubTree(root.getRight()), getDepthSubTree(root.getLeft())) + 1;
		}
	}

	public void delete(T el) {
		BinarySearchTreeNode<T> nodeToDelete = find(el);
		if (nodeToDelete == null)
			return;
		if (nodeToDelete.isLeaf())
			nodeToDelete = null;
		if (nodeToDelete.hasOneChild()) {
			if (nodeToDelete.getLeft() == null) {
				nodeToDelete.getRight().setParent(nodeToDelete.getParent());
				nodeToDelete = nodeToDelete.getRight();
			} else {
				nodeToDelete.getLeft().setParent(nodeToDelete.getParent());
				nodeToDelete = nodeToDelete.getLeft();
			}
		} else {
			BinarySearchTreeNode<T> min = (BinarySearchTreeNode<T>) findMin(nodeToDelete.getRight());
			nodeToDelete.setValue(min.getValue());
			min = null;
		}

	}

	public static BinarySearchTreeNode<?> findMin(BinarySearchTreeNode<?> root) {
		BinarySearchTreeNode<?> currentNode = root;
		while (currentNode.getLeft() != null)
			currentNode = currentNode.getLeft();
		return currentNode;
	}

	public BinarySearchTreeNode<T> find(T el) {
		if (root == null)
			return null;
		else {
			BinarySearchTreeNode<T> currentNode = this.root;
			while (currentNode.getValue() != el) {
				if (currentNode.getValue().compareTo(el) > 0)
					currentNode = currentNode.getLeft();
				else if (currentNode.getValue().compareTo(el) < 0)
					currentNode = currentNode.getRight();
				if (currentNode == null)
					return null;
			}
			return currentNode;

		}
	}

	public boolean isBalanced() {
		if(this.root == null) return true;
		return isBalancedSubTree(this.root);
	}

	public static boolean isBalancedSubTree(BinarySearchTreeNode<?> root) {
		if(root == null) return true;
		return isBalancedSubTreeHelper(root) && isBalancedSubTree(root.getLeft()) && isBalancedSubTree(root.getRight());
	}

	private static boolean isBalancedSubTreeHelper(BinarySearchTreeNode<?> root) {
		if (root == null)
			return true;
		return Math.abs(getDepthSubTree(root.getLeft()) - getDepthSubTree(root.getRight())) <= 1;
	}

}
