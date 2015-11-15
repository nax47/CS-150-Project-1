/**
 * Child VegetableStall class.
 * 
 * @author Nakul Talwar
 */
public class VegetableStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public VegetableStall(int ID)
    {
        super(ID);
        type = "Vegetable";
        StallUnits = StallUnits + 17;
        StallTimeGenerator = new GaussianGenerator(119,29);
    }
}