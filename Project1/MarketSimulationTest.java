

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MarketSimulationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MarketSimulationTest
{
    private MarketSimulation marketSim;

    /**
     * Default constructor for test class MarketSimulationTest
     */
    public MarketSimulationTest()
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
        marketSim = new MarketSimulation();
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
        assertEquals(0, MarketSimulation.getCurrentTime());
    }
}

