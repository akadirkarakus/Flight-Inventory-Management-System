import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Cabin_Crew dare = new Cabin_Crew("hostes", 20);
        Cabin_Crew veli = new Cabin_Crew("pilot", 10);
        Cabin_Crew kazım = new Cabin_Crew("aslan", 30);
        
        Node<Cabin_Crew> nodeVeli = new Node<>(veli);
        Node<Cabin_Crew> nodeDare = new Node<>(dare);
        Node<Cabin_Crew> nodeKazım = new Node<>(kazım);

        SLinkedList<Cabin_Crew> kabin2 = new SLinkedList<>();
        kabin2.AddItem(nodeVeli);
        kabin2.AddItem(nodeDare);
        kabin2.AddItem(nodeKazım);

        System.out.println(kabin2.toString());



        /* 
        Passenger ali = new Passenger("sdds", 3);
        Node<Passenger> nodeAli = new Node<>(ali);
        SLinkedList<Passenger> economy_list = new SLinkedList();
        economy_list.AddItem(nodeAli);

        Cabin_Crew veli = new Cabin_Crew("pilot", 3234);
        Node<Cabin_Crew> nodeVeli = new Node<>(veli);
        SLinkedList<Cabin_Crew> kabin = new SLinkedList<>();
        kabin.AddItem(nodeVeli);

        Cabin_Crew dare = new Cabin_Crew("hostes", 3234);
        Node<Cabin_Crew> nodeDare = new Node<>(dare);
        kabin.AddItem(nodeDare);
        */


        /* 
        Passenger ayse = new Passenger("myticket",10);
        Node<Passenger> n1 = new Node<>(ayse);
        DLinkedList<Passenger> business_list = new DLinkedList<>();
        business_list.AddItem(n1);
        */
    }








    private static int NewOperation() 
    {
        /* This method is creates 'Enter the Operation' screen.
           It returns the value that user chose. */
        
        System.out.println("""
                Enter the operation: 
                1: Add a person 
                2: Print all the list 
                3: Delete all the people with the given ID 
                4: Combine all the lists sorted by ID, print and then exit""");
            
        Scanner s = new Scanner(System.in);
        int choosen = s.nextInt();
        s.close();
        return choosen;
    }
}
