//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO EXERCISE 1
import java.util.ArrayList;
import java.util.Scanner;
public class HashTableExperiment
{
    public static void printStatistics(ArrayList<LinkedList<Integer>> hashtable)
    {	//numcoll for number of collisions
        int numcoll=0;
        // longest for length of max bucket
        int longest=0;
        // for any bucket collisions = size-1
        // longest = size of largest bucket
        for(int i=0;i<hashtable.size();i++) {
            if (hashtable.get(i).size()>1) numcoll+=hashtable.get(i).size()-1;
            if (hashtable.get(i).size()>longest) longest=hashtable.get(i).size();

        }
        System.out.println("Number of collisions: "+numcoll);
        System.out.println("Longest List: "+longest);

    }
    public static void main(String[] args)
    {
        //prompt the user to enter the table size
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the hash table size: ");
        int n = keyboard.nextInt();
        System.out.println("Enter number of keys: ");
        int m = keyboard.nextInt();

        //create an Arraylist of size n
        //The ArrayList holds a LinkedList object
        //The LinkedList consists of nodes that hold integer objects
        ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
        for (int i=0; i<n; i++)
        {
            hashtable.add(i, new LinkedList<Integer>());
        }
        //Display the arraylist of linked lists
//		System.out.println("Empty lists");
//		for (int i=0; i<n; i++)
//		{
//			System.out.print(i + ": ");
//			hashtable.get(i).enumerate();
//		}
//
        for(int i=0;i<m;i++) {
            int key= (int)(10000*Math.random());
            hashtable.get(key%n).add(key);

        }
        System.out.println();
        System.out.println("Hashtable Created:");
        // print the hashtable if keys < 100
        if(m<100) {
            for (int i=0; i<n; i++)
            {
                System.out.print(i + ": ");
                hashtable.get(i).enumerate();
            }
        }
        System.out.println("\n\nStatistics:");
        System.out.println("Table size: "+n);
        System.out.println("Number of keys: "+m);
        System.out.println("Load factor: "+((double)(n)/(double)(m)));

        printStatistics(hashtable);

        //Add keys 187, 105, 120, 205, 189 to the appropriate linked list
        //187 will be added to the linked list at index 187%n
        //105 will be added to the linked  at index 105%n
        //etc.
//		int index = 187%n;
//		hashtable.get(index).add(187);
//		index = 105%n;
//		hashtable.get(index).add(105);
//		index = 120%n;
//		hashtable.get(index).add(120);
//		index = 205%n;
//		hashtable.get(index).add(205);
//		index = 189%n;
//		hashtable.get(index).add(189);

        //Display the arraylist of linked lists



    }
}


