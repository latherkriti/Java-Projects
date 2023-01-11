import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * main class
 */
public class SimpleHashMap {

    public static void main(String[] args) throws FileNotFoundException{


        /**
         * hashmap to store <username, fullname>
         * </username,>
         */
        HashMap<String, String> userPassMap = new HashMap<String, String>();


        HashMap<String, String> userFullMap = new HashMap<String, String>();

        Scanner keyscanner = new Scanner(System.in);

        System.out.print("Enter the input filename: ");
        /**
         * requesting filename from user
         */
        String infname = keyscanner.next();
        File myfileObj = new File(infname);

        Scanner inputFile = new Scanner(myfileObj);


        /**
         * reading from file and storing in corresponding hash map
         */
        while(inputFile.hasNextLine())

        {
            String fullname="";
            String[] line = inputFile.nextLine().split(" ");
            int size_line = line.length;
            for(int i=0;i<size_line-2;i++)
                fullname+=line[i]+" ";


            String uname = line[size_line-2];

            String password = line[size_line-1];



            userPassMap.put(uname, password);

            userFullMap.put(uname, fullname);

        }
        /**
         * when user does not exceed 3 incorrect attempts
         */
        inputFile.close();
        int maxtries = 3;
        int tries=1;
        String uname=null;
        String password=null;


        /**
         * requesting user name and password
         */
        while(tries <= maxtries)

        {

            System.out.print("Login: ");

            uname = keyscanner.next();

            System.out.print("Password: ");
            /**
             * verifying password
             */
            password = keyscanner.next();

            String foundPassword = userPassMap.get(uname);
            /**
             * if password and username matches print fullname
             */
            if(foundPassword != null && foundPassword.equals(password))

            { System.out.println("Login successful\n"
                    + "Welcome "+ userFullMap.get(uname));


                break;

            }

            else

            {
                if(tries==3) System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                else
                    System.out.println("Either username or password is incorrect. You have "+(maxtries-tries)+" more attempts\n");
                tries++;

            }

        }

        /**
         * close the scanner
         */
        keyscanner.close();
    }

}



