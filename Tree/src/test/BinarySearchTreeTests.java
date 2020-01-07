package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tree.BinarySearchTree;

class BinarySearchTreeTests {

	@Test
	void testDepth() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertEquals(0, tree.getDepth());
		tree.insert(5);
		assertEquals(1, tree.getDepth());
		tree.insert(6);
		assertEquals(2, tree.getDepth());
		tree.insert(4);
		assertEquals(2, tree.getDepth());
		tree.insert(4);
		assertEquals(2, tree.getDepth());
		tree.insert(15);
		assertEquals(3, tree.getDepth());
	}

	@Test
	void testLeaves() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertEquals(0, tree.countLeaves());
		tree.insert(3);
		assertEquals(1, tree.countLeaves());
		tree.insert(4);
		assertEquals(1, tree.countLeaves());
		tree.insert(5);
		assertEquals(1, tree.countLeaves());
		tree.insert(2);
		assertEquals(2, tree.countLeaves());
		tree.insert(0);
		assertEquals(2, tree.countLeaves());
	}

	@Test
	void testFind() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(15);
		tree.insert(5);
		tree.insert(4);
		tree.insert(2);
		tree.insert(3);
		tree.insert(7);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(17);
		tree.insert(21);
		tree.insert(0);
		assertNotNull(tree.find(9));
		assertNull(tree.find(35));
		assertEquals(tree.find(5), tree.find(4).getParent());
	}

	@Test
	void testBalanced() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		for(int i = 1; i < 11; i++) {
			tree.insert(i);
		}
		assertFalse(tree.isBalanced());
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		tree2.insert(4);
		tree2.insert(5);
		tree2.insert(2);
		tree2.insert(3);
		tree2.insert(1);
		tree2.insert(6);
		assertTrue(tree2.isBalanced());
		
	}
	
	
}
