/**
 * @author Alexey Evlampev
 * This class used by linked list and linked queue to store value of elements and link to next element
 * @param <E>
 */
public class Node<E> {
    public E value;
    public Node<E> next;
    public Node(E value, Node next){
        this.value = value;
        this.next = next;
    }
}
