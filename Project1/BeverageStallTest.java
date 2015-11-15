

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BeverageStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BeverageStallTest
{
    private BeverageStall beverageStall;

    /**
     * Default constructor for test class BeverageStallTest
     */
    public BeverageStallTest()
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
        beverageStall = new BeverageStall(343);
        beverageStall.getID();
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
        assertEquals(343, beverageStall.getID());
        assertEquals(17, beverageStall.getUnits());
    }
}

