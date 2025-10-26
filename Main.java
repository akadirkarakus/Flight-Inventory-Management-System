import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        /*CREATE 4 LINKED LIST HERE. */

        SLinkedList<Passenger> economy_passangers_list = new SLinkedList<>();
        SLinkedList<Passenger> economy_premium_passangers_list = new SLinkedList<>();
        SLinkedList<Passenger> business_passangers_list = new SLinkedList<>();
        SLinkedList<Cabin_Crew> cabin_crew_list = new SLinkedList<>();
        SLinkedList<SLinkedList<?>> list_of_lists = new SLinkedList<>();    
        
        list_of_lists.Add(business_passangers_list);
        list_of_lists.Add(economy_passangers_list);
        list_of_lists.Add(economy_premium_passangers_list);
        list_of_lists.Add(cabin_crew_list);
            
        
        

        Scanner s = new Scanner(System.in);
        while (true) 
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("""
                Enter the operation: 
                1: Add a person 
                2: Print all the list 
                3: Delete all the people with the given ID 
                4: Combine all the lists sorted by ID, print and then exit""");
            int choosen;
            try {
                choosen = s.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Input. Please enter 1, 2, 3 or 4 as an integer.");
                s.nextLine();
                continue;
            }
            
            s.nextLine();
            switch (choosen)
            {
                case 1 -> 
                {
                    String type;
                    String name;
                    long ID;
                    try 
                    {
                        System.out.println("Enter the name: ");
                        name = s.nextLine();
                        System.out.println("Enter the ID: ");
                        ID = s.nextLong();
                        System.out.println("Enter the type (passenger or cabin-crew): ");
                        type = s.next();
                        
                    } catch (Exception e) 
                    {
                        System.err.println("ERROR: Invalid input!");
                        s.nextLine();
                        continue;
                    }
                    
                    switch(type)
                    {
                        case "passenger" -> 
                        {
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
                            switch(ticket)
                            {
                                case "economy" -> economy_passangers_list.Add(newPassenger);
                                case "economy-premium" -> economy_premium_passangers_list.Add(newPassenger);
                                case "business" -> business_passangers_list.Add(newPassenger);
                                default -> System.out.println("ERROR: Invalid ticket type.");
                            }
                        }
                        case "cabin-crew" ->
                        {
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
                        }
                    }
                }

                case 2 -> 
                {                
                    list_of_lists.DisplayList();
                }
                case 3 ->
                {
                    System.out.println("Enter the ID to delete:");
                    long id = s.nextInt();
                    list_of_lists.RemoveByID(id);
                }
                case 4 ->
                {
                    
                    s.close();
                }

            }
        }
        

        
    }    
}
