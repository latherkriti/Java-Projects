import java.io.File;

import java.io.IOException;

import java.util.HashMap;

import java.util.Scanner;



public class HashMapDemo

{

    public static void main(String[] args) throws IOException

    {



        HashMap<String, String> usernamePasswordMap = new HashMap<String, String>();

        HashMap<String, String> usernameFullnameMap = new HashMap<String, String>();

        Scanner console = new Scanner(System.in);

        System.out.print("Enter the input filename: ");

        String inputFilename = console.nextLine();

        Scanner inputFile = new Scanner(new File(inputFilename));



        while(inputFile.hasNextLine())

        {

`            String[] line = inputFile.nextLine().split("\t");

            String fullname = line[0];

            String username = line[1];

            String password = line[2];



            usernamePasswordMap.put(username, password);

            usernameFullnameMap.put(username, fullname);

        }





        while(tries < MAX_TRIES)

        {

            System.out.print("Login: ");

            username = console.nextLine();

            System.out.print("Password: ");

            password = console.nextLine();

            tries++;

            String foundPassword = usernamePasswordMap.get(username);

            if(foundPassword != null && foundPassword.equals(password))

            {

                success = true;

                break;

            }

            else

            {

                System.out.printf("Either username or password is incorrect. You have %d attempts\n", MAX_TRIES-tries);

            }

        }

       // write if else for printing

    }

}

