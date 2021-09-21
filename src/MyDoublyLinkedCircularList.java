import java.util.NoSuchElementException;

/**
 * Implementation of the Doubly Linked Circular List
 * @param <E> this list holds elements of type E
 */
public class MyDoublyLinkedCircularList<E> implements MyList<E> {

    /**
     * Implementation of the Doubly Linked Node
     * @param <E> Contains an element of type E
     */
    protected static class DoublyLinkedNode<E> {
        // Instance fields
        private E data;
        private DoublyLinkedNode<E> next;
        private DoublyLinkedNode<E> previous;

        /**
         * Constructor for the Doubly Linked Node
         * @param data element to be stored in the node
         */
        public DoublyLinkedNode(E data) {
            this.data = data;
            previous = null;
            next = null;
        }

        /**
         * Returns the element stored in the node
         * @return element stored in the node
         */
        public E getData() { return data; }

        /**
         * Returns the next node
         * @return a reference to the next node
         */
        public DoublyLinkedNode<E> getNext() { return next; }

        /**
         * Returns the previous node
         * @return a reference to the previous node
         */
        public DoublyLinkedNode<E> getPrevious() { return previous; }

        /**
         * Set the reference to the next node
         * @param next the next node
         */
        public void setNext(DoublyLinkedNode<E> next) { this.next = next; }

        /**
         * Set the reference to the previous node
         * @param previous the previous node
         */
        public void setPrevious(DoublyLinkedNode<E> previous) { this.previous = previous; }

    }
    // Instance fields
    private E data;
    private DoublyLinkedNode<E> tail = null;
    private int size = 0;

    /**
     * Construct an empty list
     */
    public MyDoublyLinkedCircularList() { }

    /**
     * Tests if the array is empty
     * @return is the array empty?
     */
    private boolean isEmpty() { return size == 0; }

    /**
     * Returns the size of the list
     * @return number of elements in the list
     */
    @Override
    public int getSize() { return size; }

    /**
     * Insert an element at the end of the list
     * @param data element to be inserted
     * @throws ListOverflowException if the list is full
     */
    @Override
    public void insert(E data) throws ListOverflowException {
        DoublyLinkedNode<E> temp = new DoublyLinkedNode<>(data);
        if (isEmpty()) {
            tail = new DoublyLinkedNode<>(data);
            tail.setPrevious(tail);
            tail.setNext(tail);
        }
        else {
            temp.setNext(tail.getNext());
            temp.setPrevious(tail);

            if (tail.getNext() != null) {
                tail.getNext().setPrevious(temp);
            }
            tail.setNext(temp);
            tail = temp;
        }
        ++size;
    }

    /**
     * Deletes the passed element from the list
     * @param data element to be deleted
     * @return successful removal of the element from the list
     */
    public boolean delete(E data) {
        DoublyLinkedNode<E> current;
        if (isEmpty()) return false;
        current = tail;

        // Special case, delete tail
        if (tail.getData().equals(data)) {
            // iF element is the only thing on the list
            if (getSize() == 1) {
                tail = null;
                return true;
            }
            tail.setPrevious(tail.getPrevious());
            tail.setNext(tail.getNext().getNext());
            tail = tail.getNext();
            --size;
            return true;
        }
        while (!current.getNext().equals(tail)) {
            if (current.getData().equals(data)) {
                DoublyLinkedNode<E> prevNode = current.getPrevious();

                prevNode.setNext(current.getNext());
                current.getNext().setPrevious(prevNode);
                current = null;

                --size;
                return true;
            }
            current = current.getNext();

        }
        return false;
    }

    /**
     * Returns the passed argument from the list
     * @param data element to be returned
     * @return element from the list that matches the passed argument
     * @throws NoSuchElementException if the element is not in the list
     */
    public E getElement(E data) throws NoSuchElementException {
        if (isEmpty()) return null;
        DoublyLinkedNode<E> current = tail;
        while (!current.getNext().equals(tail)
            || getSize() == 1) {
            if (current.getData().equals(data)) return current.getData();
            current = current.getNext();
        }
        throw new NoSuchElementException(data.toString() + " not found in list.");
    }

    /**
     * Tests if the passed argument is in the list
     * @param data element to look up
     * @return is the element contained in the list?
     */
    public boolean search(E data) {
        if (isEmpty()) return false;
        DoublyLinkedNode<E> current = tail;
        do {
            if (current.getData().equals(data)) return true;
            current = current.getNext();
        }while(!current.equals(tail)|| getSize() == 1);
        return false;
    }

    public DoublyLinkedNode<E> getHead() {
        return getTail().getNext();
    }

    public DoublyLinkedNode<E> getTail() {
        return tail;
    }
}
