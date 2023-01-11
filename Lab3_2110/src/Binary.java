import java.util.Scanner;
import java.util.*;
public class Binary {
    public static void main(String[] args) {
        /**
         * Making Scanner named kr_input
         */
        Scanner kr_input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        /**
         * Taking input for number
         */
        int number = kr_input.nextInt();
        /**
         * Range is defined as largest value - smallest value
         */
        int range = (int) (Math.pow(2,number)-1);
        /**
         * Calculating time
         */
        long start = System.currentTimeMillis();
        Binary.generateBinary(number);
        long end = System.currentTimeMillis();
        /**
         * Print Function
         */
        System.out.println("The execution time to generate binary numbers from 0 to "+range+"is: "+(float)(end-start)+"ms");
    }

    /**
     * Method to generate a Binary that we used above in main method
     * @param number
     */
    public static void generateBinary(int number){
        for(int i=0;i<(Math.pow(2,number));i++){
            String string = Integer.toBinaryString(i);
        }
    }
}
