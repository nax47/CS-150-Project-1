/**
 * Child BakedStall class.
 * 
 * @author Nakul Talwar
 */
public class BakedStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public BakedStall(int ID)
    {
        super(ID);
        type = "Baked";
        StallUnits = StallUnits + 12;
        StallTimeGenerator = new GaussianGenerator(29,13);       
    }
}
