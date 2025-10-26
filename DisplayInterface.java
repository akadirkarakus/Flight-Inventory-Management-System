public interface DisplayInterface
{
    /* The purpose of this interface is to solve the problem of different outputs of different class objects.
    * Thanks to this interface, every class has a unique display string and they can be called without code redundancy by using
    * polymorphism in the DisplayList method of the SLinkedList class.
    */
    public String getDisplayString(); 
    //public Number getSortValue(); ////WILL BE DLEETED.
    
    /*This method returns priority for passenger class, and credit for cabin-crew class. The aim is decreasig the
    code redundacy on the add method, by escaping to write similar code for both passenger and cabin-crew cases in the add method.
     */
}