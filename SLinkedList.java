

public class SLinkedList <T>  //Keeps either people or list.
{
    private Node<T> head, tail;
    private int count;

    public SLinkedList()
    {
        count = 0;
        head = null;
        tail = null;
    }

    public void DisplayList()
    {
        System.out.println("---------------------------------------------------------------------");
        Node<T> temp = head;
        while(temp != null)
        {   
            DisplayInterface item = (DisplayInterface) temp.getObject();
            System.out.println(item.getDisplayString());
            temp = temp.getNext();
        }
        System.out.println("---------------------------------------------------------------------");

    }

    /* ---  ADD METHODS   ---  */
    /*------------------------ */
    public void Add(T object) 
    {
        Node<T> node = new Node<>(object); //the object is converted to a node to put it into a list. (Object is passenger, cabin_crew or SLinkedList in this context.)
        if(head == null)
        {
            head = node;
            tail = node;
            count++;
        }
        else if(node.getObject() instanceof Person) //Detecting whether newItem is a person or a list:
        {
            if(node.getObject() instanceof Passenger)
                {
                    Node<T> temp = head;
                    while(temp != null)
                    {

                    }
                }
                else //Cabin_Crew 
                {
                    Node<T> temp =  head;
                    Node<T> temp2 = temp.getNext();
                    double newItemCredit = ((Cabin_Crew)node.getObject()).getCredit();

                    if(newItemCredit <= ((Cabin_Crew)head.getObject()).getCredit())
                    {
                            node.setNext(head);
                            head = node;
                    }
                    else
                    {
                        while(temp != null)//Fİnding the correct place of the newItem
                        {
                            double tempCredit = ((Cabin_Crew)temp.getObject()).getCredit();
                            double temp2Credit = -1;
                            if(temp2 != null)
                                temp2Credit = ((Cabin_Crew)temp.getObject()).getCredit();

                        
                            if((newItemCredit > tempCredit && newItemCredit <= temp2Credit) || (newItemCredit > tempCredit && temp2 == null))
                            {              
                                temp.setNext(node);
                                node.setNext(temp2);
                                if(temp2 == null)
                                    tail = node;
                                return;
                            }
                            else
                            {
                                temp=temp.getNext();
                                if(temp2 != null)
                                    temp2 = temp2.getNext();
                            }
                        }
                    }
                    
                }    
                
            }
        
        else
        {
            System.out.println("not person");
        }
        System.out.println("New item successfully added. -----------------");


        
    }











    /*Some useful methods to decrease code redundancy and provide simplicity */
    /*--------------------------------------------- */
    


}







    


















