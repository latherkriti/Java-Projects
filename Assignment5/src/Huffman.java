import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Huffman {

    public static void main(String[] args) throws FileNotFoundException{
        char value;
        double prob;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a line of text (uppercase letters only):");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        ArrayList<Pair> data = new ArrayList<>();
        while(inputFile.hasNext())
        {
            value = inputFile.next().charAt(0);
            prob = inputFile.nextDouble();
            Pair p = new Pair(value,prob);
            data.add(p);
        }
        inputFile.close();

        /* Sort read data in ascending order
         *
         */
        Collections.sort(data);
        /* S is Queue of BinaryTree<Pair> element type
         *  BinaryTree for each each element in data
         *  is added to S
         */
        Queue<BinaryTree<Pair>> S = new LinkedList<>();
        for(Pair p : data) {
            BinaryTree<Pair> bt = new BinaryTree<>();
            bt.makeRoot(p);
            bt.setLeft(null);
            bt.setRight(null);
            // System.out.println(p.getValue());
            S.add(bt);
        }

        BinaryTree<Pair> btr = createHuffmanTree(S);
        String[] codes = new String[26];
        codes = findEncoding(btr);
        //Scanner kb = new Scanner(System.in);
        System.out.println("Please enter a string to encode");
        String input = keyboard.nextLine();
        String output = encode(input,codes);
        System.out.println("Here’s the encoded line:"+ output);
        String decoded = decode(output,btr);
        System.out.println("The decoded line is: "+decoded);


    }
    public static BinaryTree<Pair> createHuffmanTree(Queue<BinaryTree<Pair>> S) {
        /* T is an additional Queue to hold root node of Huffman tree
         * T has one node i.e. root node
         */
        Queue<BinaryTree<Pair>> T = new LinkedList<>();
        while(!S.isEmpty()) {
            // peek two values from S snode1 and snode2 and poll only one
            BinaryTree<Pair> snode1 = S.peek();
            S.poll();
            BinaryTree<Pair> snode2 = S.peek();
            /* In starting T is empty,create new node,so two nodes snode1, snode2 will be its child
             * new node is added to empty T
             */
            if(T.isEmpty()) {
                BinaryTree<Pair> newnode1 = new BinaryTree<>();
                Pair pair = new Pair('\0',snode1.getData().getProb()+snode2.getData().getProb());
                newnode1.setData(pair);
                newnode1.setLeft(snode2);
                newnode1.setRight(snode1);
                T.add(newnode1);
                S.poll();

            }
            else
                /* if T is not empty then take smallest two  from snode1, snode2 and tnode
                 * if tnode prob is smaller than any one snode1
                 * form a new node with snode1 and tnode node, poll() T node and Add new node to T
                 */

            {
                BinaryTree<Pair> tnode = T.peek();
                if(snode1.getData().getProb()>tnode.getData().getProb()) {
                    BinaryTree<Pair> newnode1 = new BinaryTree<>();
                    Pair pair = new Pair('\0',snode1.getData().getProb()+tnode.getData().getProb());
                    newnode1.setData(pair);
                    newnode1.setLeft(snode1);

                    snode1.setParent(newnode1);
                    newnode1.setRight(tnode);

                    tnode.setParent(newnode1);
                    T.poll();
                    T.add(newnode1);

                }
                else
                    /* if only one node left in S, creating new node, left as snode1 and right
                     * as tnode
                     */
                {
                    if(snode2==null) {
                        BinaryTree<Pair> newnode1 = new BinaryTree<>();
                        Pair pair = new Pair('\0',snode1.getData().getProb()+tnode.getData().getProb());
                        newnode1.setData(pair);
                        newnode1.setLeft(snode1);
                        newnode1.setRight(tnode);
                        T.poll();
                        T.add(newnode1);

                    }
                    else
                        /* if S1<=T , then create a new node newnode1 with snode1, snode2
                         * as left right child, create another node newnode2 with newnode1
                         * and tnode as left and right children, poll() T and add() to T
                         */
                    {
                        BinaryTree<Pair> newnode1 = new BinaryTree<>();
                        Pair pair1 = new Pair('\0',snode1.getData().getProb()+snode2.getData().getProb());
                        newnode1.setData(pair1);


                        newnode1.setLeft(snode1); snode1.setParent(newnode1);
                        newnode1.setRight(snode2); snode2.setParent(newnode1);

                        BinaryTree<Pair> newnode2 = new BinaryTree<>();
                        Pair pair2 = new Pair('\0',newnode1.getData().getProb()+tnode.getData().getProb());
                        newnode2.setData(pair2);
                        newnode2.setLeft(newnode1); newnode1.setParent(newnode2);
                        newnode2.setRight(tnode); newnode2.setParent(newnode2);
                        T.poll();

                        S.poll();
                        T.add(newnode2);
                    }

                }
            }


        }

        return T.poll();

    }
    private static String[] findEncoding(BinaryTree<Pair> bt){
        String[] result = new String[26];
        findEncoding(bt, result, "");
        return result;
    }
    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){
        // test is node/tree is a leaf
        if (bt.getLeft()==null && bt.getRight()==null){
            a[bt.getData().getValue() - 65] = prefix;
        }
        // recursive calls
        else{
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1");
        }
    }
    public static String encode(String a, String[] codes) {
        // coded is a empty string to hold huffman coded string
        String coded = "";
        char[] charray = new char[a.length()];
        /* for each character in the input string, insert into decoded its huffman code
         * for empty space in input string, space is inserted into coded string
         */
        for (int i = 0; i < a.length(); i++) {
            charray[i] = a.charAt(i);
            if(charray[i]==' ') coded+=" ";
            else
                coded+=codes[a.charAt(i)-65];
        }
        return coded;
    }

    public static String decode(String a, BinaryTree<Pair> bt)
    { 	// decoded is an empty string decoded
        String decoded = "";
        char[] coded = new char[a.length()];
        /*
         * convert argument string 'a' into char array coded[]
         */
        for(int i=0;i<a.length();i++) coded[i]=a.charAt(i);
        int i=0;
        /*
         * copy argument bt into new btin node BinaryTree<Pair> type
         */
        BinaryTree<Pair> btin = new BinaryTree<>();
        btin=bt;
        /* read each char in the coded string, if 0 move left if 1 move right till leaf node comes
         * if leaf node, its value is copied in decoded string
         * if space a space is inserted into encoded string
         */
        while(i<a.length()) {

            if(btin.isLeafNode()==true) { decoded+=btin.getData().getValue(); btin=bt;}
            else {

                if (btin.isLeafNode()!=true) {
                    if(coded[i]=='0') {btin=btin.getLeft(); }
                    else if(coded[i]=='1') {btin=btin.getRight();}
                    else { decoded+=" ";}
                    i++;
                    if(i==a.length()) {decoded+=btin.getData().getValue(); btin=bt;}
                }
            }


        }

        /*
         * returning decoded string
         */
        return decoded;
    }


}

