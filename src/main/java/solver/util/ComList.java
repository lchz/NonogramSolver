package solver.util;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author lchz
 * @param <E> the type of items returned by this collection
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

    /**
     * Adds an item to the list with size growing if necessary.
     * 
     * @param e item to be added to this list.
     * @return true if action was a success
     */
    public boolean add(E e) {
        if (size == capacity) {
            doubleSizeArray(size);
        }
        list[size++] = e;
        return true;
    }

    /**
     * Adds all of the items in the collection to the end of the list.
     * 
     * @param l collection containing items to be added to this list
     * @return true if action was a success
     */
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

    /**
     * Removes an item from this list if it is present.
     * 
     * @param o item to be removed from this list
     * @return true if this list contained the element and action was a success
     */
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

    /**
     * Checks if this list contains a certain item.
     * 
     * @param e item to be checked
     * @return true if this list contains the item
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a sequential Stream with this collection as its source.
     * 
     * @return a sequential Stream over the elements in this collection
     */
    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Checks if this list is empty.
     * 
     * @return true if this list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the item at a specific index from this list.
     * 
     * @param index index of the item to be returned
     * @return the item at a specific index
     */
    public E get(int index) {
        return (E) list[index];
    }

    /**
     * Returns size of this list.
     * 
     * @return the size of this list
     */
    public int size() {
        return size;
    }

    /**
     * Enlarges the size of this list by doubling the current size.
     * 
     * @param size current size to be doubled
     */
    private void doubleSizeArray(int size) {
        Object[] newList = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
        capacity = size * 2;
    }

    /**
     * Creates an iterator over this list.
     * 
     * @return an iterator over this list.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator<E>() {

            private int index = 0;

            /**
             * Returns true if this iteration has more items.
             * 
             * @return true if this iteration has more items
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * Returns the next item in this iteration.
             * 
             * @return the next item in this iteration
             */
            @Override
            public E next() {
                return (E) list[index++];
            }

        };
        return it;
    }

}
