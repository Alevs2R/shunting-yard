/**
 * @author Alexey Evlampev
 * My own implementation of linked queue based on queue interface (FIFO)
 */

public class LinkedQueue<E> implements Queue<E> {

    private int count = 0; //internal counter used to determine the size of queue
    private Node<E> first = null; //pointer to head of queue
    private Node<E> last = null; //pointer to tail of queue

    /**
     * @return the number of elements in the queue
     */
    public int size() {
        return count;
    }

    /**
     * @return whether the queue is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return the item at the top (without removing it)
     */
    public E first() {
        if (this.isEmpty()) return null;
        return first.value;
    }

    /**
     * This method inserts new element to the rear of the queue
     * @param e element to insert
     */
    public void enqueue(E e) {
        Node<E> node = new Node<E>(e, null);
        if(last != null) last.next = node; //
        if(first == null) first = node;
        last = node;
        count++;
    }

    /**
     * This method returns element from the head and removes it from the queue (сan be handled by GC)
     * @return element of type E in the head of the queue
     */
    public E dequeue() {
        if(this.isEmpty()) throw new RuntimeException("queue is empty");
        E firstElement = this.first();
        first = first.next;
        count--;
        return firstElement;
    }
}
