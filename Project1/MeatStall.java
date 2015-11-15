/**
 * Child MeatStall class.
 * 
 * @author Nakul Talwar
 */
public class MeatStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public MeatStall(int ID)
    {
        super(ID);
        type = "Meat";
        StallUnits = StallUnits + 14;
        StallTimeGenerator = new GaussianGenerator(83,41);
    }
}
