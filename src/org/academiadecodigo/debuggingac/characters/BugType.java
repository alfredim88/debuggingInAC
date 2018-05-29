package org.academiadecodigo.debuggingac.characters;

public enum BugType {
    RED(2, 20, "resources/images/bugs/goomba.png", "resources/images/bugs/goomba.png"),
    PURPLE(1, 10, "resources/images/bugs/goomba.png", "resources/images/bugs/goomba.png"),
    BROWN(2, 10, "resources/images/bugs/goomba.png", "resources/images/bugs/goomba.png"),
    GREEN(1, 20, "resources/images/bugs/goomba.png", "resources/images/bugs/goomba.png");

    private int speed;
    private int killPoints;
    private String pic1;
    private String pic2;

    BugType(int speed, int killPoints, String pic1, String pic2){
        this.speed = speed;
        this.killPoints = killPoints;
        this.pic1 = pic1;
        this.pic2 = pic2;
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

    public String getPic1() {
        return pic1;
    }

    public String getPic2() {
        return pic2;
    }
}