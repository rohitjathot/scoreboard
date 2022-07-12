package model;

import java.util.ArrayList;

//Can use lombok
public class Team {

    private final ArrayList<Player> playerList;
    private final String teamName;
    private int totalRun;
    private int extra;
    private int firstPlayer;
    private int secondPlayer;
    private int onStrike;
    private int nextPlayer;
    private double numberOfOvers;
    private final int numberOfPlayers;
    public Team(int numberOfPlayers, String teamName) {
        playerList = new ArrayList<>(numberOfPlayers);
        firstPlayer = 0;
        secondPlayer = 1;
        nextPlayer = 2;
        this.teamName = teamName;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void addPlayer(String playerName) {
        playerList.add(new Player(playerName));
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public int getFirstPlayer() {
        return firstPlayer;
    }

    public int getSecondPlayer() {
        return secondPlayer;
    }

    public int getExtra() {
        return extra;
    }

    public void changeStrike() {
        if(onStrike == firstPlayer){
            onStrike = secondPlayer;
        }else{
            onStrike = firstPlayer;
        }
    }

    public void out() {
        if(onStrike == firstPlayer){
            firstPlayer = nextPlayer;
        }else{
            secondPlayer = nextPlayer;
        }
        onStrike = nextPlayer;
        nextPlayer++;
    }

    public boolean matchEnded() {
        return nextPlayer > numberOfPlayers;
    }

    public void addRun(int run) {
        totalRun+=run;
    }

    public void addNoBallRun(boolean noBall) {
        if(noBall) {
            totalRun++;
            extra++;
        }
    }

    public void addWideBallRun(boolean wideBall) {
        if(wideBall) {
            totalRun++;
            extra++;
        }
    }

    public void addPlayerRun(int run, boolean six, boolean four) {
        Player player = playerList.get(onStrike); // TO-DO : move to player class
        player.addRun(run);
        if(four)
            player.increaseFour();
        if(six)
            player.increaseSix();
    }

    public void incrementOver(int ball) {
        if(ball<6){
            numberOfOvers+=ball/10.0;
        }else{
            numberOfOvers++;
        }
    }

    public double getNumberOfOvers(){
        return numberOfOvers;
    }

    public int getTotalWickets() {
        return nextPlayer-2;
    }

    public void increasePlayerBall() {
        playerList.get(onStrike).increaseBall();
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
