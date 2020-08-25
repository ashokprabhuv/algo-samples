package algosamples.datastructures;

public class MyQueue<X> {

	private int front;
	private int end;
	private X[] data;

	public MyQueue(int size) {
		this.front = -1;
		this.end = -1;
		this.data = (X[]) new Object[size];
	}

	public void enqueue(X item) {
		if ((end + 1 % data.length) == front) {
			throw new IllegalStateException("Queue size exceeded");
		} else if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		} else {
			end++;
			data[end] = item;
		}
	}

	public void dequeue() {
		X item = null;
		if (size() == 0) {
			throw new IllegalStateException("Queue is empty");
		} else if (front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		} else {
			item = data[front];
			data[front] = null;
			front++;
		}
	}

	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return (end - front) + 1;
		}
	}

	public Boolean contains(X item) {
		Boolean found = false;
		for (int i = front; i <= end; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public X access(int position) throws IllegalAccessException {
		if (size() == 0 || position > size()) {
			throw new IllegalAccessException("Position is invalid or the queue is empty");
		} else {
			int trueIndex = 0;
			for (int i = front; i < end; i++) {
				if (trueIndex == position) {
					return data[i];
				}
				trueIndex++;
			}
		}
		throw new IllegalAccessException("Could not fetch queue item at position: " + position);
	}

	public static void main(String a[]) throws IllegalAccessException {
		MyQueue<Integer> myQ = new MyQueue<Integer>(5);
		myQ.enqueue(2);
		myQ.enqueue(3);
		myQ.enqueue(4);
		System.out.println("Queue size: " + myQ.size());
		myQ.enqueue(6);
		myQ.enqueue(8);
		myQ.dequeue();
		System.out.println("Queue size: " + myQ.size());
		System.out.println(myQ.contains(6));
		System.out.println(myQ.contains(2));
		System.out.println(myQ.access(1));
	}
}
