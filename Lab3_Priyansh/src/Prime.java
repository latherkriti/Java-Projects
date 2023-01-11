import java.util.*;
public class Prime {
    /**
     * Method to find nth prime number
     * @param
     * @return
     */


    public static void main(String[] args) {
        Scanner priyansh = new Scanner(System.in);
        int p_array[] = new int[10];
        int count = 0;

        while (true){
            int i=priyansh.nextInt();
            if(i==0||count>9)
                break;
            p_array[count]=i;
            count++;

            for (i=0;i<count;i++){
                /**
                 * code snippet for calculating time was given already
                 */
                long timebefore = System.currentTimeMillis();
                long prime = nthPrime(p_array[i]);
                long timeafter = System.currentTimeMillis();

                /**
                 * Printing the output
                 */
                System.out.println(p_array[i] + " " + prime + " " + (timeafter - timebefore));
            }
        }
    }
    public static long nthPrime(long n){
        long num,count,i;
        num=1;
        count=0;
        while(count<n){
            num=+1;
            for(i=2;i<=num;i++){
                if(num%i==0){
                    break;
                }
            }
            if(i==num){
                count+=1;
            }
        }
        return num;
    }
}
