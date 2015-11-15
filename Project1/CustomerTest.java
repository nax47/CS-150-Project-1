import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    private Customer customer;
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
        customer = new Customer(56789);
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
    public void CustomerIDTest()
    {
        assertEquals(56789, customer.getID());
    }
    
    @Test
    public void NeedTest()
    {
        customer.changeNeeds("Baked");
        assertEquals(false, customer.needsBaked());
        customer.changeNeeds("Meat");
        assertEquals(false, customer.needsMeat());
        customer.changeNeeds("Dairy");
        assertEquals(false, customer.needsDairy());
        customer.changeNeeds("Fruit");
        assertEquals(false, customer.needsFruit());
        customer.changeNeeds("Vegetable");
        assertEquals(false, customer.needsVegetable());
        customer.changeNeeds("Beverage");
        assertEquals(false, customer.needsBeverage());
        assertEquals(true, customer.needsNothing());
    }
    
    @Test
    public void ArrivalTimeTest()
    {
        customer.setMarketArrivalTime(47);
        assertEquals(47, customer.getMarketArrivalTime());
        customer.setStallArrivalTime(74);
        assertEquals(74, customer.getStallArrivalTime());
    }
}

