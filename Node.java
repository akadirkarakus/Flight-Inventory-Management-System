public class Node <T> // <T> means type of the node: It can be a passenger or a list.
{
    private Node<T> next;
    private final T object; //it will be used to reach data of the person or list
    
    public Node(T object)
    {
        this.object = object;
        this.next = null;
    }

    /*GET-SET METHODS */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }
    public Node<T> getNext()
    {
        return next;
    }
    public T getObject()
    {
        return object;
    }

    
}
