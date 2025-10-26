public class Cabin_Crew extends Person 
{
    private final String job;
    private final double credit;
    
    public Cabin_Crew(String name, long ID, String job, double credit)
    {
        this.job = job;
        this.credit = credit;
        this.name = name;
        this.ID = ID;
        this.type = "cabin-crew";
    }

    public double getCredit()
    {
        return credit;
    }
    public String getJob()
    {
        return job;
    }
    
    @Override
    public String getDisplayString()
    {
        String personInfo = super.getDisplayString();
        return (personInfo+" Job: "+job+ ", Credit: "+credit);
    }

   
}
