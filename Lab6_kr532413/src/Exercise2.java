import java.util.ArrayList;
import java.util.Scanner;



public class Exercise2 {
    public static void main(String[] args) {
        /**
         * create empty string str - it will store the read string
         */
        String str = new String("");
        Scanner keyboard = new Scanner(System.in);
        /**
         * ArrayList of BinaryTree<String> objects to hold the binary tree
         */

        ArrayList<BinaryTree<String>> abt = new ArrayList<BinaryTree<String>>();
        /**
         * repeat while loop till done is entered
         * repeat till user types "done"
         */
        while(str.compareTo("done")!=0) {
            System.out.print("Enter name or done:");
            str=keyboard.next();
            if(str.compareTo("done")==0) break;

            /**
             * make a BinaryTree<T> node from the read string token and make it root
             */

            BinaryTree<String> bt = new BinaryTree<String>();
            bt.makeRoot(str);

            /**
             * add this BinaryTree<T> node to the Arraylist<BinaryTree<T>> abt
             */

            abt.add(bt);
        }
        /**
         * closing input scanner
         */
        keyboard.close();
        /**
         * Form a  tree from Arraylist - Oth entry has 1st and 2nd as children
         * for every i th entry, entries at 2i+1 and 2*i+2 are its child
         */
        for(int i=0;i<abt.size();i++) {
            if((2*i+1)<abt.size()) {

                abt.get(i).attachLeft(abt.get(2*i+1));
                if((2*i+2)<abt.size())abt.get(i).attachRight(abt.get(2*i+2));


            }

        }

        BinaryTree<String> A = abt.get(0);


        /**
         * test statements
         */
        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(A));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(A));

        System.out.println();

        System.out.print("Inorder:\t\t");
        BinaryTree.inorder(A);
        System.out.println();

        System.out.print("Preorder:\t\t");
        BinaryTree.preorder(A);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(A);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(A);
        System.out.println();
        System.out.println();



        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(A));
        System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(A) ? "Yes!" : "No.");

        System.out.println();

    }

}
