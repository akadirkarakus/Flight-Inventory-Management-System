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

    @Override
    public String toString()
    {
        Node<T> temp = head;
        String result = "";
        while(temp != null)
        {
            result += "Priority: "+ getCabinCrewObject(temp).getCredit()+" Job: "+ getCabinCrewObject(temp).getJob()+"\n";
            temp=temp.getNext();
        }
        return result;
    } 

    /* ---  ADD METHODS   ---  */
    /*------------------------ */
    public void AddItem(Node<T> newItem)
    {
        //Detecting whether newItem is a person or a list:
        if(newItem.getObject() instanceof Person)
        {
            System.out.println("person");
            if(head == null)
            {
                head = newItem;
                tail = newItem;
                count++;
                System.out.println("head: "+head);
            }
            else
            {
                if(newItem.getObject() instanceof Passenger)
                {
                    Node<T> temp = head;
                    while(temp != null)
                    {

                    }
                }
                else //Cabin_Crew 
                {
                    System.out.println("Cabincrew");
                    Node<T> temp =  head;
                    Node<T> temp2 = temp.getNext();
                    double newItemCredit = getCabinCrewObject(newItem).getCredit();
                    if(newItemCredit <= getCabinCrewObject(head).getCredit())
                    {
                            newItem.setNext(head);
                            head = newItem;
                    }
                    else
                    {
                        System.out.println(2);
                        while(temp != null)//Fİnding the correct place of the newItem
                        {
                            double tempCredit = getCabinCrewObject(temp).getCredit();
                            double temp2Credit = -1;
                            if(temp2 != null)
                                temp2Credit = getCabinCrewObject(temp2).getCredit();

                        
                            if((newItemCredit > tempCredit && newItemCredit <= temp2Credit) || (newItemCredit > tempCredit && temp2 == null))
                            {              
                                temp.setNext(newItem);
                                newItem.setNext(temp2);
                                if(temp2 == null)
                                    tail = newItem;
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
        }
        else
        {
            System.out.println("not person");
        }

        
    }










    /*Some useful methods to decrease code redundancy and provide simplicity */
    /*--------------------------------------------- */
    private Cabin_Crew getCabinCrewObject(Node<T> node)
        {
            /*This method takes the node, turn it into a Cabin_crew object by casting 
            by aimnig to reach Cabin_Crew class methods using nodes. */
            if(node != null)
            {
                return (Cabin_Crew)node.getObject();
            }
            else
                return null;
        }







    
}

















