package tree;

public class BinarySearchTreeNode<T extends Comparable<T>> extends Node<T> {

	private BinarySearchTreeNode<T> right = null;
	private BinarySearchTreeNode<T> left = null;
	private BinarySearchTreeNode<T> parent = null;
	private T value;

	public BinarySearchTreeNode(T value) {
		this.value = value;
	}

	public BinarySearchTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode<T> right) {
		this.right = right;
	}

	public BinarySearchTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode<T> left) {
		this.left = left;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public BinarySearchTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BinarySearchTreeNode<T> parent) {
		this.parent = parent;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinarySearchTreeNode<T> other = (BinarySearchTreeNode<T>) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public boolean isLeaf() {
		return this.getLeft() == null && this.getRight() == null;
	}
	
	public boolean hasOneChild() {
		return (this.getLeft() != null && this.getRight() == null) || (this.getRight() != null && this.getLeft() == null);
	}

	

}
