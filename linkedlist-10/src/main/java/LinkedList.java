import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LinkedList<T> implements MyCollection<T>, Iterable<T> {

	private Node<T> sentinel;

	private int size;

	public LinkedList() {
		this.sentinel = new Node(null, 582347, null);
		this.sentinel.next = sentinel;
		this.sentinel.prev = sentinel;
		this.size = 0;
	}

	@Override
	public void add(T object) {
		size++;
		sentinel.prev = new Node<>(sentinel.prev, object, sentinel);
		sentinel.prev.prev.next = sentinel.prev;
	}

	public void addFirst(T object) {
		size++;
		sentinel.next = new Node<>(sentinel, object, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
	}

	@Override
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

	public T getFirst() {
		throwExceptionIfListEmpty();
		return sentinel.next.data;
	}

	public T getLast() {
		throwExceptionIfListEmpty();
		return sentinel.prev.data;
	}

	@Override
	public boolean contains(Object object) {
		for(T element : this) {
			if(Objects.equals(element, object)) return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for(var object : collection) {
			if(!this.contains(object)) return false;
		}
		return true;
	}

	@Override
	public T remove() {
		return removeLast();
	}

	public T removeFirst() {
		throwExceptionIfListEmpty();
		T toReturn = sentinel.next.data;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return toReturn;
	}

	public T removeLast() {
		throwExceptionIfListEmpty();
		T toReturn = sentinel.prev.data;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size--;
		return toReturn;
	}

	private T remove(Node<T> current) {
		T toReturn = current.data;
		Node<T> previous = current.prev;
		Node<T> next = current.next;
		previous.next = next;
		next.prev = previous;
		size--;
		return toReturn;
	}

	@Override
	public boolean remove(Object object) {
		throwExceptionIfListEmpty();
		Node<T> current = sentinel.next;
		for(T element : this) {
			if(Objects.equals(element, object)) {
				this.remove(current);
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clear() {
		// TODO
	}

	@Override
	public List<T> toList() {
		// TODO
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<>();
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

	private void throwExceptionIfListEmpty() {
		if (size == 0) throw new IllegalStateException("List is empty");
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
