import java.util.Collection;
import java.util.List;

import interfaces.MyCollection;
import linkedlist.LinkedList;

public class LinkedStack<T> implements MyCollection<T> {

	private LinkedList<T> linkedList = new LinkedList<>();

	public void push(T object) {
		this.linkedList.add(object);
	}

	public T pop() {
		return this.linkedList.removeLast();
	}

	@Override
	public void add(T object) {
		push(object);
	}

	@Override
	public T get() {
		return linkedList.getLast();
	}

	@Override
	public boolean contains(Object object) {
		return linkedList.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return linkedList.containsAll(collection);
	}

	@Override
	public T remove() {
		return pop();
	}

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public void clear() {
		linkedList.clear();
	}

	@Override
	public List<T> toList() {
		return linkedList.toList();
	}

	@Override
	public boolean equals(Object obj) {
		return linkedList.equals(obj);
	}

	@Override
	public String toString() {
		return linkedList.toString();
	}

	public T max() {
		return null;
	}
}
