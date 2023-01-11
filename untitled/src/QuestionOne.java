import java.util.*;
public class QuestionOne {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter student's name");
        String name = input.nextLine();

        String BNum = "B00900900";


        int tests = 80;


        int PODs = 90;


        int Assignments = 70;


        int Practicums = 40;


        int Labs = 50;

        double result = 0.28*tests + 0.28*Assignments + 0.24*Practicums + 0.105*Labs + 0.1*PODs;
        Formatter fmt = new Formatter();
        fmt.format("%.2f",result);
        System.out.println("Hi "+name+" ("+BNum+"), "+"based on input given: "+"Tests= "+tests+"%"+" PoDs= "+PODs+"%,"+ " Assignments= "+Assignments+"%, "+ "Practicums="+Practicums+"%, "+ "Labs="+Labs+"%, "+"your final score is "+fmt+"%.");

    }

}
