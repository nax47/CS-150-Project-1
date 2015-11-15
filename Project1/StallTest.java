

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StallTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StallTest
{
    private Stall stall;

    /**
     * Default constructor for test class StallTest
     */
    public StallTest()
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
        stall = new Stall(665);
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
        assertEquals(665, stall.getID());
        assertEquals(0, stall.getQueue().size());
        assertEquals(2, stall.getUnits());
        assertEquals(true, stall.hasUnits());
        assertEquals(-1, stall.getAverageCustomerTime());
    }
    
    @Test
    public void AddTest1()
    {
        Customer customer = new Customer(123);
        stall.addCustomer(customer);
        assertEquals(1, stall.getQueue().size());
        assertEquals(3, stall.getUnits());
        Customer queueCustomer = stall.getQueue().remove();
        assertEquals(customer, queueCustomer);
        assertEquals(0, queueCustomer.getStallArrivalTime());
    }
    
    @Test
    public void AddTest2()
    {
        for(int i =1; i<41; i++){
           stall.addCustomer(new Customer(i)); 
        }
        assertEquals(40, stall.getQueue().size());
        assertEquals(42, stall.getUnits());
        assertEquals(false, stall.hasUnits());
    }
    
    @Test
    public void RemoveTest1()
    {
        //First checkAndRemove() call will return null
        //because TimeGenerator is generating intervals as zero
        //a zero interval always gets incremented
        assertEquals(null, stall.checkAndRemove());
        assertEquals(null, stall.checkAndRemove());
    }
    
    @Test
    public void RemoveTest2()
    {
        Customer customer = new Customer(123);
        stall.addCustomer(customer);
        assertEquals(3, stall.getUnits());
        //First checkAndRemove() call will return null
        //because TimeGenerator is generating intervals as zero
        //a zero interval always gets incremented
        assertEquals(null, stall.checkAndRemove());
        assertEquals(customer, stall.checkAndRemove());
        assertEquals(2, stall.getUnits());
        assertEquals(0, stall.getAverageCustomerTime());
    }
}

