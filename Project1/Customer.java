/**
 * Child customer class.
 * 
 * @author Nakul Talwar
 */
public class Customer extends Person
{
    //Boolean to store whether or not a customer needs certain items
    private boolean BakedNeed;
    private boolean MeatNeed;
    private boolean DairyNeed;
    private boolean FruitNeed;
    private boolean VegNeed;
    private boolean BevNeed;
    //Objects to generate random numbers from a Gaussian Distribution based on percentage needs
    private GaussianGenerator BakedNeedGenerator;
    private GaussianGenerator MeatNeedGenerator;
    private GaussianGenerator DairyNeedGenerator;
    private GaussianGenerator FruitNeedGenerator;
    private GaussianGenerator VegNeedGenerator;
    private GaussianGenerator BevNeedGenerator;
    //Object to generate a random number between 0 and 100
    private RandomGenerator RandomNumberGenerator;
    //Variables to store the arrival time of a customer when he enters the market or a stall
    private int MarketArrivalTime;
    private int StallArrivalTime;
    /**
     * Default constructor.
     * 
     * Initializes a customer's unique ID and randomly generates needs.
     * 
     * @param id Customer's ID number.
     */
    public Customer(int ID)
    {
        super(ID);
        BakedNeedGenerator = new GaussianGenerator(37,17);
        MeatNeedGenerator = new GaussianGenerator(53,13);
        DairyNeedGenerator = new GaussianGenerator(59,19);
        FruitNeedGenerator = new GaussianGenerator(47,13);
        VegNeedGenerator = new GaussianGenerator(71,29);
        BevNeedGenerator = new GaussianGenerator(43,11);
        RandomNumberGenerator = new RandomGenerator(0,100);
        generateNeeds();
    }

    /**
     * Method to randomly generate each customers needs.
     * 
     * A random number between 0 and 100 is generated.
     * If the number is less than the percentage based number obtained from the Gaussian distribution
     * for each need, the need is set to true.
     */
    private void generateNeeds(){
        if(RandomNumberGenerator.generate()<=BakedNeedGenerator.generate()){BakedNeed = true;}
        else{BakedNeed = false;}
        if(RandomNumberGenerator.generate()<=MeatNeedGenerator.generate()){MeatNeed = true;}
        else{MeatNeed = false;}
        if(RandomNumberGenerator.generate()<=DairyNeedGenerator.generate()){DairyNeed = true;}
        else{DairyNeed = false;}
        if(RandomNumberGenerator.generate()<=FruitNeedGenerator.generate()){FruitNeed = true;}
        else{FruitNeed = false;}
        if(RandomNumberGenerator.generate()<=VegNeedGenerator.generate()){VegNeed = true;}
        else{VegNeed = false;}
        if(RandomNumberGenerator.generate()<=BevNeedGenerator.generate()){BevNeed = true;}
        else{BevNeed = false;}
    }

    /**
     * Method to retrieve a customer's Baked need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsBaked(){
        return BakedNeed;
    }

    /**
     * Method to retrieve a customer's Meat need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsMeat(){
        return MeatNeed;
    }

    /**
     * Method to retrieve a customer's Dairy need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsDairy(){
        return DairyNeed;
    }

    /**
     * Method to retrieve a customer's Fruit need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsFruit(){
        return FruitNeed;
    }

    /**
     * Method to retrieve a customer's Vegetable need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsVegetable(){
        return VegNeed;
    }

    /**
     * Method to retrieve a customer's Beverage need.
     * 
     * @return Returns the need as a boolean.
     */
    public boolean needsBeverage(){
        return BevNeed;
    }

    /**
     * Method to check if a customer needs nothing.
     * 
     * @return Returns whether or not the customer needs nothing else.
     */
    public boolean needsNothing(){
        boolean nothing_needed = true;
        if(BakedNeed == true)
            nothing_needed = false;
        if(MeatNeed == true)
            nothing_needed = false;
        if(DairyNeed == true)
            nothing_needed = false;
        if(FruitNeed == true)
            nothing_needed = false;
        if(VegNeed == true)
            nothing_needed = false;
        if(BevNeed == true)
            nothing_needed = false;
        return nothing_needed;
    }

    /**
     * Method to change a customer's needs after visiting a stall.
     * 
     * @param need The "need" that is to be changed. Passed as a String.
     */
    public void changeNeeds(String need){
        if(need == "Baked")
            BakedNeed = false;
        else if(need == "Meat")
            MeatNeed = false;
        else if(need == "Dairy")
            DairyNeed = false;
        else if(need == "Fruit")
            FruitNeed = false;
        else if(need == "Vegetable")
            VegNeed = false;
        else if(need == "Beverage")
            BevNeed = false;
    }

    /**
     * Method to set the arrival time of a customer at the market.
     * 
     * @param time The time to be set.
     */
    public void setMarketArrivalTime(int time){
        MarketArrivalTime = time;
    }

    /**
     * Method to get the arrival time of a customer at the market.
     * 
     * @return Returns the arrival time.
     */
    public int getMarketArrivalTime(){
        return MarketArrivalTime;
    }

    /**
     * Method to set the arrival time of a customer at a stall.
     * 
     * @param time The time to be set.
     */
    public void setStallArrivalTime(int time){
        StallArrivalTime = time;
    }

    /**
     * Method to get the arrival time of a customer at a stall.
     * 
     * @return Returns the arrival time.
     */
    public int getStallArrivalTime(){
        return StallArrivalTime;
    }
}
