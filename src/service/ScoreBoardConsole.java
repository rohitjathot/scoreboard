package service;

import model.Player;
import model.Team;

import java.util.ArrayList;

public class ScoreBoardConsole implements ScoreBoard{

    private final String playerName = "Player Name";
    private final String score = "Score";
    private final String four = "4s";
    private final String six = "6s";
    private final String balls = "Balls";
    private final int fixStringLength = 15;
    private final String strikeRate = "Strike Rate";
    @Override
    public void displayScore(Team team) {
        //columns
        print(playerName);
        print(score);
        print(four);
        print(six);
        print(balls);
        print(strikeRate);
        System.out.println();

        ArrayList<Player> playerList = team.getPlayerList();

        for(int player=0; player<playerList.size(); player++){
            String name = playerList.get(player).getPlayerName();
            if(team.getFirstPlayer() == player || team.getSecondPlayer() == player){
                name+="*";
            }
            print(name);
            print(playerList.get(player).getRun()+"");
            print(playerList.get(player).getNumberOfFour()+"");
            print(playerList.get(player).getNumberOfSix()+"");
            print(playerList.get(player).getNumberOfBall()+"");
            print(playerList.get(player).getStrikeRate()+"");
            System.out.println();
        }

        System.out.println("Total "+team.getTotalRun()+"/"+team.getTotalWickets());
        System.out.println("Over "+team.getNumberOfOvers());
        System.out.println("Extra "+team.getExtra());
        System.out.println();
    }

    @Override
    public void displayBattingTeamWinResult(String teamName, int run) {
        System.out.println("Result: "+teamName+" won the match by "+run+" runs");
    }

    @Override
    public void displayBowlingTeamWinResult(String teamName, int wicket) {
        System.out.println("Result: "+teamName+" won the match by "+wicket+" wickets");
    }

    @Override
    public void displayTieResult() {
        System.out.println("Result: Match tied!");
    }

    void print(String str){
        int numberOfSpace = fixStringLength - str.length();
        if(numberOfSpace < 0)
            numberOfSpace = 0;
        String spaces = String.format("%"+numberOfSpace+"s", "");
        System.out.print(str+spaces);
    }
}
