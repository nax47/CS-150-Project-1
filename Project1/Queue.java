import java.util.*;
/**
 * Queue class to implement a First-In-First-Out Queue.
 * 
 * @author Nakul Talwar
 */
public class Queue<E> extends AbstractQueue<E>
{
    private LinkedList<E> queue;
    /**
     * Default constructor.
     */
    public Queue(){
        queue = new LinkedList<E>();
    }

    /**
     * Retrieves the element at the front of the queue.
     * 
     * @return Returns element at the front of queue.
     */
    public E peek(){
        return queue.peek();
    }

    /**
     * Removes and retrieves the element at the front of the queue.
     * 
     * @return Returns element at the front of queue (Returns null if empty)
     */
    public E poll(){
        return queue.poll();
    }

    /**
     * Removes and retrieves the element at the front of the queue.
     * 
     * @return Returns element at the front of queue (Throws exception if empty)
     */
    public E remove(){
        return queue.remove();
    }

    /**
     * Returns size of the queue.
     * 
     * @return Returns the size as an integer.
     */
    public int size(){
        return queue.size();
    }

    /**
     * Returns an Iterator for this list.
     * 
     * @return Returns an Iterator object.
     */
    public Iterator<E> iterator(){
        return queue.listIterator(0);
    }

    /**
     * Allows new element to be added to the back of the queue.
     *
     * @param e Element to be added to back of queue
     * @return Returns true if successfully added, otherwise returns false.
     */

    public boolean offer(E e){
        return queue.offer(e);
    }
}
