public class Person 
{
    protected String name, type;
    protected long ID;

    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public long getID()
    {
        return ID;
    }

    protected String getPersonDisplay()
    {
        /*
         * This method is used for decreasing code redundancy by collecting common things for the getDisplayString methods.
         * Thanks to this method, common values of persons are not indicated for each class, they just call this method.
         */
        return ("Name: "+ name+", Type: "+type+", ID: "+ID);
    }
}
