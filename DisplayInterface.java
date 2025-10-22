public interface DisplayInterface
{
    /* The purpose of this interface is to solve the problem of different outputs of different class objects.
    * Thanks to this interface, every class has a unique display string and they can be called without code redundancy by using
    * polymorphism in the DisplayList method of the SLinkedList class.
    */
    public String getDisplayString(); 
}