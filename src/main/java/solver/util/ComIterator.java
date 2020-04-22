package solver.util;

/**
 * This is a data structure for iterator.
 * @author lchz
 * @param <E> the type of elements returned by this iterator
 */
public class ComIterator<E> {

    private int index;
    private ComList<E> list;
    private int size;

    public ComIterator(ComList<E> list) {
        this.index = 0;
        this.list = list;
        this.size = list.size();
    }
    
    /**
     * Returns true if this iteration has more elements.
     * 
     * @return true if this iteration has more elements
     */
    public boolean hasNext() {
        return index < size;
    }

    /**
     * Returns the next item in this iteration.
     * 
     * @return the next item in this iteration
     */
    public E next() {
        return list.get(index++);
    }

    /**
     * Removes the specific elements in this iteration.
     * 
     * @param o element to be removed
     */
    public void remove(Object o) {
        list.remove(o);
        index--;
        size--;
    }

}
