package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {

    private ArrayList<Node> heap;
    private HashMap<T, Integer> items;

    class Node {
        T  item;
        double priority;

        Node(T item, double priority) {
            this.item = item;
            this.priority = priority;
        }
    }

    public ArrayHeapMinPQ() {
        heap = new ArrayList<>();
        items = new HashMap<>();
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    /*if negative, than a less than be, if positive, then a greater than be, if 0, then equals*/
    private double compare(int a, int b) {
        return heap.get(a).priority - heap.get(b).priority;
    }

    private void swap(int a, int b) {
        Node temp = heap.get(a);
        items.put(heap.get(b).item, a);
        items.put(temp.item, b);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    private void swim(int i) {
        while (i > 0) {
            int p = getParent(i);
            if (compare(i, p) >= 0) {
                break;
            }
            swap(i, p);
            i = p;
        }
    }

    private void sink(int i) {
        while (getLeft(i) < size()) {
            int temp = getLeft(i);
            if (getRight(i) < size() && compare(getRight(i), temp) < 0) {
                temp = getRight(i);
            }
            if (compare(i, temp) < 0) {
                break;
            }
            swap(i, temp);
            i = temp;
        }
    }


    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority) {
        if (contains(item)) {
            throw new IllegalArgumentException();
        }
        heap.add(new Node(item, priority));
        items.put(item, size() - 1);
        swim(size() - 1);
    }

    /* Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    @Override
    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T getSmallest() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return heap.get(0).item;
    }

    @Override
    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T removeSmallest() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        T min = heap.get(0).item;
        items.remove(min);
        swap(0, size() - 1);
        heap.remove(size() - 1);
        sink(0);
        return min;
    }

    @Override
    /* Returns the number of items in the PQ. */
    public int size() {
        return heap.size();
    }

    @Override
    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    public void changePriority(T item, double priority) {
        if (!contains(item)) {
            throw new NoSuchElementException();
        }
        int index = items.get(item);
        double temp = heap.get(index).priority;
        heap.get(index).priority = priority;
        if (temp < priority) {
            sink(index);
        } else {
            swim(index);
        }
    }
}
