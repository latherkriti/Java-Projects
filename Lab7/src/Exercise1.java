import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();


        Scanner input = new Scanner(System.in);
        int val =1;
        while (val!=0){
            System.out.print("Enter int or '0': ");
            val = input.nextInt();
            if (val!=0)
                bst.insert(val);
        }
        System.out.println("The max data value in the BST is: " + bst.findMax());

        System.out.println("The min data value in the BST is: " + bst.findMin());

        System.out.println("What key would you like to search for? ");
        val = input.nextInt();
        if(bst.recursiveSearch(val) !=null){
            System.out.println("Found!");
        }
        else{
            System.out.println("Not Found.");
        }


    }

}
