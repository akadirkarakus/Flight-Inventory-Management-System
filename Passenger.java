public class Passenger extends Person
{
    //String name, type; 
    //long ID
    private String ticket;
    private int priority;
    
    public Passenger(String ticket, int priority)
    {
        this.ticket = ticket;
        this.priority = priority;
    }
    
    public int getPriority()
    {
        return priority;
    }
}
