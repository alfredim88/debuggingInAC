package org.academiadecodigo.debuggingac.characters;

public class Bug extends Char {

    private int points;
    private BugType bugType;

    public Bug(BugType bugType) {
        super(bugType.getAlive(), bugType.getDead(), bugType.getHitCloud(), bugType.getSpeed());
        this.bugType = bugType;
        this.points = bugType.getKillPoints();
    }
/*
    public BugType getBugType() {
        return bugType;
    }*/

    public int getPoints() {
        return points;
    }

}