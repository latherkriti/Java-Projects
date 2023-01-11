package com.kriti;

public class PlayerRecord {
    /**
     * Instance Variables
     */
    private String playername;
    private String position;
    private String team;
    private int games_played;
    private int goals_secured;
    private int assists;
    private int penalty_min;
    private int shot_goal;
    private int gwgoals;

    /**
     * Constructors
     * @param playername
     * @param position
     * @param team
     * @param games_played
     * @param goals_secured
     * @param assists
     * @param penalty_min
     * @param shot_goal
     * @param gwgoals
     */

    public PlayerRecord(String playername, String position, String team, int games_played, int goals_secured, int assists,
                        int penalty_min, int shot_goal, int gwgoals) {
        super();
        this.playername = playername;
        this.position = position;
        this.team = team;
        this.games_played = games_played;
        this.goals_secured = goals_secured;
        this.assists = assists;
        this.penalty_min = penalty_min;
        this.shot_goal = shot_goal;
        this.gwgoals = gwgoals;
    }

    /**
     * toString Method to print
     * @return
     */
    public String toString() {
        return playername + "\t" + position + "\t" + team + "\t" + games_played +"\t" +
                goals_secured +"\t" + assists +"\t" + penalty_min +"\t" + shot_goal +"\t" + gwgoals + "\n";

    }

    /**
     * Method for checking whether the entities are similar or not
     * @param other
     * @return
     */
    public boolean equals(PlayerRecord other)
    {
        return ( playername.equals(other.getPlayername())&& position.equals(other.getPosition()) &&
                team.equals(other.getTeam()) && games_played==other.getGames_played() && goals_secured==other.getGoals_secured() &&
                assists==other.getAssists() && penalty_min==other.getPenalty_min() && shot_goal==other.getShot_goal() &&
                gwgoals==other.getGwgoals());
    }

    /**
     * getters are setters
     * @return
     */
    public String getPlayername() {
        return playername;
    }
    public String getPosition() {
        return position;
    }
    public String getTeam() {
        return team;
    }
    public int getGames_played() {
        return games_played;
    }
    public int getGoals_secured() {
        return goals_secured;
    }
    public int getAssists() {
        return assists;
    }
    public int getPenalty_min() {
        return penalty_min;
    }
    public int getShot_goal() {
        return shot_goal;
    }
    public int getGwgoals() {
        return gwgoals;
    }

}

