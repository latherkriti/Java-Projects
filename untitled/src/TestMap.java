import java.util.*;
public class TestMap {
    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Kriti", 18);
        hashMap.put("Saumya", 18);
        hashMap.put("Lewis", 20);
        hashMap.put("Cook", 20);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);


        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

        linkedHashMap.put("Kriti", 18);
        linkedHashMap.put("Saumya", 18);
        linkedHashMap.put("Lewis", 20);
        linkedHashMap.put("Cook", 20);

        System.out.println("\nThe age for "+"Lewis is "+linkedHashMap.get("Lewis"));

        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

        System.out.print("\nNames and ages are ");
        treeMap.forEach((name, age) -> System.out.print(name + ": "+age+" "));

    }
}
