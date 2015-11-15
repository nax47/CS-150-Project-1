import java.io.*;
import java.util.concurrent.TimeUnit;
/**
 * MarketSimulation class.
 * 
 * @author Nakul Talwar
 */
public class MarketSimulation
{
    //Stores current time during each simulation run in simulated seconds
    private static int CurrentTime;
    //Stores the amount of time to wait before adding a new customer to the market
    private int AddNewCustomerInterval;
    //Incrementer to count time units from the time a customer enters the market to when another customer is added
    private int AddNewCustomerRunningInterval;
    //Total simulation time in simulated seconds
    private static final int TotalMarketTime = 12600;
    //Object for generating arrival times in a Gaussian distribution
    private GaussianGenerator ArrivalTimeGenerator;
    //Object to read console input for the interface
    private BufferedReader br;
    /**
     * Default constructor.
     * 
     * Initializes several simulation parameters.
     */
    public MarketSimulation()
    {
        CurrentTime = 0;
        AddNewCustomerInterval=0;
        AddNewCustomerRunningInterval=0;
        ArrivalTimeGenerator = new GaussianGenerator(61,31);
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Main method to run the simulation.
     * 
     * @param args Any arguments passed via the command line.
     */
    public static void main(String[] args){
        MarketSimulation sim = new MarketSimulation();
        sim.simInterface();
    }

    /**
     * Method to provide a text based interface for a more user friendly approach to using the software.
     */
    private void simInterface(){
        try{
            System.out.println("\fWelcome to the Easton Farmer's Market!");
            System.out.println("\nHow many stalls for baked goods?");
            int baked_count = Integer.parseInt(br.readLine());
            System.out.println("\nHow many stalls for meat?");
            int meat_count = Integer.parseInt(br.readLine());
            System.out.println("\nHow many stalls for dairy products?");
            int dairy_count = Integer.parseInt(br.readLine());
            System.out.println("\nHow many stalls for fruit?");
            int fruit_count = Integer.parseInt(br.readLine());
            System.out.println("\nHow many stalls for vegetables?");
            int veg_count = Integer.parseInt(br.readLine());
            System.out.println("\nHow many stalls for beverages?");
            int bev_count = Integer.parseInt(br.readLine());
            Market market = new Market(baked_count, meat_count, dairy_count, fruit_count, veg_count, bev_count);
            System.out.println("\fNumber of units being occupied at initial state for this configuration: "+market.getUnits());
            if(market.hasUnits()){
                System.out.println("This is a valid configuration.");
                System.out.println("\nWould you like to begin the simulation? \n1 - Yes \n2 - No");
                if(Integer.parseInt(br.readLine()) == 1){
                    System.out.println("\nMarket configuration:\nStalls for baked goods: "+baked_count+
                        "\nStalls for meat: "+meat_count+"\nStalls for dairy products: "+dairy_count+
                        "\nStalls for fruit: "+fruit_count+"\nStalls for vegetables: "+veg_count+
                        "\nStalls for beverages: "+bev_count);
                    simulate(market);
                }
                else{
                    System.out.println("\nThe interface will now restart...");
                    //Waits 4 seconds before restarting the interface
                    try{TimeUnit.SECONDS.sleep(4);}
                    catch(InterruptedException e){System.out.println(e.toString());}
                    simInterface();
                }
            }
            else{
                System.out.println("This is an invalid configuration!");
                System.out.println("\nThe interface will now restart...");
                //Waits 4 seconds before restarting the interface
                try{TimeUnit.SECONDS.sleep(4);}
                catch(InterruptedException e){System.out.println(e.toString());}
                simInterface();
            }

        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Method that actually controls events in the simulation.
     * 
     * @param market Market object that is passed by a different method. This particular market is simulated.
     */
    private void simulate(Market market){
        long startTime = System.nanoTime();
        while(true){
            System.out.println("\nTime: "+CurrentTime+"\n");
            //When the current time reaches the total time, the market is closed and the program stops
            if(CurrentTime == TotalMarketTime){
                System.out.println("Market has now closed!\n");
                System.out.println("Number of customers who entered the market: "+market.getCustomersEntered());
                System.out.println("Number of customers who left the market: "+market.getCustomersLeft());
                System.out.println("Average time spent in the market by each customer: "+market.getAverageCustomerTime()+" seconds");
                System.out.println("\nStats for each stall-");
                market.printStallStats();
                long stopTime = System.nanoTime();
                System.out.println("\nRunTime taken in nanoseconds: "+(stopTime-startTime));
                return;
            }

            //At the beginning of the simulation a new customer will always be added
            //The interval will be set according to the generator
            if(CurrentTime == 0){
                market.addNewCustomer();
                //Absolute value is taken to prevent negative values
                AddNewCustomerInterval = Math.abs(ArrivalTimeGenerator.generate());
                AddNewCustomerRunningInterval = 0;
            }

            //Waiting area is checked at each time step to try and place customers who are waiting
            market.checkWaitingArea();

            //When the incrementer reaches the value of the set interval a new customer is added 
            if(AddNewCustomerInterval == AddNewCustomerRunningInterval){
                //Customer will be added only if there are available units
                if(market.hasUnits()){
                    market.addNewCustomer();
                    //Absolute value is taken to prevent negative values
                    AddNewCustomerInterval = Math.abs(ArrivalTimeGenerator.generate());
                    if(AddNewCustomerInterval == 0){AddNewCustomerInterval++;}
                    AddNewCustomerRunningInterval = 0;
                }
                //If there are no available units the interval is incremented and the incrementer is not reset to zero
                //The new customer will try to be added at the next time step
                else{
                    AddNewCustomerInterval++;
                }
            }
            //Queues are checked at every time step to see if a customer needs to be removed from a stall
            market.checkQueues();
            AddNewCustomerRunningInterval++;
            CurrentTime++;  
        }
    }

    /**
     * Global method to retrieve simulation time. 
     * 
     * This allows other classes to access the time. 
     * Used for storing customer times at the stalls and the market.
     * 
     * @return Returns the simulation time as an integer
     */
    public static int getCurrentTime(){
        return CurrentTime;
    }
}
