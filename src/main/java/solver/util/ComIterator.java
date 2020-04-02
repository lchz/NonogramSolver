package solver.util;

/**
 *
 * @author lchz
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
    
    public boolean hasNext() {
        return index < size;
    }

    public E next() {
        return list.get(index++);
    }

    public void remove(Object o) {
        list.remove(o);
        index--;
        size--;
    }

}
