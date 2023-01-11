package com.kriti;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class NHLListDemo {
    /**
     * Scanner keyboard scans the name of text file
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();


        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        NHLStats nhlstats = new NHLStats();
        /**
         * Instance Variables
         */
        String playername, position,team;
        int games_played,goals_secured,assists,penalty_min,shot_goal,gwgoals;
        PlayerRecord prec=null;
        String newline = null;
        /**
         * Applying while loop on tokenizer to scan integers
         */
        while(inputFile.hasNext())
        {
            StringTokenizer st = new StringTokenizer(inputFile.nextLine(),"\t");
            playername=st.nextToken();
            position=st.nextToken();
            team=st.nextToken();
            games_played=Integer.parseInt(st.nextToken());
            goals_secured=Integer.parseInt(st.nextToken());
            assists=Integer.parseInt(st.nextToken());
            penalty_min=Integer.parseInt(st.nextToken());
            shot_goal=Integer.parseInt(st.nextToken());
            gwgoals=Integer.parseInt(st.nextToken());
            prec=new PlayerRecord(playername, position,team,games_played,goals_secured,assists,penalty_min,shot_goal,gwgoals);
            nhlstats.add(prec);

        }
        /**
         * Closing the scanner
         */
        inputFile.close();
        keyboard.close();
        /**
         * Printing outputs
         */
        System.out.println("Players with highest points and their teams:\n");
        nhlstats.maxGoalsAssists();
        System.out.println("Most aggressive players, their teams and their positions:\n");
        nhlstats.mostAggressive();
        System.out.println("Most valuable players and their teams:\n");
        nhlstats.maxGameWinning();
        System.out.println("Most promising players and their teams:\n");
        nhlstats.maxShotsGoals();
        System.out.println("Teams that had the most number of penalty minutes:\n");
        nhlstats.maxTeamPenaltyMinutes();
        System.out.println("\nTeams that had the most number of game winning goals:\n");
        nhlstats.maxTeamWinningGoal();
    }
}

