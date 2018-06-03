package org.academiadecodigo.debuggingac.characters;

public enum BugType {
    RED(2, 50, "resources/images/chars/red_normal.png", "resources/images/chars/red_hit.png", "resources/images/chars/hit.png"),
    PURPLE(1, 25, "resources/images/chars/purple_normal.png", "resources/images/chars/purple_hit.png", "resources/images/chars/hit.png"),
    GREEN(1, 10, "resources/images/chars/green_normal.png", "resources/images/chars/green_hit.png", "resources/images/chars/hit.png");

    private int speed;
    private int killPoints;
    private String alive;
    private String dead;
    private String hitCloud;

    BugType(int speed, int killPoints, String alive, String dead, String hitCloud){
        this.speed = speed;
        this.killPoints = killPoints;
        this.alive = alive;
        this.dead = dead;
        this.hitCloud = hitCloud;
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

    public String getHitCloud() {
        return hitCloud;
    }
}