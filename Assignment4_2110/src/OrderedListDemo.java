import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OrderedListDemo {
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1,
                                                                 OrderedList<T> list2){
        /**
         * len1 is length of list1 and len2 is length of list2
         */

        int len1=list1.size();
        int len2 = list2.size();
        /**
         * merged is used to store merged list
         */
        OrderedList<T> merged = new OrderedList<>();
        int index1=0;
        int index2=0;
        /**
         * condition when the first index is less than the length of list1
         * and is also less than the length of list2
         */
        while(index1<len1 && index2<len2) {
            if(list1.get(index1).compareTo(list2.get(index2))<0) {
                merged.add(list1.get(index1));
                index1++;
            }
            else { if(list1.get(index1).compareTo(list2.get(index2))==0) {
                merged.add(list2.get(index2));
                index1++;
                index2++;
            }
            else {
                merged.add(list2.get(index2));
                index2++;
            }


            }
        }

        while(index1<len1) {
            merged.add(list1.get(index1++));
        }
        while(index2<len2) {
            merged.add(list2.get(index2++));
        }

        return merged;

    }
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T>
                                                                              list1, OrderedList<T> list2){
        int len1=list1.size();
        int len2 = list2.size();
        OrderedList<T> difference = new OrderedList<>();
        int index1=0, index2=0;
        while(index1<len1 && index2<len2) {
            if(list1.get(index1).compareTo(list2.get(index2))<0) {
                difference.add(list1.get(index1));
                index1++;
            }
            else { if(list1.get(index1).compareTo(list2.get(index2))==0) index1++;
                /**
                 * merged.add(list2.get(index2));
                 */
                index2++;

            }
        }


        while(index1<len1) {
            difference.add(list1.get(index1++));
        }


        return difference;



    }
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T>
                                                                          list1, OrderedList<T> list2){
        /**
         * defining the lengths of both the lists
         */
        int len1=list1.size();
        int len2 = list2.size();
        OrderedList<T> common = new OrderedList<>();
        /**
         * settting the index at 0
         */
        int index1=0, index2=0;
        /**
         * conditions to compare both the lists
         * moving the cursor to the next index
         */
        while(index1<len1 && index2<len2) {
            if(list1.get(index1).compareTo(list2.get(index2))<0) {

                index1++;
            }
            else { if(list1.get(index1).compareTo(list2.get(index2))==0) {
                common.add(list1.get(index1));
                index1++;
                index2++;
            }
            else {
                index2++;

            }
            }
        }



        return common;



    }

    public static void main(String[] args) throws FileNotFoundException{
        /**
         * defining two lists
         */
        OrderedList<String> list1 = new OrderedList<>();
        OrderedList<String> list2 = new OrderedList<>();
        /**
         * creating scanner keyboard
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter First filename to read from: ");
        /**
         * scanning the input files
         */
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        String item=null;
        while(inputFile.hasNext())
        {
            StringTokenizer st = new StringTokenizer(inputFile.nextLine(),"\n");
            item = st.nextToken();
            list1.insert(item);

        }
        inputFile.close();
        /**
         * taking input of the file name
         */
        System.out.print("Enter Second filename to read from: ");
        filename = keyboard.nextLine();
        file = new File(filename);
        inputFile = new Scanner(file);
        item=null;
        while(inputFile.hasNext())
        {
            StringTokenizer st = new StringTokenizer(inputFile.nextLine(),"\n");
            item = st.nextToken();
            list2.insert(item);

        }
        /**
         * closing the file inputs and the scanner
         */
        inputFile.close();
        keyboard.close();

        System.out.println("The merge operations are complete and the results are in merged.txt,\n"
                + "difference.txt and common.txt");
        /**
         * merging the lists
         */
        OrderedList<String> list3 = new OrderedList<>();
        list3 = OrderedListDemo.merge(list1, list2);


        try {

            FileWriter myWriter = new FileWriter("merged.txt");
            for(int i=0;i<list3.size();i++) myWriter.write(list3.get(i)+"\n");
            myWriter.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        /**
         * list1 - list2 --- all elements of list1 which are not in list2
         */
        list3 = OrderedListDemo.difference(list1, list2);

        try {

            FileWriter myWriter = new FileWriter("difference.txt");
            for(int i=0;i<list3.size();i++) myWriter.write(list3.get(i)+"\n");
            myWriter.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        /**
         * finding out the common items in both the lists
         */
        list3 = OrderedListDemo.common(list1, list2);
        try {

            FileWriter myWriter = new FileWriter("common.txt");
            for(int i=0;i<list3.size();i++) myWriter.write(list3.get(i)+"\n");
            myWriter.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
