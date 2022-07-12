package helper;

import java.util.Scanner;

public class InputHelper {
    private Scanner sc;

    public InputHelper(){
        sc = new Scanner(System.in);
    }

    public int getNumberOfPlayer() {
        int players = 0;
        do{
            System.out.println("Enter number of players");
            String playersStr = sc.next();
            try{
                players = Integer.parseInt(playersStr);
            }catch (Exception e){
                players = 0;
            }
        } while (!Validator.validateNumberOfPlayer(players));

        return players;
    }

    public int getNumberOfOver() {
        int over = 0;

        do{
            System.out.println("Enter number of overs");
            String overStr = sc.next();
            try{
                over = Integer.parseInt(overStr);
            }catch (Exception e){
                over = 0;
            }
        } while  (!Validator.validateNumberOfOvers(over));

        return over;
    }

    public String getPlayerName() {
        return sc.next(); //Can add validation using regex
    }

    public String getBallOutcome() {
        return sc.next();
    }
}
