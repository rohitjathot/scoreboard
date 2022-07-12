package helper;

public class Validator {
    //Can throw exception
    public static boolean validateNumberOfPlayer(int numberOfPlayer){
        return numberOfPlayer >= 2 && numberOfPlayer <= 11;
    }

    public static boolean validateNumberOfOvers(int numberOfOvers){
        return numberOfOvers > 0;
    }
}
