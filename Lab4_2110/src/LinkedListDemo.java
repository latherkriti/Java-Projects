import java.util.*;
import java.util.Scanner;
public class LinkedListDemo{
    public static void main(String[] args){
        /**
         * Making Scanner and including linked lists
         */
        Scanner kriti = new Scanner(System.in);
        LinkedList<String> pokemonList = new LinkedList<>();

        /**
         * taking inputs from the user
         */
        System.out.println("Enter Pokemon names, one on each line");
        System.out.println("Enter quit to end");
        String pokemon = kriti.next();

        /**
         * while condition ends when user enters "quit"
         */
        while(!pokemon.equals("quit")){
            pokemonList.add(pokemon);
            pokemon = kriti.next();
        }
        /**
         * print the linked list
         */
        System.out.println("Here is the linked list: ");
        pokemonList.enumerate();
        System.out.println(" ");

        /**
         * printing the even nodes from the linked list
         */
        System.out.println("Here is the linked list with even-numbered nodes:");
        displayEven(pokemonList);
        System.out.println(" ");

        /**
         * printing the odd nodes from the linked list
         */
        System.out.println("Here is the linked list with odd-numbered nodes:");
        displayOdd(pokemonList);
        System.out.println(" ");


        LinkedList<String> reversePokemon = reverse(pokemonList);

        /**
         * printing the reversed linked list
         */
        System.out.println("Here is the reversed linked list: ");
        reversePokemon.enumerate();
        System.out.println(" ");

        /**
         * removing the middle nodes from the list
         */
        removeMiddle(pokemonList);
        pokemonList.enumerate();




    }

    /**
     * method to print the even numbered nodes
     * @param pokemon
     */
    public static void displayEven(LinkedList<String> pokemon){

        for (int i = 0; i < pokemon.size(); i+=2) {

            System.out.print(pokemon.getAt(i) + "   ");

        }

    }

    /**
     * method to print the odd numbered nodes
     * @param pokemon
     */
    public static void displayOdd(LinkedList<String> pokemon){

        for (int i = 1; i < pokemon.size() ; i+=2) {
            System.out.print(pokemon.getAt(i) + "   ");
        }

    }

    /**
     * method to build a reversed linked list
     * @param pokemon
     * @return
     */
    public static LinkedList<String> reverse(LinkedList<String> pokemon){


        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < pokemon.size() ; i++) {
            list2.add(pokemon.getAt(i));

        }
        return list2;
    }

    /**
     * method to remove the middle nodes
     * @param pokemon
     */
    public static void removeMiddle(LinkedList<String> pokemon){

        for (int i = 0; i < pokemon.size() ; i++) {
            int remove = pokemon.size()/2;
            if( i == remove){
                pokemon.removeAt(i);
            }
        }

    }
}