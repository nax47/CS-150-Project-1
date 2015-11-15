

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MeatStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MeatStallTest
{
    private MeatStall meatStall;

    
    /**
     * Default constructor for test class MeatStallTest
     */
    public MeatStallTest()
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
        meatStall = new MeatStall(325);
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
        assertEquals(325, meatStall.getID());
        assertEquals(16, meatStall.getUnits());
    }
}

