import java.util.*;

public class Binary {

    /**
     * Scanner to scan number, range and time
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");

        int num = scan.nextInt();
        int range = (int) (Math.pow(2, num) - 1);

        long start = System.currentTimeMillis();
        Binary.genBinary(num);
        long end = System.currentTimeMillis();
        /**
         * printing the value of the time generated
         */
        System.out.println("The execution time to generate binary numbers from 0 to " + range + "is: " + (float) (end - start) + "ms");
    }

    /**
     * Generating
     *
     * @param number
     */
    public static void genBinary(int number) {
        for (int i = 0; i < (Math.pow(2, number)); i++) {
            String s = Integer.toBinaryString(i);
        }
    }
}
