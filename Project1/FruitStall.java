/**
 * Child FruitStall class.
 * 
 * @author Nakul Talwar
 */
public class FruitStall extends Stall
{
    /**
     * Default constructor.
     * 
     * Calls default super and intializes units for this stall and sets state.
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public FruitStall(int ID)
    {
        super(ID);
        type = "Fruit";
        StallUnits = StallUnits + 15;
        StallTimeGenerator = new GaussianGenerator(83,31);
    }
}