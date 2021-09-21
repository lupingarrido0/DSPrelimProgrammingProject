import java.util.NoSuchElementException;

/**
 * Interface provided in the problem specification
 * @param <E> this list contains elements of type E
 */
public interface MyList<E> {
    public int getSize();
    public void insert(E data) throws ListOverflowException;
    public E getElement(E data) throws NoSuchElementException;
    public boolean delete(E data);  // returns false if the data is not in the list
    public boolean search(E data);

}
