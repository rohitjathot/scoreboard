package model;

public class Score {

    private boolean out;
    private boolean noBall;
    private boolean wideBall;
    private boolean four;
    private boolean six;
    private int run;
    public void setRun(BallOutcome outcome) {
        run = outcome.getRun();
        switch (outcome){
            case FOUR -> four = true;
            case SIX -> six = true;
            case NO -> noBall = true;
            case WIDE -> wideBall = true;
            case WICKET -> out = true;
        }
    }

    public boolean isOut() {
        return out;
    }

    public int getRun() {
        return run;
    }

    public boolean getNoBall() {
        return noBall;
    }

    public boolean getWideBall() {
        return wideBall;
    }

    public boolean getSix() {
        return six;
    }

    public boolean getFour() {
        return four;
    }
}
