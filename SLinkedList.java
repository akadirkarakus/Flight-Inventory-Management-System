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
            if(!item.getDisplayString().equals("")) 
                resultBuilder.append(item.getDisplayString());
                
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
        else if(newNode.getObject() instanceof Person) //Detecting whether newItem is a person or a list:
        {
            Node<T> temp = head;
            Node<T> temp2 = temp.getNext();

            if(newNode.getObject() instanceof Passenger passenger) 
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
            resultBuilder.append((temp.getObject()).getDisplayString()).append("\n");
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
}





/* REMOVE METODUYLA BİRİNİ SİLEBİLİİYORUM. AMA SONRASINDA YENİ BİRİ EKLEYEMİYORUM, YA DA EKLİYORUM AMA LİSTELENMYİOR. */







    


















