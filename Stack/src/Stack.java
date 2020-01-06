import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Stack<T> {

	private T[] stack;
	public int length;

	public Stack() {
		this.stack = (T[]) new Object[5];
		this.length = 0;
	}

	public void push(T el) {
		if (this.length >= this.stack.length) {
			this.stack = Arrays.copyOf(this.stack, this.length * 2);
		}
		this.stack[this.length++] = el;
	}

	public T pop() {
		if (!this.isEmpty())
			return this.stack[--this.length];
		else
			return null;
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public T peek() {
		if (!this.isEmpty())
			return this.stack[this.length - 1];
		else
			return null;
	}

}
