
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MarketTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MarketTest
{
    private Market market1;

    /**
     * Default constructor for test class MarketTest
     */
    public MarketTest()
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
        market1 = new Market(1, 2, 3, 4, 5, 6);
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
        assertEquals(347, market1.getUnits());
        assertEquals(true, market1.hasUnits());
        assertEquals(-1, market1.getAverageCustomerTime());
    }

    @Test
    public void AddNewTest1()
    {
        market1.addNewCustomer();
        assertEquals(1, market1.getCustomersEntered());
    }

    @Test
    public void AddNewTest2()
    {
        for(int i=0; i<50; i++){
            market1.addNewCustomer();
        }
        assertEquals(50, market1.getCustomersEntered());
    }

    @Test
    public void AddRemoveTest1()
    {
        market1.addNewCustomer();
        assertEquals(1, market1.getCustomersEntered());
        for(int i=0; i<1000; i++){
            market1.checkQueues();
        }
        assertEquals(1, market1.getCustomersLeft());
    }

    @Test
    public void AddRemoveTest2()
    {
        for(int i=0; i<10; i++){
            market1.addNewCustomer();
        }
        assertEquals(10, market1.getCustomersEntered());
        for(int i=0; i<1000; i++){
            market1.checkQueues();
        }
        assertTrue(market1.getCustomersEntered()-market1.getCustomersLeft()<10);
    }

    @Test
    public void WaitingAreaTest1()
    {
        assertEquals(0, market1.checkWaitingArea());
    }

    @Test
    public void WaitingAreaTest2()
    {
        Market market2 = new Market(1,1,1,1,1,1); 
        for(int i=0; i<200; i++){
            market2.addNewCustomer();
        }
        assertTrue(market2.checkWaitingArea()!=0);
    }
}

