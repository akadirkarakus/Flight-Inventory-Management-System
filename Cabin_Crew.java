public class Cabin_Crew extends Person implements DisplayInterface
{
    private String job;
    private double credit;
    
    public Cabin_Crew(String name, long ID, String job, double credit)
    {
        this.job = job;
        this.credit = credit;
        this.name = name;
        this.ID = ID;
        this.type = "Cabin-crew";
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
        return (getPersonDisplay()+", Job: "+job+ ", Credit: "+credit);
    }

   
}
