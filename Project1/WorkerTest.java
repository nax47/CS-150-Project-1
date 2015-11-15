

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorkerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WorkerTest
{
    private Worker worker;
    /**
     * Default constructor for test class WorkerTest
     */
    public WorkerTest()
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
        worker = new Worker(12345);
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
    public void WorkerIDTest()
    {
        assertEquals(12345, worker.getID());
    }
}

