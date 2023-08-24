package interfaces;

import java.util.Collection;
import java.util.List;

public interface MyCollection<T> {

	void add(T object);

	T get();

	boolean contains(Object object);

	boolean containsAll(Collection<?> collection);

	T remove();

	int size();

	boolean isEmpty();

	void clear();

	List<T> toList();
}
