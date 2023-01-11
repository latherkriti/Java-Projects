import java.util.Scanner;
import java.util.*;
import  java.lang.Integer;

/**
 * imported java libraries
 */
public class CousinOfCollatz {
    public static void main(String[] args) {
        long n ;
        Scanner kriti = new Scanner(System.in);
        /**
         * Whole program is as same as CollatzSequence
         * apart from the if-else conditions
         * that too for when k1%2 != 0;
         */
        ArrayList<Integer> LIST = new ArrayList<Integer>();
        System.out.print("Enter a positive integer: ");

        do{
            n = kriti.nextLong();
            LIST.add((int) n);
        }
        while(n!=0);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LIST.size(); i++) {
            int max =0;
            long startNum = 0;

            long k = LIST.get(i);

            for(long j = k; j > 0;j--){
                int count = 0 ;
                long k2 = j;

                while (k2 > 1){

                    if (k2 % 2 == 0) {
                        k2 = k2/ 2;


                    } else {
                        if(k2%4 == 1){
                            k2 = k2*7 +1;
                        }
                        if(k2%4==3){
                            k2 = k2*7-1;
                        }

                    }
                    count++;
                }
                count++;

                if(count>max){
                    max = count;
                    startNum =j;
                }



            }
            long endTime=System.currentTimeMillis();
            long totalTime=endTime-startTime;
            System.out.println(LIST.get(i)+" "+ startNum +" "+ max + " "+totalTime+"ms");


        }

    }
}