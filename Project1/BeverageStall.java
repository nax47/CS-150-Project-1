/**
 * Child BeverageStall class.
 * 
 * @author Nakul Talwar
 */
public class BeverageStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public BeverageStall(int ID)
    {
        super(ID);
        type = "Beverage";
        StallUnits = StallUnits + 15;
        StallTimeGenerator = new GaussianGenerator(19,7);
    }
}