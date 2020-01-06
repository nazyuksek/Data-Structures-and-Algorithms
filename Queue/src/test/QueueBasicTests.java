package test;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import queue.Queue;

class QueueBasicTests {

	@Test
	void testEnqueueInt() {
		Queue<Integer> queue = new Queue<Integer>();
		if (queue.length != 0) {
			fail("Queue is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}
		if (queue.length != 1000) {
			fail("Queue lenght is inconsistent. Expected: 1000 Found: " + queue.length);
		}
	}

	@Test
	void testEnqueueString() {
		Queue<String> queue = new Queue<String>();
		if (queue.length != 0) {
			fail("Queue is not empty initially.");
		}
		String str = "qwertyuiop";
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(str.substring(0, ((int) Math.random() % (str.length() - 2)) + 1));
		}
		if (queue.length != 1000) {
			fail("Queue lenght is inconsistent. Expected: 1000 Found: " + queue.length);
		}
	}

	@Test
	void testEnqueueInception() {
		Queue<Queue<Integer>> queue = new Queue<Queue<Integer>>();
		if (queue.length != 0) {
			fail("Queue is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(new Queue<Integer>());
		}
		if (queue.length != 1000) {
			fail("Queue lenght is inconsistent. Expected: 1000 Found: " + queue.length);
		}
	}

	@Test
	void testPeek() {
		Queue<Integer> queue = new Queue<Integer>();
		if (queue.length != 0) {
			fail("Queue is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 2000; i++) {
			Integer peek = queue.peek();
			if (peek != 0) {
				fail("Peek expected 0 to return, returned: " + peek);
			}
		}
		if (queue.length != 1000) {
			fail("Queue lenght is inconsistent. Expected: 1000 Found: " + queue.length);
		}
	}

	@Test
	void testDequeue() {
		Queue<Integer> queue = new Queue<Integer>();
		if (queue.length != 0) {
			fail("Queue is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 2000; i++) {
			Integer dequeue = queue.dequeue();
			if (i < 1000) {
				if (dequeue != i) {
					fail("Expected element " + i + ", returned: " + dequeue);
				}
			} else {
				if (dequeue != null) {
					fail("Expected null, returned: " + dequeue);
				}
			}
		}
	}

}
