package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public enum FeatureType {

    BABY(2, 5, "resources/images/chars/baby_normal.png", "resources/images/chars/baby_hit.png"),
    TOADETTE(1, 10, "resources/images/chars/toadette_normal.png", "resources/images/chars/toadette_hit.png"),
    GOOMBELA(2, 3, "resources/images/chars/goombela_normal.png", "resources/images/chars/goombela_hit.png");

    private int speed;
    private int pointsWon;
    private String alive;
    private String dead;

    FeatureType(int speed, int pointsWon, String alive, String dead){
        this.speed = speed;
        this.pointsWon = pointsWon;
        this.alive = alive;
        this.dead = dead;
    }

    public static FeatureType getRandomFeature(){

        return FeatureType.values()[(int)(Math.random()*FeatureType.values().length)];

    }

    public int getSpeed() {
        return speed;
    }

    public int getPointsWon() {
        return pointsWon;
    }

    public String getAlive() {
        return alive;
    }

    public String getDead() {
        return dead;
    }

}