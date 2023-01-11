/**
 * CSCI 1110
 * @author Kriti Lather
 */

import java.util.*;
import java.math.*;


/**
 * The following is the only class of the program and contains all 
 * program code. The program starts running in the main() of this class.
 */

public class PoD {

    /**
     * Main method that runs when the program is started.
     */

    public static void main(String[] args) {

        //Instantiate new scanner to read from the console.
        Scanner in = new Scanner( System.in );

        //Declare & initialize variables
        double priceBeforeTax = in.nextDouble();


        //PLEASE START YOUR WORK HERE
        double Tax = (0.15*priceBeforeTax)*2;
        int finalPrice = (int)Math.ceil(priceBeforeTax+Tax);
        System.out.println(finalPrice);
        //PLEASE END YOUR WORK HERE
        System.out.print("END OF OUTPUT");
    }
}