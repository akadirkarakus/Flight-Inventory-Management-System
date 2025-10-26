public class Passenger extends Person
{
    private final String ticket;
    private final int priority;
    
    public Passenger(String name, long ID, String ticket, int priority)
    {
        this.ticket = ticket;
        this.priority = priority;
        this.name = name;
        this.ID = ID;
        this.type = "passanger";
    }
    
    public int getPriority()
    {
        return priority;
    }

    @Override
    public String getDisplayString()
    {
        String personInfo = super.getDisplayString();
        return (personInfo + " Ticket: "+ticket+ ", Priority: "+priority);
    }
}
