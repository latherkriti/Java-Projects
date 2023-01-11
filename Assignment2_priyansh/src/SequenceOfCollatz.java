import javax.swing.plaf.IconUIResource;
import java.util.*;
public class SequenceOfCollatz {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /**
         * Arraylist for storing integer inputs
         */
        ArrayList<Integer> INTEGERLIST = new ArrayList<Integer>();
        System.out.print("Enter a positive integer: ");
        long n ;
        n=scanner.nextLong();
        /**
         * adding inputs to arraylist
         */
        while (n!=0){

            INTEGERLIST.add((int) n);
            n=scanner.nextLong();
        }
        /**
         * starting calculating time for algorithm to run
         */
        long startTime = System.currentTimeMillis();
        for(int i=0; i< INTEGERLIST.size();i++){
            int maximum = 0;
            long startNumber =0;
            long k = INTEGERLIST.get(i);
            /**
             * condition of operations of number
             */
            for (long j=k; j>0; j--){
                int count=0;
                long k1 = j;
                while (k1>1){
                    if(k1%2==0){
                        k1=k1/2;
                    }else{k1 = k1*3+1;}
                    count++;
                }
                count++;
                if(count>maximum){
                    maximum=count;
                    startNumber=j;
                }
            }
            /**
             * ending the time constraint
             * finding the total time
             * and getting outputs
             */
            long endTime=System.currentTimeMillis();
            long totalTime=endTime-startTime;
            System.out.println(INTEGERLIST.get(i)+" "+startNumber+" "+maximum+" "+totalTime);

        }
    }
}
