

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DairyStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DairyStallTest
{
    private DairyStall dairyStall;

    /**
     * Default constructor for test class DairyStallTest
     */
    public DairyStallTest()
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
        dairyStall = new DairyStall(947);
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
        assertEquals(947, dairyStall.getID());
        assertEquals(12, dairyStall.getUnits());
    }
}

