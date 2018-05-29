package org.academiadecodigo.debuggingac.characters;

public enum BugType {
    RED(2, 20, "resources/images/chars/red", "resources/images/chars/goomba.png"),
    PURPLE(1, 10, "resources/images/chars/goomba.png", "resources/images/chars/goomba.png"),
    GREEN(1, 20, "resources/images/chars/goomba.png", "resources/images/chars/goomba.png");

    private int speed;
    private int killPoints;
    private String alive;
    private String dead;

    BugType(int speed, int killPoints, String alive, String dead){
        this.speed = speed;
        this.killPoints = killPoints;
        this.alive = alive;
        this.dead = dead;
    }

    public static BugType getRandomBug(){
        return BugType.values()[(int)(Math.random()*BugType.values().length)];
    }

    public int getSpeed() {
        return speed;
    }

    public int getKillPoints() {
        return killPoints;
    }

    public String getAlive() {
        return alive;
    }

    public String getDead() {
        return dead;
    }
}