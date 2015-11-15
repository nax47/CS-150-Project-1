

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BakedStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BakedStallTest
{
    private BakedStall bakedStall;
    /**
     * Default constructor for test class BakedStallTest
     */
    public BakedStallTest()
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
        bakedStall = new BakedStall(479);
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
        assertEquals(479, bakedStall.getID());
        assertEquals(14, bakedStall.getUnits());
    }
}

