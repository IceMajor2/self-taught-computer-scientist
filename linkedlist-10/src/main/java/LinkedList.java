import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class LinkedList<T> implements Deque<T>, Iterable<T> {

	private Node<T> sentinel;

	private int size;

	public LinkedList() {
		this.sentinel = new Node(null, 582347, null);
		this.sentinel.next = sentinel;
		this.sentinel.prev = sentinel;
		this.size = 0;
	}

	@Override
	public void addFirst(T t) {
		size++;
		sentinel.next = new Node<>(sentinel, t, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
	}

	@Override
	public void addLast(T t) {
		size++;
		sentinel.prev = new Node<>(sentinel.prev, t, sentinel);
		sentinel.prev.prev.next = sentinel.prev;
	}

	@Override
	public boolean offerFirst(T t) {
		addFirst(t);
		return true;
	}

	@Override
	public boolean offerLast(T t) {
		addLast(t);
		return true;
	}

	@Override
	public T removeFirst() {
		if (size == 0) throw new IllegalStateException("List is empty!");
		return pollFirst();
	}

	@Override
	public T removeLast() {
		if (size == 0) throw new IllegalStateException("List is empty!");
		return pollLast();
	}

	@Override
	public T pollFirst() {
		if (size == 0) return null;
		T toReturn = sentinel.next.data;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return toReturn;
	}

	@Override
	public T pollLast() {
		if (size == 0) return null;
		T toReturn = sentinel.prev.data;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size--;
		return toReturn;
	}

	public T get(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException();
		Node<T> current = sentinel.next;
		int i = 0;
		while (i != index) {
			current = current.next;
			i++;
		}
		return current.data;
	}

	@Override
	public T getFirst() {
		if (size == 0) throw new IllegalStateException("List is empty!");
		return peekFirst();
	}

	@Override
	public T getLast() {
		if (size == 0) throw new IllegalStateException("List is empty!");
		return peekLast();
	}

	@Override
	public T peekFirst() {
		return sentinel.next.data;
	}

	@Override
	public T peekLast() {
		return sentinel.prev.data;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		if (size == 0) throw new IllegalStateException();

		Node<T> current = sentinel.next;
		int index = 0;
		while (index < size) {
			if (current.equals(o)) {
				Node<T> previous = current.prev;
				Node<T> next = current.next;
				next.prev = previous;
				previous.next = next;
				size--;
				return true;
			}
			current = current.next;
			index++;
		}
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		if (size == 0) throw new IllegalStateException();

		Node<T> current = sentinel.prev;
		int index = 0;
		while (index < size) {
			if (current.equals(o)) {
				Node<T> previous = current.prev;
				Node<T> next = current.next;
				next.prev = previous;
				previous.next = next;
				size--;
				return true;
			}
			current = current.prev;
			index++;
		}
		return false;
	}

	@Override
	public boolean add(T t) {
		addLast(t);
		return true;
	}

	@Override
	public boolean offer(T t) {
		offerLast(t);
		return true;
	}

	@Override
	public T remove() {
		return removeLast();
	}

	@Override
	public T poll() {
		return pollFirst();
	}

	@Override
	public T element() {
		return pollFirst();
	}

	@Override
	public T peek() {
		return peekFirst();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (var el : c) {
			addLast(el);
		}
		return true;
	}

	@Override
	public void push(T t) {
		offerLast(t);
	}

	@Override
	public T pop() {
		return pollLast();
	}

	@Override
	public boolean remove(Object o) {
		pollLast();
		return true;
	}

	@Override
	public boolean contains(Object o) {
		for (T object : this) {
			if (o.equals(object)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO: implement
		return new LinkedListIterator<>();
	}

	@Override
	public Iterator<T> descendingIterator() {
		// TODO: implement
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object[] toArray() {
		// TODO: implement
		return new Object[0];
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		// TODO: implement
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO: implement
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO: implement
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO: implement
		return false;
	}

	@Override
	public void clear() {
		// TODO: implement
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other instanceof LinkedList oLLD) {
			if (this.size != oLLD.size) {
				return false;
			}
			for (T x : this) {
				if (!oLLD.contains(x)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (size == 0) return "[]";
		StringBuilder sb = new StringBuilder("[");
		for (T x : this) {
			sb.append(x).append(", ");
		}
		return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
	}

	private class Node<T> {

		private Node<T> prev;

		private T data;

		private Node<T> next;

		public Node(Node prev, T data, Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}

	private class LinkedListIterator<T> implements Iterator<T> {

		private int pos;

		public LinkedListIterator() {
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			if (this.pos < size) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T toReturn = (T) get(this.pos);
			pos++;
			return toReturn;
		}
	}
}
