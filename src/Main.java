import helper.InputHelper;
import model.Team;
import service.MatchService;
import service.ScoreBoardConsole;

public class Main {
    public static void main(String [] args){
        InputHelper inputHelper = new InputHelper();

        int numberOfPlayers = inputHelper.getNumberOfPlayer();
        int numberOfOvers = inputHelper.getNumberOfOver();

        Team team1 = new Team(numberOfPlayers, "Team 1");
        Team team2 = new Team(numberOfPlayers, "Team 2");

        MatchService matchService = new MatchService(team1, team2, new ScoreBoardConsole());

        startBatting(inputHelper, numberOfPlayers, numberOfOvers, team1, matchService);
        matchService.changeTeam();
        startBatting(inputHelper, numberOfPlayers, numberOfOvers, team2, matchService);
        matchService.showResult();
    }

    private static void startBatting(InputHelper inputHelper, int numberOfPlayers, int numberOfOvers, Team team, MatchService matchService) {
        System.out.println("Batting order for " + team.getTeamName());
        for(int player = 1; player <= numberOfPlayers; player++){
            String playerName = inputHelper.getPlayerName();
            team.addPlayer(playerName);
        }
        boolean  matchEnded = false;
        for(int over = 1; over <= numberOfOvers; over++){
            System.out.println("Over "+over);
            int ball = 1;
            while(ball++<=6){
                String ballOutcome = inputHelper.getBallOutcome();
                try {
                    boolean itsBall = matchService.processBallAndGetStatus(ballOutcome);
                    if(!itsBall){
                        ball--;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input please enter valid input");
                    ball--;
                }
                if(matchService.matchEnded()){
                    matchEnded = true;
                    break;
                }
            }
            matchService.incrementOver(ball-1);
            System.out.println("Scoreboard for " + team.getTeamName());
            matchService.displayScore();
            if(matchEnded)
                break;
            matchService.changeStrike();
        }
        matchService.setTarget();
    }
}
