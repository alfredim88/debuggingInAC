package org.academiadecodigo.debuggingac.characters;

public enum FeatureType {

    BABY(2, 1, "resources/images/chars/baby_normal.png", "resources/images/features/baby_hit.png"),
    TOADETTE(1, 1, "resources/images/chars/toadette_normal.png", "resources/images/features/toadette_hit.png"),
    GOOMBELA(2, 1, "resources/images/chars/goombela_normal.png", "resources/images/features/goombela_hit.png");

    private int speed;
    private int livesLost;
    private String normal;
    private String caught;

    FeatureType(int speed, int killPoints, String normal, String caught){
        this.speed = speed;
        this.livesLost = killPoints;
        this.normal = normal;
        this.caught = caught;
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

    public String getNormal() {
        return normal;
    }

    public String getCaught() {
        return caught;
    }
}