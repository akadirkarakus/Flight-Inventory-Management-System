public class Cabin_Crew extends Person
{
    private String job;
    private double credit;
    
    public Cabin_Crew(String job, double credit)
    {
        this.job = job;
        this.credit = credit;
    }

    public double getCredit()
    {
        return credit;
    }
    public String getJob()
    {
        return job;
    }
}
