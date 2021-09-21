/**
 * Thrown if an element's capacity is exceeded
 * Is of type RuntimeException
 */
public class ListOverflowException extends RuntimeException {
    public ListOverflowException(String message) {
        super(message);
    }
}
