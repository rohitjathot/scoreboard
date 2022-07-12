package model;

public enum BallOutcome {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    NO(0),
    WIDE(0),
    WICKET(0);

    private int run;
    BallOutcome(int run) {
        this.run = run;
    }
    int getRun(){
        return run;
    }
}
