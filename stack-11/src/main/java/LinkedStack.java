import java.util.Collection;
import java.util.List;

import interfaces.MyCollection;
import linkedlist.LinkedList;

public class LinkedStack<T> implements MyCollection<T> {

    private LinkedList<T> maxStack = new LinkedList<>();
    private LinkedList<T> minStack = new LinkedList<>();
    private LinkedList<T> linkedList = new LinkedList<>();

    public void push(T object) {
        pushMin(object);
        pushMax(object);
        this.linkedList.add(object);
    }

    private void pushMax(T object) {
        if (object instanceof Number) {
            if (size() == 0) {
                maxStack.add(object);
                return;
            }
            double newNumber = ((Number) object).doubleValue();
            double previousNumber = ((Number) maxStack.getLast()).doubleValue();
            if (newNumber >= previousNumber) maxStack.add(object);
            else maxStack.add(maxStack.getLast());
        }
    }

    private void pushMin(T object) {
        if (object instanceof Number) {
            if (size() == 0) {
                minStack.add(object);
                return;
            }
            double newNumber = ((Number) object).doubleValue();
            double prevNumber = ((Number) minStack.getLast()).doubleValue();
            if (newNumber <= prevNumber) minStack.add(object);
            else minStack.add(minStack.getLast());
        }
    }

    public T pop() {
        popMax();
        popMin();
        return this.linkedList.removeLast();
    }

    private void popMin() {
        if(minStack.size() != 0) {
            this.minStack.removeLast();
        }
    }

    private void popMax() {
        if(maxStack.size() != 0) {
            this.maxStack.removeLast();
        }
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
        return this.maxStack.getLast();
    }

    public T min() {
        return this.minStack.getLast();
    }
}
