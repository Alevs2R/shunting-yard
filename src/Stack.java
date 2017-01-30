/**
 * Created by user on 30.01.17.
 */
public interface Stack<E> {
    int size();
    boolean isEmpty();
    E top();
    void push(E element);
    E pop();
}
