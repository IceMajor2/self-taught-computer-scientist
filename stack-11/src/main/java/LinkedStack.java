import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import interfaces.MyCollection;

public class LinkedStack<T> implements MyCollection<T> {

	private LinkedList<T> linkedList;

	public void push(T object) {

	}

	public T pop() {
		return null;
	}

	@Override
	public void add(T object) {

	}

	@Override
	public T get() {
		return null;
	}

	@Override
	public boolean contains(Object object) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return false;
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public List<T> toList() {
		return null;
	}
}
