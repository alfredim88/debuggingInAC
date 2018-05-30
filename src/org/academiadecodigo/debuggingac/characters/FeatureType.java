package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public enum FeatureType {

    BABY(2, 1, "resources/images/chars/baby_normal.png", "resources/images/chars/baby_hit.png"),
    TOADETTE(1, 1, "resources/images/chars/toadette_normal.png", "resources/images/chars/toadette_hit.png"),
    GOOMBELA(2, 1, "resources/images/chars/goombela_normal.png", "resources/images/chars/goombela_hit.png");

    private int speed;
    private int livesLost;
    private String alive;
    private String dead;

    FeatureType(int speed, int killPoints, String alive, String dead){
        this.speed = speed;
        this.livesLost = killPoints;
        this.alive = alive;
        this.dead = dead;
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

    public String getAlive() {
        return alive;
    }

    public String getDead() {
        return dead;
    }

}