package model;

public class Player {
    private final String playerName;
    private int run;
    private int numberOfBall;
    private int numberOfFour;
    private int numberOfSix;
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void addRun(int run) {
        this.run+=run;
    }
    public void increaseFour() {
        numberOfFour++;
    }

    public void increaseSix() {
        numberOfSix++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRun() {
        return run;
    }

    public int getNumberOfBall() {
        return numberOfBall;
    }

    public int getNumberOfFour() {
        return numberOfFour;
    }

    public int getNumberOfSix() {
        return numberOfSix;
    }

    public int getStrikeRate(){
        return numberOfBall==0? 0: run*100/numberOfBall;
    }

    public void increaseBall() {
        numberOfBall++;
    }
}
