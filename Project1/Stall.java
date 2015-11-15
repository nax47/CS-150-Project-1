import java.io.*;
import java.util.*;
/**
 * Parent Stall class.
 * 
 * @author Nakul Talwar
 */
public class Stall
{
    //Queue for customers
    private Queue<Customer> CustomerQueue;
    //ArrayList to store Worker objects
    private ArrayList<Worker> Workers;
    /**Object to generate random times over a Gaussian distribution*/
    protected GaussianGenerator StallTimeGenerator;
    /**Number of units being occupied by the stall*/
    protected int StallUnits;
    //Unique Stall IDs within each type of stall
    private int ID;
    /**String to store the "type" of each stall*/
    protected String type;
    //Stores the amount of time to wait before a customer can leave the queue after reaching the front
    private int RemoveCustomerInterval;
    //Incrementer to count time units from the time a customer reaches the front of the queue
    private int RemoveCustomerRunningInterval;
    //Stores whether the queue is empty or not
    private boolean QueueIsEmpty;
    //Stores total number of customers who have entered the queue for this stall
    private int CustomersEntered;
    //Stores total number of customers who have left the queue for this stall
    private int CustomersLeft;
    //ArrayList to store waiting time for each customer after entering the queue
    private ArrayList<Integer> AverageCustomerTimes;
    /**
     * Default constructor.
     * 
     * Initializes ID and initial state for all variables. 
     * 
     * @param ID Unique ID for every instance of certain type of stall.
     */
    public Stall(int ID)
    {
        StallUnits = 0;
        this.ID = ID;
        RemoveCustomerInterval=0;
        RemoveCustomerRunningInterval=0;
        CustomersEntered = 0;
        CustomersLeft = 0;
        CustomerQueue = new Queue<Customer>();
        QueueIsEmpty = true;
        AverageCustomerTimes = new ArrayList<Integer>();
        Workers = new ArrayList<Worker>();
        for(int i = 0; i<2; i++){
            Workers.add(new Worker(i+1));
            StallUnits++;
        }
        //Default values to prevent excpetions
        type = "Generic";
        StallTimeGenerator = new GaussianGenerator(0,0);
    }

    /**
     * Retrieves the Customer queue in its current state.
     * 
     * @return Returns the current queue.
     */ 
    public Queue<Customer> getQueue(){
        return CustomerQueue;
    }

    /**
     * Method to retrieve number of units for each stall.
     * 
     * @return Number of units occupied by stall. 
     */
    public int getUnits(){
        return StallUnits;
    }

    /**
     * Method to check if stall has available units.
     * 
     * @return True if there is space, otherwise false. 
     */
    public boolean hasUnits(){
        return StallUnits<35;
    }

    /**
     * Method to add a new Customer to the queue.
     * 
     * @param customer Customer object to be added.
     */ 
    public void addCustomer(Customer customer){
        CustomerQueue.offer(customer);
        StallUnits++;
        CustomersEntered++;
        customer.setStallArrivalTime(MarketSimulation.getCurrentTime());
        System.out.println("Customer "+customer.getID()+" has joined queue for "+type+" Stall "+ID+".");
        //If the queue is empty when the customer is added the RemoveCustomerInterval will be set based on a randomly generate number
        //The incrementer will also be reset to zero and the state of the queue will be changed
        if(QueueIsEmpty){
            //Absolute value is taken to prevent negative values
            RemoveCustomerInterval = Math.abs(StallTimeGenerator.generate());
            //If the interval is set to zero it is incremented because the customer cannot be removed from the queue in the same time instance
            if(RemoveCustomerInterval == 0){RemoveCustomerInterval++;}
            RemoveCustomerRunningInterval = 0;
            QueueIsEmpty = false;
        }
    }

    /**
     * Method to check if the customer at the front of the queue has finished.
     * 
     * If the customer has finished he is removed from the queue.
     * 
     * @return Customer removed from the queue is retrieved and returned.
     */ 
    public Customer checkAndRemove(){
        if(QueueIsEmpty){
            return null;
        }
        //If the incrementer reaches the time set for the interval the customer at the front of the queue will be removed
        if(RemoveCustomerInterval == RemoveCustomerRunningInterval){
            Customer customer = CustomerQueue.remove();
            StallUnits--;
            CustomersLeft++;
            //Stores time spent by the customer at the stall.
            AverageCustomerTimes.add(MarketSimulation.getCurrentTime()-customer.getStallArrivalTime());
            //After removing checks and changes the state if necessary
            if(CustomerQueue.size() == 0){
                QueueIsEmpty = true;
            }
            //If the queue still has customers in line a new interval time is generated and incrementer reset to zero
            else{    
                //Absolute value is taken to prevent negative values
                RemoveCustomerInterval = Math.abs(StallTimeGenerator.generate());
                //If the interval is set to zero it is incremented because the customer cannot be removed from the queue in the same time instance
                if(RemoveCustomerInterval == 0){RemoveCustomerInterval++;}
                RemoveCustomerRunningInterval = 0;
            }
            System.out.println("Customer "+customer.getID()+" has left queue for "+type+" Stall "+ID+".");
            RemoveCustomerRunningInterval++;
            //Changes the needs before returning customer to Market class
            customer.changeNeeds(type);
            return customer;
        }

        RemoveCustomerRunningInterval++;
        return null;
    }

    /**
     * Method to calculate and return the average waiting time for customers at the stall.
     * 
     * @return Returns the average waiting time
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
     * Method to print a set of statistics for the stall.
     */ 
    public void printCustomerStats(){
        System.out.println("\n"+type+" Stall "+ID+":");
        System.out.println("Number of customers entered: "+CustomersEntered);
        System.out.println("Number of customers served: "+CustomersLeft);
        System.out.println("Average time spent by each customer: "+getAverageCustomerTime()+" seconds");
    }

    /**
     * Retrieves a stall's ID number.
     * 
     * @return Returns ID as integer.
     */
    public int getID(){
        return ID;
    }
}
