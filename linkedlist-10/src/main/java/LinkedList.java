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
		sentinel.next = new Node(sentinel, t, sentinel.next);
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
		if(size == 0) {
			throw new IllegalStateException("List is empty!");
		}
		return pollFirst();
	}

	@Override
	public T removeLast() {
		if(size == 0) {
			throw new IllegalStateException("List is empty!");
		}
		return pollLast();
	}

	@Override
	public T pollFirst() {
		return null;
	}

	@Override
	public T pollLast() {
		return null;
	}

	@Override
	public T getFirst() {
		if(size == 0) {
			throw new IllegalStateException("List is empty!");
		}
		return peekFirst();
	}

	@Override
	public T getLast() {
		if(size == 0) {
			throw new IllegalStateException("List is empty!");
		}
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
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		return false;
	}

	@Override
	public boolean add(T t) {
		return false;
	}

	@Override
	public boolean offer(T t) {
		return false;
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public T poll() {
		return null;
	}

	@Override
	public T element() {
		return null;
	}

	@Override
	public T peek() {
		return null;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public void push(T t) {

	}

	@Override
	public T pop() {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Iterator<T> descendingIterator() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

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
}
