/**
 * Importing java libraries
 */

import java.util.Scanner;
import java.util.*;
public class Prime {
    /**
     * Scanner to scan the inputs in the array
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner kr_input = new Scanner(System.in);
        int num_array[] = new int[10];
        int count = 0;
        /**
         * Infinite looping
         * by passing the condition true
         */
        while (true) {
            int i = kr_input.nextInt();
            if (i == 0 || count > 9)
                break;
            num_array[count] = i;
            count++;
            /**
             * Time Complexity
             */
            for(i = 0;i<count;i++)

            {
                long timebefore = System.currentTimeMillis();
                long prime = nthPrime(num_array[i]);
                long timeafter = System.currentTimeMillis();

                System.out.println(num_array[i] + " " + prime + " " + (timeafter - timebefore));
            }

        }


    }

    /**
     * Finding the nth prime number
     * @param n
     * @return
     */
    public static long nthPrime(long n) {
        long number, count, i;
        number = 1;
        count = 0;
        /**
         * while loop for finding prime number
         */
        while (count < n) {
            number = number + 1;
            for (i = 2; i <= number; i++) {
                if (number % i == 0) {
                    break;
                }
            }
            if (i == number) {
                count = count + 1;
            }
        }
        return number;
    }

}

