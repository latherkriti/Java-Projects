import java.util.Scanner;
public class EliminateDuplicate {
    public static int removeDuplicate(int arr[], int n){
        if (n==0||n==1){
            return n;
        }
        int[] temp = new int[n];
        int j=0;
        for(int i=0; i<n-1;i++){
            if(arr[i] != arr[i+1]){
                temp[j++]=arr[i];
            }
        }
        temp[j++]=arr[n-1];
        for(int i=0;i<j;i++){
            arr[i]=temp[i];
        }
        return j;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number of numbers: ");
        int n = input.nextInt();
        double[] numbers=new double[n];

        System.out.print("Enter the numbers: ");
        for (int i=0;i<n;i++){
            numbers[i]= input.nextDouble();
        }
    }
}
