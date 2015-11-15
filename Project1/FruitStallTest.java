

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FruitStallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FruitStallTest
{
    private FruitStall fruitStall;

    /**
     * Default constructor for test class FruitStallTest
     */
    public FruitStallTest()
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
        fruitStall = new FruitStall(612);
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
        assertEquals(612, fruitStall.getID());
        assertEquals(17, fruitStall.getUnits());
    }
}

