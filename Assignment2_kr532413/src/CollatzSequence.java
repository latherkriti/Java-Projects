import java.util.Scanner;
import java.util.*;
import  java.lang.Integer;

/**
 * imported java libraries
 * initializing the scannner
 */
public class CollatzSequence {
    public static void main(String[] args) {
        long n ;
        Scanner kriti = new Scanner(System.in);
        /**
         * Creating arraylist
         * to store integer inputs from the user
         */
        ArrayList<Integer> LIST = new ArrayList<Integer>();
        System.out.print("Enter a positive integer: ");
        /**
         * taking inputs from scanner until the user enters the number zero "0"
         * adding elements to LIST arraylist
         */
        do{
            n = kriti.nextLong();
            LIST.add((int) n);
        }
        while(n!=0);
        /**
         * starting the time for calculating time complexity
         */
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LIST.size(); i++) {
            int max =0;
            long startNum = 0;
            /**
             * getting the elements of the list
             */
            long k = LIST.get(i);

            for(long j = k; j > 0;j--){
                int count = 0 ;
                long k2 = j;
                /**
                 * while loop with the if else statements
                 */

                while (k2 > 1){

                    if (k2 % 2 == 0) {
                        k2 = k2/ 2;


                    } else {
                        k2 = k2 * 3 + 1;

                    }
                    count++;
                }
                count++;

                if(count>max){
                    max = count;
                    startNum =j;
                }


                /**
                 * ending the time of the algorithm
                 * calculating total time taken by the program
                 */

            }
            long endTime=System.currentTimeMillis();
            long totalTime=endTime-startTime;
            /**
             * printing the outputs
             */
            System.out.println(LIST.get(i)+" "+ startNum +" "+ max + " "+totalTime+"ms");


        }

    }
}