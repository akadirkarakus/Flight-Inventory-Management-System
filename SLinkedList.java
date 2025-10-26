

public class SLinkedList <T extends DisplayInterface>  implements DisplayInterface //Keeps either people or list.
{
    private Node<T> head, tail;
    private int count;

    public SLinkedList()
    {
        count = 0;
        head = null;
        tail = null;
    }

    private void setCount(int count)
    {
        this.count = count;
    }
    public int getCount()
    {
        return count;
    }
    private Node<T> getHead()
    {
        return head;
    }
    public void DisplayList() 
    {
        /* This method prints all the lists. 
         * Also it was developed to be able to print just one list by calling it like cabin_crew_list.DisplayList() 
         * But this feature is not used in this project since it is not needed.
        */

        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        StringBuilder resultBuilder = new StringBuilder();
        Node<T> temp = head;
        while(temp != null)
        {                                         
            DisplayInterface item = temp.getObject(); 
            if(item.getDisplayString().length()!= 0) 
            {
                if(resultBuilder.length()!= 0)
                    resultBuilder.append("\n");
                resultBuilder.append(item.getDisplayString());
            }
                
            temp = temp.getNext();
        }

        if (resultBuilder.length() != 0)
            System.out.println(resultBuilder.toString());
        else
            System.out.println("There is no item in the list.");
        System.out.println("--------------------------------------------------------------");
    }

    /* ---  ADD METHODS   ---  */
    /*------------------------ */
    public void Add(T newItem) 
    {
        Node<T> newNode = new Node<>(newItem); //the object is converted to a node to put it into a list. (Object is passenger, cabin_crew or SLinkedList in this context.)
        
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            count++;
        }
        else if(newItem instanceof Person) //Detecting whether newItem is a person or a list:
        {
            Node<T> temp = head;
            Node<T> temp2 = temp.getNext();

            if(newItem instanceof Passenger passenger) //Passenger
            {
                
                int newPriority = passenger.getPriority();
                
                if(newPriority <= ((Passenger) head.getObject()).getPriority())
                {
                    newNode.setNext(head);
                    head = newNode;
                }
                else
                {
                    
                    while(temp != null)//Fİnding the correct place of the newItem
                    {
                        int tempPrio = ((Passenger)temp.getObject()).getPriority();
                        int temp2Prio = -1;
                        if(temp2 != null)
                            temp2Prio = ((Passenger)temp2.getObject()).getPriority();

                        if((newPriority > tempPrio && newPriority <= temp2Prio) || (newPriority >tempPrio && temp2 == null))
                        {
                            temp.setNext(newNode);
                            newNode.setNext(temp2);
                            if(temp2 == null)
                                tail = newNode;
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
            else //Cabin_Crew 
            {
                double newItemCredit = ((Cabin_Crew)newNode.getObject()).getCredit();

                if(newItemCredit <= ((Cabin_Crew)head.getObject()).getCredit())
                {
                        newNode.setNext(head);
                        head = newNode;
                }
                else
                {
                    while(temp != null)//Fİnding the correct place of the newItem
                    {
                        double tempCredit = ((Cabin_Crew)temp.getObject()).getCredit();
                        double temp2Credit = -1;
                        if(temp2 != null)
                            temp2Credit = ((Cabin_Crew)temp2.getObject()).getCredit();

                        if((newItemCredit > tempCredit && newItemCredit <= temp2Credit) || (newItemCredit > tempCredit && temp2 == null))
                        {              
                            temp.setNext(newNode);
                            newNode.setNext(temp2);
                            if(temp2 == null)
                                tail = newNode;
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
            //Passenger
            System.out.println("New item has been added successfully.");      
        }
        
        else //adding process for list_of_list, it will be an AddLast method.
        {
            //we've already created the node top of this method with the name of newNode, and add newNode to list if the list empty.
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public String getDisplayString() //Write all of the elements of all of the lists.
    {
        StringBuilder resultBuilder = new StringBuilder();
        Node<T> temp = head;
        while(temp!=null)
        {
            if(resultBuilder.length()!=0)
                resultBuilder.append("\n");
            resultBuilder.append((temp.getObject()).getDisplayString());
            temp = temp.getNext();
        }
        return resultBuilder.toString();
    }


    public void RemoveByID(long id) //This method can be used just for the list_of_list.
    {
        if (head == null)
        {
            System.out.println("There is no item found.");
        }
        else if(!(head.getObject() instanceof SLinkedList))
        {
            System.out.println("ERROR: Only list of lists are removable.");
        }
        else
        {
            Node<T> listIterator = head; //will iterate between the lists. (economy_passenger_list, cabin_crew_list etc.)
            while(listIterator != null)
            {
                SLinkedList<T> innerList = ((SLinkedList<T>)listIterator.getObject()); //It is inner list of a list_of_list which can be one of the economy_passenger_list or cabin_crew_list etc.

                Node<T> innerTemp = innerList.head; 
                Node<T> innerPrev = null; //the previous node of innerTemp.
                
                while(innerTemp != null)
                {
                    if(((Person)innerTemp.getObject()).getID() == id)
                    {
                        if(innerPrev != null)
                        {
                            innerPrev.setNext(innerTemp.getNext());
                            innerTemp.setNext(null);
                        }
                        else
                            innerList.head = innerTemp.getNext();
                        innerList.setCount(count--);
                        System.out.println("The person with "+id+" has been deleted successfully.");
                        return;
                    }
                    else
                    {
                        innerPrev = innerTemp;
                        innerTemp = innerTemp.getNext();
                    }
                }
                listIterator = listIterator.getNext();
            }
            System.out.println("ERROR: Any person couldn't found with this id.");
        }   
    }

    public SLinkedList<T> SortListByID ()
    {   
        /*This method runs just for list_of_list method, and sort all the person according to ther ID's, 
        * then returns an sorted SLinkedList in type of person. */

        /*Algorithm of sorting for this method: It assumes that the head node has the smallest ID. Then it compare this value 
         * with all of the node's ID value until there is a smaller ID number, if any. By this way, method founds the smallest 
         * ID number and put it into the new sorted list as head. Then, between the other nodes, the same process is repeated
         * and the minimum among the remaining part is added after the previous minimum node.
         */

        if (head == null)
        {
            System.out.println("There is no item found.");
        }
        else if(!(head.getObject() instanceof SLinkedList))
        {
            System.out.println("ERROR: Only list of lists are suitable for sorting by ID.");
        }
        else
        {
            Node<SLinkedList<T>> outerNode = (Node<SLinkedList<T>>)head; //will iterate between the lists. (economy_passenger_list, cabin_crew_list etc.)
            SLinkedList<T> sortedList = new SLinkedList<>();

            while(outerNode != null)
            {
                SLinkedList<T> innerList = (SLinkedList<T>)outerNode.getObject(); 
                //innerList represents one of the four lists (cabin-crew_list, economy_passenger _list etc. )

                if(innerList != null)
                {
                    Node<T> innerNode = innerList.getHead();
                    while(innerNode!=null)
                    {
                        T currentPerson = innerNode.getObject();
                        sortedList.InsertInSortedOrder(currentPerson);
                        innerNode = innerNode.getNext();
                    }
                }
                outerNode = outerNode.getNext(); 
            }
            return sortedList;
        }
        return null;
    }


    public void InsertInSortedOrder(T person)
    {
        long newPersonId = ((Person)person).getID();
        Node<T> newNode = new Node<>(person);

        if(head == null)
        {
            head = newNode;
            tail = newNode;
            count++;
        }
        else
        {
            Node<T> temp = head;
            Node<T> prevTemp = null; //previous node of the temp.
            while(temp!=null)
            {
                if(newPersonId <= ((Person)temp.getObject()).getID())
                {
                    newNode.setNext(temp);
                    if(prevTemp == null)    
                        head = newNode;
                    else
                        prevTemp.setNext(newNode);
                    return;
                }
                else if(newPersonId > ((Person)tail.getObject()).getID())
                {
                    tail.setNext(newNode);
                    tail = newNode;
                    return;
                }
                prevTemp = temp;
                temp=temp.getNext();
                
            }
        }
    }
}












    


















