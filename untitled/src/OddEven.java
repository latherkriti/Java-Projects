import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int integer = input.nextInt();

        if (integer % 2==0) {
            System.out.println(integer+" is an even number.");}
        else
            System.out.println(integer+" is an odd number.");

    }
}
