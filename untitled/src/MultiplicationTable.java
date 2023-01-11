public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Multiplication Table\n");
        int i=1;
        do {
            int j = 1;
            do{
                System.out.print(i*j +"\t");
                j++;
            }
            while(j<=10);
            i++;
            System.out.println();
        }
        while(i<=10);
    }
}
