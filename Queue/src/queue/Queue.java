package queue;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Queue<T> {

	private T[] queue;
	public int length;

	public Queue() {
		this.queue = (T[]) new Object[5];
		this.length = 0;
	}

	public void enqueue(T el) {
		if (this.length >= this.queue.length) {
			this.queue = Arrays.copyOf(this.queue, this.length * 2);
		}
		this.queue[this.length++] = el;
	}

	public T dequeue() {
		if (!this.isEmpty()) {
			T el = this.queue[0];
			if (this.length == 1) {
				this.queue = (T[]) new Object[5];
			} else {
				this.queue = Arrays.copyOfRange(this.queue, 1, this.length);
			}
			this.length--;
			return el;
		} else
			return null;
	}

	public T peek() {
		if (!this.isEmpty())
			return this.queue[0];
		else
			return null;
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

}
