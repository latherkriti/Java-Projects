import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
    /** pred is a static method to compute the number of predecessors
    /* of a node in the graph, using adjacency matrix x , number of nodes V and node i
     */
    public static int numPred(int[][] x,int V, int node) {
        int temp=0;
        for(int i=0;i<V;i++) temp+=x[i][node];
        return temp;
    }

    /**
     * printSorted prints the result queue in given format
     *  1 2 3 4 5 6
     *  sorted graph nodes
      */

    public static void printSorted(Queue<Integer> mqueue) {
        int size = mqueue.size();
        System.out.println();
        System.out.println("-------------------------------------------"+"\n"+"Sorted Node Sequence");
        for(int i=1;i<=size;i++) System.out.print(i+"\t");
        System.out.println();
        for(int i=1;i<=size;i++) {
            int y = mqueue.poll()+65;
            char x = (char) y;
            System.out.print(x+"\t");
        }
    }

    public static void main(String[] args) {
        Scanner keyscanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices in graph");
        int V = keyscanner.nextInt();
        System.out.println("Enter the number of edges in graph");
        int E = keyscanner.nextInt();
        System.out.println("Enter Edge data "+E+"lines, in format From Node -->  To Node");

        char[] chars = new char[V];
        for(int i=0;i<V;i++) chars[i]=(char)(i+65);
        int[][] adjmatrix = new int[V][V];
        for(int i=0;i<V;i++) {
            for(int j=0;j<V;j++){ adjmatrix[i][j]=0; }}

        /**
         * create adjacency matrix from input edge data
          */

        for(int i=0;i<E;i++) {

            char x = keyscanner.next().charAt(0);
            char y = keyscanner.next().charAt(0);

            int v0 = x-65;
            int v1 = y-65;
            adjmatrix[v0][v1]=1;
        }
        /**
         * printing the adjacency matrix in given format
         */

        System.out.print("  ");
        for(int j=0;j<V;j++) System.out.print(chars[j]+" ");
        int k=0;
        for(int i=0;i<V;i++) {
            System.out.println("");

            System.out.print(chars[k]+" ");
            k++;
            for(int j=0;j<V;j++) {
                System.out.print(adjmatrix[i][j]+" ");
            }
        }
        /**
         * close the input scanner
          */

        keyscanner.close();


        /**
         * TOPOLOGICAL SORTING
         * pred is a vector -- number of predecessors of each node
          */


        int[] pred = new int[V];
        /**
         * calculating pred[] using numPred() method
         */

        for(int i=0;i<V;i++) {
            pred[i]=numPred(adjmatrix,V,i);
        }
        /**
         * myq is intermediate queue which adds and removes node as per pred
         */
        Queue<Integer> myq = new LinkedList<>();
        /**
         * result contains final sorted node sequence
          */

        Queue<Integer> result = new LinkedList<>();
        /**
         *  Add node with zero predecessors into the myq
         */

        for(int i=0;i<V;i++) {

            if(pred[i]==0) myq.add(i);
        }

        int topnum=1;

        /**
         * iterating till myq is not empty
         */
        while(!myq.isEmpty()) {
            /**
             * poll() a node from myq and add to result queue
             */
            int w = myq.poll();
            result.add(w);

            /**
             * add neighbors of w into myq, reduce their num of predecessors by 1
             * if pred[i]==0 then add that node to myq and repeat
              */


            for(int i=0;i<V;i++) {

                if (adjmatrix[w][i]==1) {
                    pred[i]=pred[i]-1;
                    if(pred[i]==0) myq.add(i);
                }

            }
            topnum++;
        }
        printSorted(result);
    }

}
