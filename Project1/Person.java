/**
 * Parent Person class.
 * 
 * @author Nakul Talwar
 */
public class Person
{
    //Unique ID for each type of person
    /**Unique ID for each Person*/
    protected int ID;
    /**
     * Default constructor.
     * 
     * Initializes a Person's ID. 
     */
    public Person(int ID)
    {
        this.ID = ID;
    }

    /**
     * Retrieves a person's ID number.
     * 
     * @return Returns ID as integer.
     */
    public int getID(){
        return ID;
    }
}
