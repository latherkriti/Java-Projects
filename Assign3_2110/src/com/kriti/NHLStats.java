package com.kriti;

public class NHLStats {
    /**
     * constructing list for adding players in it
     */
    private List<PlayerRecord> playerrecord;
    public NHLStats() {
        playerrecord = new List<PlayerRecord>();
    }
    public void add(PlayerRecord precord) {
        playerrecord.add(precord);
    }

    /**
     * checking whether the list is empty or not
     * @return
     */
    public boolean isEmpty() {
        return playerrecord.isEmpty();
    }

    /**
     * for what is existing in it, what does it contains
     * @param precord
     * @return
     */
    public boolean contains(PlayerRecord precord) {
        return playerrecord.contains(precord);
    }

    /**
     * giving the first record
     * @return
     */
    public PlayerRecord first() {
        return playerrecord.first();
    }

    /**
     * getting the next record from first one
     * @return
     */
    public PlayerRecord next()
    {
        return playerrecord.next();
    }

    /**
     * data type of constants
     */
    public void enumerate()
    {
        playerrecord.enumerate();
    }

    /**
     * in this method first we run the first method
     * and then apply loop for the other ones
     * to make it iterate over the list
     */
    public void maxGoalsAssists() {
        List<String> mname = new List<String>();
        List<String> mteam = new List<String>();

        int max=0, currmax=0;
        PlayerRecord prec = playerrecord.first();
        /**
         * while loop to run until its not null
         */
        while (prec!=null)
        {
            currmax=prec.getGoals_secured()+prec.getAssists();
            if (currmax>max)
            { max = currmax;
                mname.clear();
                mteam.clear();

                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());


            }
            else if(currmax==max)
            {
                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }

            prec = playerrecord.next();

        }
        /**
         * print method
         */

        for(int i=0;i<mname.size();i++) {
            if(i==0)
                System.out.println(mname.first()+"\t"+mteam.first() +"\n");
            else
                System.out.println(mname.next()+"\t"+mteam.next() +"\n");
        }


    }

    /**
     * making list for most aggresive players
     */
    public void mostAggressive() {
        List<String> mname = new List<String>();
        List<String> mteam = new List<String>();
        int max=0, currmax=0;
        /**
         * intiating the iteration
         */
        PlayerRecord prec = playerrecord.first();

        while (prec!=null)
        {
            currmax=prec.getPenalty_min();
            if (currmax>max)
            { max = currmax;
                mname.clear();
                mteam.clear();

                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }
            else if(currmax==max)
            {
                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }

            prec = playerrecord.next();
        }
        /**
         * printing the names using for loop
         */
        for(int i=0;i<mname.size();i++) {
            if(i==0)
                System.out.println(mname.first()+"\t"+mteam.first() +"\n");
            else
                System.out.println(mname.next()+"\t"+mteam.next() +"\n");
        }

    }

    /**
     * winning the game method
     */
    public void maxGameWinning() {
        List<String> mname = new List<String>();
        List<String> mteam = new List<String>();
        int max=0, currmax=0;
        PlayerRecord prec = playerrecord.first();
        /**
         * while loop for getting the goals
         */
        while (prec!=null)
        {
            currmax=prec.getGwgoals();
            if (currmax>max)
            { max = currmax;
                mname.clear();
                mteam.clear();

                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }
            /**
             * adding player to the team list
             */
            else if(currmax==max)
            {
                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }

            prec = playerrecord.next();
        }
        /**
         * for loop for printing the team
         */
        for(int i=0;i<mname.size();i++) {
            if(i==0)
                System.out.println(mname.first()+"\t"+mteam.first() +"\n");
            else
                System.out.println(mname.next()+"\t"+mteam.next() +"\n");
        }
    }

    /**
     * method on maximum shot goals hit
     */
    public void maxShotsGoals() {
        List<String> mname = new List<String>();
        List<String> mteam = new List<String>();
        int max=0, currmax=0;
        PlayerRecord prec = playerrecord.first();
        /**
         * while loop
         */
        while (prec!=null)
        {
            currmax=prec.getShot_goal();
            if (currmax>max)
            { max = currmax;
                mname.clear();
                mteam.clear();

                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }
            else if(currmax==max)
            {
                mname.add(prec.getPlayername());
                mteam.add(prec.getTeam());

            }
            /**
             * hopping on to next player record
             */
            prec = playerrecord.next();
        }
        /**
         * printing the team names
         */
        for(int i=0;i<mname.size();i++) {
            if(i==0)
                System.out.println(mname.first()+"\t"+mteam.first() +"\n");
            else
                System.out.println(mname.next()+"\t"+mteam.next() +"\n");
        }
    }

    /**
     * method of maximum number of penalty minutes
     * making list for the records
     */
    public void maxTeamPenaltyMinutes() {
        List<String> teamrecord = new List<String>();
        List<String> trecord2 = new List<String>();

        int count = playerrecord.size();
        for(int i=0;i<count;i++)
        {
            if(i==0) {
                teamrecord.add(playerrecord.first().getTeam());

            }
            else
            { String team = playerrecord.next().getTeam();
                if(!teamrecord.contains(team))
                    teamrecord.add(team);
            }
        }
        /**
         * putting elements in the list
         * getting the first element
         * asking for next in the list
         * trim function removes the space from it
         */
        List<Integer> penaltyminutes = new List<Integer>();
        for(int i=0;i<teamrecord.size();i++)
        {
            int sum=0;
            String teamname=null;
            if(i==0) {
                teamname = teamrecord.first();
            } else {
                teamname=teamrecord.next().trim();
            }


            for(int j=0;j<playerrecord.size();j++)
            {
                if(j==0)
                { PlayerRecord precord = playerrecord.first();
                    if(precord.getTeam().trim().equals(teamname)) sum+=precord.getPenalty_min();
                }
                else
                {
                    PlayerRecord precord = playerrecord.next();
                    if(precord.getTeam().trim().equals(teamname)) sum+=precord.getPenalty_min();
                }


            }

            penaltyminutes.add(sum);
            trecord2.add(teamname);
        }
        List<String> maxPenaltyTeam = new List<String>();
        List<Integer> maxPenalty = new List<Integer>();
        int max=0; int currmax;
        for(int i=0;i<trecord2.size();i++)
        {	String team = null;
            if(i==0) {
                team = trecord2.first();
                currmax = penaltyminutes.first();
                max=currmax;
                maxPenaltyTeam.add(team);
                maxPenalty.add(max);

            }
            else
            {
                team=trecord2.next();
                currmax=penaltyminutes.next();
                if(currmax>max) {
                    max=currmax;
                    maxPenaltyTeam.clear();
                    maxPenalty.clear();
                    maxPenaltyTeam.add(team);
                    maxPenalty.add(max);

                }
                else if(currmax==max) {
                    max=currmax;
                    maxPenaltyTeam.add(team);
                    maxPenalty.add(max);

                }

            }

        }


        for(int i=0;i<maxPenaltyTeam.size();i++) { if (i==0)
            System.out.println(maxPenaltyTeam.first()+"\t" + maxPenalty.first()+"\n");
        else System.out.println(maxPenaltyTeam.next()+"\t" + maxPenalty.next()+"\n");
        }


    }
    public void maxTeamWinningGoal()
    {
        List<String> teamrecord = new List<String>();
        List<String> trecord2 = new List<String>();

        int count = playerrecord.size();
        for(int i=0;i<count;i++)
        {
            if(i==0) {
                teamrecord.add(playerrecord.first().getTeam());

            }
            else
            { String team = playerrecord.next().getTeam();
                if(!teamrecord.contains(team))
                    teamrecord.add(team);
            }
        }

        List<Integer> winninggoals = new List<Integer>();
        for(int i=0;i<teamrecord.size();i++)
        {
            int sum=0;
            String teamname=null;
            if(i==0) {
                teamname = teamrecord.first();
            } else {
                teamname=teamrecord.next().trim();
            }


            for(int j=0;j<playerrecord.size();j++)
            {
                if(j==0)
                { PlayerRecord precord = playerrecord.first();
                    if(precord.getTeam().trim().equals(teamname)) sum+=precord.getGwgoals();
                }
                else
                {
                    PlayerRecord precord = playerrecord.next();
                    if(precord.getTeam().trim().equals(teamname)) sum+=precord.getGwgoals();
                }


            }

            winninggoals.add(sum);
            trecord2.add(teamname);
        }
        List<String> maxWinGoalTeam = new List<String>();
        List<Integer> maxWinGoal = new List<Integer>();
        int max=0; int currmax;
        for(int i=0;i<trecord2.size();i++)
        {	String team = null;
            if(i==0) {
                team = trecord2.first();
                currmax = winninggoals.first();
                max=currmax;
                maxWinGoalTeam.add(team);
                maxWinGoal.add(max);

            }
            else
            {
                team=trecord2.next();
                currmax=winninggoals.next();
                if(currmax>max) {
                    max=currmax;
                    maxWinGoalTeam.clear();
                    maxWinGoal.clear();
                    maxWinGoalTeam.add(team);
                    maxWinGoal.add(max);

                }
                else if(currmax==max) {
                    max=currmax;
                    maxWinGoalTeam.add(team);
                    maxWinGoal.add(max);

                }

            }

        }
        for(int i=0;i<maxWinGoalTeam.size();i++) { if (i==0)
            System.out.println(maxWinGoalTeam.first()+"\t" + maxWinGoal.first()+"\n");
        else System.out.println(maxWinGoalTeam.next()+"\t" + maxWinGoal.next()+"\n");
        }
    }
}



