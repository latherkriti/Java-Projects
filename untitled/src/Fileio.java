import java.io.*;
import java.util.*;
public class Fileio
{
    public static void main(String[] args) throws FileNotFoundException{
        File myfile = new File("./src/hello.txt");
        Scanner sc = new Scanner(myfile);
        int i=0;
        while(sc.hasNext()) {i=Integer.parseInt(sc.next());
        System.out.println(i);}
        String hell ="234";
        System.out.println(myfile.getAbsolutePath());
        System.out.println(2*Double.parseDouble(hell));

    }
}