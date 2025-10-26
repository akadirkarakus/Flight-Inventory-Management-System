public class Passenger extends Person implements DisplayInterface
{
    private String ticket;
    private int priority;
    
    public Passenger(String name, long ID, String ticket, int priority)
    {
        this.ticket = ticket;
        this.priority = priority;
        this.name = name;
        this.ID = ID;
        this.type = "Passenger";
    }
    
    public int getPriority()
    {
        return priority;
    }

    @Override
    public String getDisplayString()
    {
        return (getPersonDisplay()+", Ticket: "+ticket+ ", Priority: "+priority);
    }
}
