package service;

import model.Team;

public interface ScoreBoard {
    public void displayScore(Team battingTeam);

    void displayBattingTeamWinResult(String teamName, int i);

    void displayBowlingTeamWinResult(String teamName, int i);

    void displayTieResult();
}
