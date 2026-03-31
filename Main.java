import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        /* --- ESSENTIAL DECLERATIONS --------------------------- */

        SLinkedList<Passenger> economy_passangers_list = new SLinkedList<>();
        SLinkedList<Passenger> economy_premium_passangers_list = new SLinkedList<>();
        SLinkedList<Passenger> business_passangers_list = new SLinkedList<>();
        SLinkedList<Cabin_Crew> cabin_crew_list = new SLinkedList<>();
        SLinkedList<SLinkedList<?>> list_of_lists = new SLinkedList<>();    
        
        list_of_lists.Add(economy_passangers_list);
        list_of_lists.Add(economy_premium_passangers_list);
        list_of_lists.Add(business_passangers_list);
        list_of_lists.Add(cabin_crew_list);
            
        Scanner s = new Scanner(System.in);


        /* ------------- BODY OF THE MAIN METHOD ------------- */

        while (true) //The operation choosing loop.
        {
            System.out.println("Enter the operation: \n" +
                   "1: Add a person \n" +
                   "2: Print all the lists \n" +
                   "3: Delete all the people with the given ID \n" +
                   "4: Combine all the lists sorted by ID, print and then exit");
            int choosen;
            try {
                choosen = s.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Input. Please enter 1, 2, 3 or 4 as an integer.");
                s.nextLine();
                continue;
            }
            s.nextLine();

            switch (choosen) //Purpose of This Part: Detecting what the user chose and calling the needed function accordingly.
            {
                case 1 : //Add person
                    String type;
                    String name;
                    long ID;
                    try  
                    {   //Purpose: Collecting the base information about new person.
                        System.out.println("Enter the name: ");
                        name = s.nextLine();
                        System.out.println("Enter the ID: ");
                        ID = s.nextLong();
                        System.out.println("Enter the type (passanger or cabin-crew): ");
                        type = s.next();
                        
                    } catch (Exception e) 
                    {
                        System.err.println("ERROR: Invalid input!");
                        s.nextLine();
                        continue;
                    }
                    
                    switch(type) 
                    {
                        case "passanger": //Add operation for passenger objects.
                            System.out.println("Enter the ticket type (economy, economy-premium, business):");
                            String ticket = s.next();
                            int priority;
                            try 
                            {
                                System.out.println("Enter the priority:");
                                priority = s.nextInt();
                            } catch (Exception e) 
                            {
                                System.err.println("ERROR: Invalid input! Please enter an integer value.");
                                s.nextLine();
                                continue;
                            }
                            
                            Passenger newPassenger = new Passenger(name, ID, ticket, priority);
                            switch(ticket) //Purpose: Fİnding the ticket type of passenger to add passenger related list.
                            {
                                case "economy":
                                    economy_passangers_list.Add(newPassenger);
                                break;
                                case "economy-premium":
                                    economy_premium_passangers_list.Add(newPassenger);
                                    break;
                                case "business" :
                                    business_passangers_list.Add(newPassenger);
                                    break;
                                default : 
                                    System.out.println("ERROR: Invalid ticket type.");
                                    break;
                            }
                        break;
                        case "cabin-crew" :
                            s.nextLine();
                            System.out.println("Enter the job: ");
                            String job = s.nextLine();
                            System.out.println("Enter the credit: ");
                            int credit;
                            try {
                                credit = s.nextInt();
                            } catch (Exception e) {
                                System.out.println("ERROR: Invalid Input. Please enter an integer.");
                                s.nextLine();
                                continue;
                            }
                            Cabin_Crew newCrew = new Cabin_Crew(name, ID, job, credit);
                            cabin_crew_list.Add(newCrew);
                        break;
                    }
                System.out.println("");
                break;

                case 2 :                
                    list_of_lists.DisplayList();
                    System.out.println();
                break;
                case 3 :
                    System.out.println("Enter the ID to delete:");
                    long id = s.nextInt();
                    list_of_lists.RemoveByID(id);
                    System.out.println();
                break;
                case 4:
                    SLinkedList<?> sortedList;
                    sortedList = list_of_lists.SortListByID();
                    sortedList.DisplayList();
                    return;
            }
        }
    }    
}