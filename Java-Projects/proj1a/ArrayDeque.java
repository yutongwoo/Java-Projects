public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 4;
    private int nextLast = 5;
    private int startindex = 4;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other){

    }

    public T get(int index) {
        index = (index + startindex) % 8;
        return items[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + "");
        }
        System.out.println();
    }

    private void resize(int s) {
        T[] resizedArray = (T[]) new Object[s];
        System.arraycopy(items, 0, resizedArray, 0, nextFirst + 1);
        int len = resizedArray.length - nextFirst - 1;
        if (nextFirst + 1 != items.length) {
            System.arraycopy(items, nextFirst + 1, resizedArray, nextFirst + 1, len);
        }
        items = resizedArray;
        nextFirst = nextFirst + resizedArray.length / 2;
    }

    public void addFirst(T x) {
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }

        if (nextFirst == nextLast) {
            resize();
        }

        items[nextFirst] = x;
        startindex = nextFirst;
        nextFirst = nextFirst - 1;
        size += 1;
    }

    public void addLast(T x) {
        if (nextLast == items.length) {
            nextLast = 0;
        }

        if (nextFirst == nextLast) {
            resize();
        }

        if (nextLast == nextFirst + 1) {
            startindex = nextLast;
        }

        items[nextLast] = x;
        nextLast = nextLast + 1;
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (nextFirst >= items.length) {
            nextFirst = 0;
        }
        T result = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size = size - 1;
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }

        T result = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        size = size - 1;
        return result;
    }
}
