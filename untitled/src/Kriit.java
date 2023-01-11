import java.util.ArrayList;

public class Kriit {
    public static void main(String[] args) {
        ArrayList<Integer> kr = new ArrayList<>();
        ArrayList<Integer> kr2 = new ArrayList<>();
        ArrayList<Integer> kr3 = new ArrayList<>();
        kr.add(4);
        kr.add(5);
        kr.add(0,19);
        System.out.println(kr.contains(17));
        System.out.println(kr.get(2));
        System.out.println(kr);
        System.out.println(kr.get(0));
        kr2.addAll(kr);
        System.out.println(kr2.indexOf(4));
        System.out.println(kr2);
        System.out.println(kr2.equals(kr));
        kr2.clear();
        System.out.println(kr2);



    }
}
