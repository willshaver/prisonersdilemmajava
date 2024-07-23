package a6;

/**
 * The {@code Stack} interface represents a last-in-first-out (LIFO) stack of
 * strings. In addition to the usual push and pop methods, this interface
 * allows the user to get the number of strings in a stack and to query
 * if the stack is empty.
 */
public interface Stack {

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
    public int size();

    /**
     * Returns {@code true} if this stack contains no elements. The default
     * implementation simply returns {@code size() == 0}.
     * 
     * @return true if this stack contains no elements
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Pushes the specified element on to the top of this stack.
     * 
     * @param elem the element to be pushed on to the top of this stack
     */
    public void push(String elem);

    /**
     * Removes the element on the top of this stack and returns the element.
     * 
     * @return the top element of this stack
     * @throws RuntimeException if the stack is empty
     */
    public String pop();
}