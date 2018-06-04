package org.academiadecodigo.debuggingac.characters;

public class Feature extends Char {

    private FeatureType featureType;
    private int pointsWon;

    public Feature(FeatureType featureType) {
        super(featureType.getAlive(), featureType.getDead(), featureType.getSpeed());
        this.featureType = featureType;
        this.pointsWon = featureType.getPointsWon();
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public int getPointsWon() {
        return pointsWon;
    }
}
