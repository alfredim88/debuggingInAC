package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public enum FeatureType {

    BABY(2, 5, "resources/images/chars/baby_normal.png", "resources/images/chars/baby_hit.png", "resources/images/chars/hit.png"),
    TOADETTE(1, 10, "resources/images/chars/toadette_normal.png", "resources/images/chars/toadette_hit.png", "resources/images/chars/hit.png"),
    GOOMBELA(2, 3, "resources/images/chars/goombela_normal.png", "resources/images/chars/goombela_hit.png", "resources/images/chars/hit.png");

    private int speed;
    private int pointsWon;
    private String alive;
    private String dead;
    private String hitCloud;

    FeatureType(int speed, int pointsWon, String alive, String dead, String hitCloud){
        this.speed = speed;
        this.pointsWon = pointsWon;
        this.alive = alive;
        this.dead = dead;
        this.hitCloud = hitCloud;
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

    public String getHitCloud() {
        return hitCloud;
    }
}