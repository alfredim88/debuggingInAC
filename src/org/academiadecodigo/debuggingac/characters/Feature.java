package org.academiadecodigo.debuggingac.characters;

public class Feature extends Char {

    private FeatureType featureType;

    public Feature(FeatureType featureType) {
        super(featureType.getAlive(), featureType.getDead());
        this.featureType = featureType;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }


}
