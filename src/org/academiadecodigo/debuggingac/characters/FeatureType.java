package org.academiadecodigo.debuggingac.characters;

public enum FeatureType {

    TOAD_RED(2, 1, "resources/images/features/toad.png", "resources/images/features/toadDead.png"),
    TOAD_PURPLE(1, 1, "resources/images/features/toad.png", "resources/images/features/toadDead.png"),
    TOAD_BROWN(2, 1, "resources/images/features/toad.png", "resources/images/features/toadDead.png"),
    TOAD_GREEN(1, 1, "resources/images/features/toad.png", "resources/images/features/toadDead.png");

    private int speed;
    private int livesLost;
    private String pic1;
    private String pic2;

    FeatureType(int speed, int killPoints, String pic1, String pic2){
        this.speed = speed;
        this.livesLost = killPoints;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    public static FeatureType getRandomFeature(){
        return FeatureType.values()[(int)(Math.random()*FeatureType.values().length)];
    }

    public int getSpeed() {
        return speed;
    }

    public int getLivesLost() {
        return livesLost;
    }

    public String getPic1() {
        return pic1;
    }

    public String getPic2() {
        return pic2;
    }
}