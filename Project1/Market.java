import java.io.*;
import java.util.*;
/**
 * Market class.
 * 
 * @author Nakul Talwar
 */
public class Market
{
    //ArrayLists for each type of stall
    private ArrayList<Stall> BakedStalls;
    private ArrayList<Stall> MeatStalls;
    private ArrayList<Stall> DairyStalls;
    private ArrayList<Stall> FruitStalls;
    private ArrayList<Stall> VegetableStalls;
    private ArrayList<Stall> BeverageStalls;
    //ArrayList to act as a waiting area if a customer cannot be placed in any stall at a given time
    private ArrayList<Customer> WaitingArea;
    //ArrayList to store time spent by each customer in the market
    private ArrayList<Integer> AverageCustomerTimes;
    //Number of units being occupied by the market
    private int MarketUnits;
    //Stores total number of customers who have entered the market
    private int CustomersEntered;
    //Stores total number of customers who have left the market
    private int CustomersLeft;
    //Stores largest number of stalls in a single type
    private int MostStalls;
    /**
     * Default constructor.
     * 
     * Initializes market parameters.
     * 
     * @param baked_count Number of stalls selling baked goods.
     * @param meat_count Number of stalls selling meat.
     * @param dairy_count Number of stalls selling dairy products.
     * @param fruit_count Number of stalls selling fruits.
     * @param veg_count Number of stalls selling vegetables.
     * @param bev_count Number of stalls selling beverages.
     */
    public Market(int baked_count, int meat_count, int dairy_count, int fruit_count, int veg_count, int bev_count)
    {
        MarketUnits = 0;
        CustomersEntered = 0;
        CustomersLeft = 0;
        MostStalls = 0;
        WaitingArea = new ArrayList<Customer>();
        AverageCustomerTimes = new ArrayList<Integer>();
        generateStalls(baked_count , meat_count , dairy_count , fruit_count , veg_count , bev_count);
    }

    /**
     * Method to generate initial state of stalls in the market.
     * 
     * Adds new stalls of each type to corresponding ArrayLists based on the stall counts.
     * 
     * @param baked_count Number of stalls selling baked goods.
     * @param meat_count Number of stalls selling meat.
     * @param dairy_count Number of stalls selling dairy products.
     * @param fruit_count Number of stalls selling fruits.
     * @param veg_count Number of stalls selling vegetables.
     * @param bev_count Number of stalls selling beverages.
     */
    private void generateStalls(int baked_count, int meat_count, int dairy_count, int fruit_count, int veg_count, int bev_count)
    {
        BakedStalls = new ArrayList<Stall>();
        MeatStalls = new ArrayList<Stall>();
        DairyStalls = new ArrayList<Stall>();
        FruitStalls = new ArrayList<Stall>();
        VegetableStalls = new ArrayList<Stall>();
        BeverageStalls = new ArrayList<Stall>();
        //MostStalls obtains its value by finding the largest number of times a loop runs over all of the ArrayLists.
        for(int i = 0; i<baked_count; i++){
            BakedStalls.add(new BakedStall(i+1));
            MarketUnits = MarketUnits + BakedStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }

        for(int i = 0; i<meat_count; i++){
            MeatStalls.add(new MeatStall(i+1));
            MarketUnits = MarketUnits + MeatStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }

        for(int i = 0; i<dairy_count; i++){
            DairyStalls.add(new DairyStall(i+1));
            MarketUnits = MarketUnits + DairyStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }

        for(int i = 0; i<fruit_count; i++){
            FruitStalls.add(new FruitStall(i+1));
            MarketUnits = MarketUnits + FruitStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }

        for(int i = 0; i<veg_count; i++){
            VegetableStalls.add(new VegetableStall(i+1));
            MarketUnits = MarketUnits + VegetableStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }

        for(int i = 0; i<bev_count; i++){
            BeverageStalls.add(new BeverageStall(i+1));
            MarketUnits = MarketUnits + BeverageStalls.get(i).getUnits();
            if(i+1>MostStalls){MostStalls = i+1;}
        }
    }

    /**
     * Method to retrieve number of units for the market.
     * 
     * @return Number of units occupied by market. 
     * 
     */
    public int getUnits(){
        return MarketUnits;
    }

    /**
     * Method to check if the market has available units.
     * 
     * @return True if there is space, otherwise false. 
     * 
     */
    public boolean hasUnits(){
        return MarketUnits<750;
    }

    /**
     * Method to retrieve number of customers who have entered the market.
     * 
     * @return Total number of customers who entered the market. 
     * 
     */
    public int getCustomersEntered(){
        return CustomersEntered;
    }

    /**
     * Method to retrieve number of customers who have left the market.
     * 
     * @return Total number of customers who left the market. 
     * 
     */
    public int getCustomersLeft(){
        return CustomersLeft;
    }

    /**
     * Method called when a new customer is to be added to the Market.
     * 
     * This method calls a different method to add a customer to a queue.
     */
    public void addNewCustomer(){
        //A new customer is created and passed on another method to be placed in a stall
        Customer customer = new Customer(++CustomersEntered);
        customer.setMarketArrivalTime(MarketSimulation.getCurrentTime());
        System.out.println("Customer "+customer.getID()+" has entered the market.");
        MarketUnits++;
        addCustomer(customer);
    }

    /**
     * Method called to add a customer to a queue.
     * 
     * Sequentially checks a customers needs and then calls methods to place in a queue with least number of customers. 
     * 
     * @param customer Customer to be added to a queue.
     */
    private void addCustomer(Customer customer){ 
        //If a customer has all needs satisfied he is removed from the market
        if(customer.needsNothing()){
            AverageCustomerTimes.add(MarketSimulation.getCurrentTime()-customer.getMarketArrivalTime());
            System.out.println("Customer "+customer.getID()+" has left the market.");
            CustomersLeft++;
            MarketUnits--;
            return;
        }
        if(customer.needsBaked()){
            if(decideAndPlace(customer, BakedStalls)){return;}
        }
        if(customer.needsMeat()){
            if(decideAndPlace(customer, MeatStalls)){return;}
        }           
        if(customer.needsDairy()){
            if(decideAndPlace(customer, DairyStalls)){return;}
        }
        if(customer.needsFruit()){
            if(decideAndPlace(customer, FruitStalls)){return;}
        }
        if(customer.needsVegetable()){
            if(decideAndPlace(customer, VegetableStalls)){return;}
        }
        if(customer.needsBeverage()){
            if(decideAndPlace(customer, BeverageStalls)){return;}
        } 
        //If a customer cannot be placed in any stall he is added to the waiting area
        WaitingArea.add(customer);
        System.out.println("No available spots in any queues for the stalls that match needs.");
        System.out.println("Customer "+customer.getID()+" has entered the waiting area.");
    }

    /**
     * Method to try and add a customer to the emptiest stall of a given type.
     * 
     * Sequentially checks stalls and their capacities to determine which stall has the most available units.
     * 
     * @param customer Customer to be added to a queue.
     * @param StallList The list of stalls to be decided from.
     */
    private boolean decideAndPlace(Customer customer, ArrayList<Stall> StallList){
        //Stores whether or not a customer can be placed in any stall in the list
        boolean can_be_placed = false;
        //Will store index of the ArrayList corresponding to the stall with the smallest queue
        int emptiest_stall_index = 0;
        //Will store the most number of available units amongst all the stalls in the list
        int most_available_units = 0;
        for(int i = 0; i<StallList.size(); i++){
            if(StallList.get(i).hasUnits()){
                can_be_placed = true;
                //When the available units for a stall are greater than most_available_units
                //its value is updated and the emptiest_stall_index is changed
                if((35-StallList.get(i).getUnits())>most_available_units){
                    most_available_units = (35-StallList.get(i).getUnits());
                    emptiest_stall_index = i;
                }
            }
        }
        //Customer will be placed only if there is place in any stall
        if(can_be_placed){StallList.get(emptiest_stall_index).addCustomer(customer);}
        //Returns whether or not customer was placed
        return can_be_placed;
    }

    /**
     * Method to check waiting area and try to place the customers in waiting area in an available queue.
     * 
     * @return Returns the size of the waiting area after it is processed.
     */ 
    public int checkWaitingArea(){
        if(WaitingArea.size() == 0)
            return 0;
        //Size of waiting area when function is called
        int starting_size = WaitingArea.size();
        //Size of waiting area as it changes while trying to remove customers
        int running_size = WaitingArea.size();
        Customer customer;
        for(int i = 0; i<starting_size; i++){
            //Customer is removed from the top and then passed on to be added to a stall
            customer = WaitingArea.remove(0);
            System.out.println("Customer "+customer.getID()+" will try to leave the waiting area.");
            addCustomer(customer);
            //If customer cannot be placed again he will be re-added at the back of the ArrayList

            //If the current size is different from previous iteration of the loop the customer was removed from the waiting area
            if(running_size!=WaitingArea.size()){
                System.out.println("Customer "+customer.getID()+" has successfully left the waiting area.");
                running_size--;
            }
        }
        return WaitingArea.size();
    }

    /**
     * Method to check and adjust the queues for every stall.
     * 
     * If a customer is removed from a queue it is added to a different queue.
     */ 
    public void checkQueues(){
        Customer customer;
        for(int i =0; i<MostStalls; i++){
            //If a customer is removed from a stall he is returned and then passed to be added to a different stall
            if(BakedStalls.size()>i){
                customer = BakedStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
            if(MeatStalls.size()>i){
                customer = MeatStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
            if(DairyStalls.size()>i){
                customer = DairyStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
            if(FruitStalls.size()>i){
                customer = FruitStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
            if(VegetableStalls.size()>i){
                customer = VegetableStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
            if(BeverageStalls.size()>i){
                customer = BeverageStalls.get(i).checkAndRemove();
                if(customer!=null)
                    addCustomer(customer);
            }
        }
    }

    /**
     * Method to calculate and return the average time spent by customers in the market.
     * 
     * @return Returns the average time spent.
     */ 
    public int getAverageCustomerTime(){
        if(AverageCustomerTimes.size()==0)
            return -1;
        else{
            int sum = 0;
            for(int i = 0; i<AverageCustomerTimes.size(); i++){
                sum = sum + AverageCustomerTimes.get(i);
            }
            return sum/AverageCustomerTimes.size();
        }
    }

    /**
     * Method to print a set of stats for each stall.
     * 
     * This method calls another method pertaining to each different stall.
     */ 
    public void printStallStats(){
        for(int i =0; i<MostStalls; i++){
            if(BakedStalls.size()>i){
                BakedStalls.get(i).printCustomerStats();
            }
            if(MeatStalls.size()>i){
                MeatStalls.get(i).printCustomerStats();
            }
            if(DairyStalls.size()>i){
                DairyStalls.get(i).printCustomerStats();
            }
            if(FruitStalls.size()>i){
                FruitStalls.get(i).printCustomerStats();
            }
            if(VegetableStalls.size()>i){
                VegetableStalls.get(i).printCustomerStats();
            }
            if(BeverageStalls.size()>i){
                BeverageStalls.get(i).printCustomerStats();
            }
        }
    }
}
