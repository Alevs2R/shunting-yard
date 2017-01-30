import java.util.EmptyStackException;

/**
 * @author Alexey Evlampev
 * My own implementation of linked stack based on stack interface (LIFO)
 */

public class LinkedStack<E> implements Stack<E> {

    private Node<E> first = null; //pointer to
    private int count = 0; //internal counter to determine the size

    /**
     * @return the number of items in the stack
     */
    public int size() {
        return count;
    }

    /**
     * @return whether stack has no items
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return the item on the top (without removing it)
     */
    public E top() {
        if (this.isEmpty()) return null;
        return first.value;
    }

    /**
     * inserts an item at the top of the stack
     * @param element
     */
    public void push(E element) {
        first = new Node<>(element, first);
        count++;
    }

    /**
     * removes the item at the top
     * @return element
     */
    public E pop() {
        if(this.isEmpty()) throw new EmptyStackException();
        E topElement = this.top();
        first = first.next;
        count--;
        return topElement;
    }
}
