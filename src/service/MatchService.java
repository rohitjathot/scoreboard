package service;

import model.BallOutcome;
import model.Score;
import model.Team;

public class MatchService {
    private final Team firstTeam;
    private final Team secondTeam;
    private Team battingTeam;
    private Integer target;
    private final ScoreBoard scoreBoard;
    public MatchService(Team firstTeam, Team secondTeam, ScoreBoard scoreBoard) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.scoreBoard = scoreBoard;
        battingTeam = firstTeam;
        target = null;
    }

    public void changeTeam() {
        if(battingTeam.equals(firstTeam)){
            battingTeam = secondTeam;
        }else{
            battingTeam = firstTeam;
        }
    }

    public boolean processBallAndGetStatus(String ballOutcome) throws Exception {
        Score score = process(ballOutcome);
        if(score.isOut()){
            battingTeam.increasePlayerBall();
            battingTeam.out();
            return true;
        }
        battingTeam.addRun(score.getRun());
        battingTeam.addNoBallRun(score.getNoBall());
        battingTeam.addWideBallRun(score.getWideBall());
        battingTeam.addPlayerRun(score.getRun(), score.getSix(), score.getFour());
        boolean itsBall = !score.getNoBall() && !score.getWideBall();
        if(itsBall)
            battingTeam.increasePlayerBall();

        if(score.getRun()%2 == 1)
            changeStrike();
        return itsBall;
    }

    private Score process(String ballOutcome) throws Exception {

        BallOutcome outcome = convertToBallOutcome(ballOutcome);

        Score score = new Score();

        score.setRun(outcome);

        return score;
    }

    public static BallOutcome convertToBallOutcome(String outcome) throws Exception {

        switch (outcome){
            case "0" -> {
                return BallOutcome.ZERO;
            }
            case "1" -> {
                return BallOutcome.ONE;
            }
            case "2" -> {
                return BallOutcome.TWO;
            }
            case "3" ->  {
                return BallOutcome.THREE;
            }
            case "4" ->  {
                return BallOutcome.FOUR;
            }
            case "5" ->  {
                return BallOutcome.FIVE;
            }
            case "6" ->  {
                return BallOutcome.SIX;
            }
            case "NO" ->  {
                return BallOutcome.NO;
            }
            case "Wd" ->  {
                return BallOutcome.WIDE;
            }
            case "W" ->  {
                return BallOutcome.WICKET;
            }
            default -> throw new Exception();
        }
    }

    public void changeStrike() {
        battingTeam.changeStrike();
    }

    public void displayScore() {
        scoreBoard.displayScore(battingTeam);
    }

    public boolean matchEnded() {
        return battingTeam.matchEnded() || (target!=null && battingTeam.getTotalRun()>=target);
    }

    public void incrementOver(int ball) {
        battingTeam.incrementOver(ball);
    }

    public void showResult() {
        if(firstTeam.getTotalRun() > secondTeam.getTotalRun()){
            scoreBoard.displayBattingTeamWinResult(firstTeam.getTeamName(), firstTeam.getTotalRun() - secondTeam.getTotalRun());
        }else if(firstTeam.getTotalRun() < secondTeam.getTotalRun()){
            scoreBoard.displayBowlingTeamWinResult(secondTeam.getTeamName(), secondTeam.getNumberOfPlayers() - secondTeam.getTotalWickets());
        }else{
            scoreBoard.displayTieResult();
        }
    }

    public void setTarget() {
        if(target == null){
            target = battingTeam.getTotalRun()+1;
        }
    }
}
