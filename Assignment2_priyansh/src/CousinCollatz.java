import java.util.*;
public class CousinCollatz {
    /**
     * as same as the SequenceOfCollatz
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        var INTEGERLIST = new ArrayList<Integer>();
        System.out.print("Enter a positive integer: ");
        long n ;
        n=scanner.nextLong();
        while (n!=0){

            INTEGERLIST.add((int) n);
            n=scanner.nextLong();
        }
        long startTime = System.currentTimeMillis();
        /**
         * all conditions are same
         * except when k1%2 != 0
         * we have two different cases here
         */
        for (Integer integer : INTEGERLIST) {
            int maximum = 0;
            long startNumber = 0;
            long k = integer;
            for (long j = k; j > 0; j--) {
                int count = 0;
                long k1 = j;
                while (k1 > 1) {
                    if (k1 % 2 == 0) {
                        k1 = k1 / 2;
                    } else {
                        if(k1%4 == 1){
                            k1 = k1*7 +1;
                        }
                        if(k1%4==3){
                            k1 = k1*7-1;
                        }
                    }
                    count++;
                }
                count++;
                if (count > maximum) {
                    maximum = count;
                    startNumber = j;
                }
                /**
                 * rest is same
                 */
            }
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println(integer + " " + startNumber + " " + maximum + " " + totalTime);

        }
    }
}

