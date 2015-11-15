
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QueueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QueueTest
{
    private Queue<String> queue;

    /**
     * Default constructor for test class QueueTest
     */
    public QueueTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        queue = new Queue<String>();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void ConstructTest()
    {
        assertEquals(0, queue.size());
    }

    @Test
    public void AddRemoveTest1()
    {
        queue.offer("Test");
        assertEquals(1, queue.size());
        assertEquals("Test", queue.remove());
        assertEquals(0, queue.size());
    }

    @Test
    public void AddRemoveTest2()
    {
        queue.offer("Test1");
        assertEquals(1, queue.size());
        queue.offer("Test2");
        assertEquals(2, queue.size());
        queue.offer("Test3");
        assertEquals(3, queue.size());
        assertEquals("Test1", queue.remove());
        assertEquals(2, queue.size());
        assertEquals("Test2", queue.remove());
        assertEquals(1, queue.size());
        assertEquals("Test3", queue.remove());
        assertEquals(0, queue.size());
    }

    @Test
    public void AddPollTest1()
    {
        queue.offer("Test");
        assertEquals(1, queue.size());
        assertEquals("Test", queue.poll());
        assertEquals(0, queue.size());
    }

    @Test
    public void AddPollTest2()
    {
        queue.offer("Test1");
        assertEquals(1, queue.size());
        queue.offer("Test2");
        assertEquals(2, queue.size());
        queue.offer("Test3");
        assertEquals(3, queue.size());
        assertEquals("Test1", queue.poll());
        assertEquals(2, queue.size());
        assertEquals("Test2", queue.poll());
        assertEquals(1, queue.size());
        assertEquals("Test3", queue.poll());
        assertEquals(0, queue.size());
    }

    @Test
    public void PeekTest1()
    {
        assertEquals(null, queue.peek());
    }

    @Test
    public void PeekTest2()
    {
        queue.offer("Test");
        assertEquals(1, queue.size());
        assertEquals("Test", queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void IteratorTest()
    {
        queue.offer("Test1");
        queue.offer("Test2");
        queue.offer("Test3");
        assertEquals(3, queue.size());
        Iterator itr = queue.iterator();
        assertEquals("Test1", itr.next());
        assertEquals(3, queue.size());
        assertEquals("Test2", itr.next());
        assertEquals(3, queue.size());
        assertEquals("Test3", itr.next());
        assertEquals(3, queue.size());
    }
}

