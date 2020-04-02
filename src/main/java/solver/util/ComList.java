package solver.util;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author lchz
 */
public class ComList<E> implements Iterable<E> {

    private final int INITIAL_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] list;

    public ComList() {
        list = new Object[this.INITIAL_CAPACITY];
        capacity = this.INITIAL_CAPACITY;
        size = 0;
    }

    public boolean add(E e) {
        if (size == capacity) {
            doubleSizeArray(size);
        }
        list[size++] = e;
        return true;
    }

    public boolean addAll(ComList<E> l) {
        int i = 0;

        while (i < l.size()) {
            if (size == capacity) {
                doubleSizeArray(size);
            }
            list[size++] = l.get(i);
            i++;
        }

        return true;
    }

    public boolean remove(Object o) {

        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        list[index] = null;
        for (int j = index + 1; j < size; j++) {
            list[j - 1] = list[j];
        }
        size--;

        return true;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return (E) list[index];
    }

    public int size() {
        return size;
    }

    private void doubleSizeArray(int size) {
        Object[] newList = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
        capacity = size * 2;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) list[index++];
            }

        };
        return it;
    }

}
