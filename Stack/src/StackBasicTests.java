
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

class StackBasicTests {

	@Test
	void testPushInt() {
		Stack<Integer> stack = new Stack<Integer>();
		if (stack.length != 0) {
			fail("Stack is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
		}
		if (stack.length != 1000) {
			fail("Stack lenght is inconsistent. Expected: 1000 Found: " + stack.length);
		}
	}

	@Test
	void testPushString() {
		Stack<String> stack = new Stack<String>();
		if (stack.length != 0) {
			fail("Stack is not empty initially.");
		}
		String str = "qwertyuiop";
		for (int i = 0; i < 1000; i++) {
			stack.push(str.substring(0, ((int) Math.random() % (str.length() - 2)) + 1));
		}
		if (stack.length != 1000) {
			fail("Stack lenght is inconsistent. Expected: 1000 Found: " + stack.length);
		}
	}

	@Test
	void testPushInception() {
		Stack<Stack<Integer>> stack = new Stack<Stack<Integer>>();
		if (stack.length != 0) {
			fail("Stack is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			stack.push(new Stack<Integer>());
		}
		if (stack.length != 1000) {
			fail("Stack lenght is inconsistent. Expected: 1000 Found: " + stack.length);
		}
	}

	@Test
	void testPeek() {
		Stack<Integer> stack = new Stack<Integer>();
		if (stack.length != 0) {
			fail("Stack is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 2000; i++) {
			Integer peek = stack.peek();
			if (peek != 999) {
				fail("Peek expected 999 to return, returned: " + peek);
			}
		}
		if (stack.length != 1000) {
			fail("Stack lenght is inconsistent. Expected: 1000 Found: " + stack.length);
		}
	}

	@Test
	void testPop() {
		Stack<Integer> stack = new Stack<Integer>();
		if (stack.length != 0) {
			fail("Stack is not empty initially.");
		}
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
		}
		for (int i = 999; i > -1000; i--) {
			Integer pop = stack.pop();
			if (i >= 0) {
				if (pop != i) {
					fail("Expected element " + i + ", returned: " + pop);
				}
			} else {
				if (pop != null) {
					fail("Expected null, returned: " + pop);
				}
			}
		}
	}
}
