/**
 * Child BakedStall class.
 * 
 * @author Nakul Talwar
 */
public class DairyStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public DairyStall(int ID)
    {
        super(ID);
        type = "Dairy";
        StallUnits = StallUnits + 10;
        StallTimeGenerator = new GaussianGenerator(59,23);
    }
}