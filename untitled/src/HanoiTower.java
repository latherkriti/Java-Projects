import java.util.Scanner;
public class HanoiTower {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n= input.nextInt();

        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
    }
    public static void moveDisks(int n, char from_rod, char to_rod, char aux_rod){
        if(n==1)
            System.out.println("Move disk "+n+" from "+ from_rod+" to "+ to_rod);
        else {
            moveDisks(n-1 , aux_rod, to_rod, from_rod);
            System.out.println("Move disk "+n+" from "+ from_rod+" to "+ to_rod);
        }
    }
}
