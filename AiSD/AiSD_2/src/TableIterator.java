import java.util.Iterator;
import java.util.NoSuchElementException;

public class TableIterator<T> implements Iterator<T> {
    private T array[];
    private int pos = 0;
    public TableIterator(T[] loadArray) {
        array = loadArray;
    }
    public boolean hasNext() {
        return pos < array.length;
    }
    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[pos++];
        else
            throw new NoSuchElementException();
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
