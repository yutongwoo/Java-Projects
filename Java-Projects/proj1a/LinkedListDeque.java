public class LinkedListDeque<T> {

    private class LinkedNode {
        private T item;
        private LinkedNode prev;
        private LinkedNode next;

        private LinkedNode(T i, LinkedNode p, LinkedNode n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }

        private T get(int index) {
            if (index == 0) {
                return this.item;
            }
            return next.get(index - 1);
        }

    }

    private LinkedNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new LinkedNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T x) {
        sentinel.next = new LinkedNode(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T x) {
        size += 1;
        sentinel.prev = new LinkedNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T result;
        result = sentinel.next.item;

        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;


        size -= 1;
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T result;
        result = sentinel.prev.item;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return result;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedNode p = sentinel.next;
        while (!p.equals(sentinel)) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }

        LinkedNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (size() == 0 || index > size()) {
            return null;
        }
        return sentinel.next.get(index);
    }

}
