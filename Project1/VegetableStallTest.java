

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VegetableStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VegetableStallTest
{
    private VegetableStall vegetableStall;

    /**
     * Default constructor for test class VegetableStallTest
     */
    public VegetableStallTest()
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
        vegetableStall = new VegetableStall(840);
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
        assertEquals(840, vegetableStall.getID());
        assertEquals(19, vegetableStall.getUnits());
    }
}

