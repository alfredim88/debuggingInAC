package org.academiadecodigo.debuggingac.characters;

public class CharactersFactory {

    public Bug createBugs(){

        BugType bugType = BugType.getRandomBug();
        return new Bug(bugType);

    }

    public Feature createFeatures(){

        FeatureType featureType = FeatureType.getRandomFeature();
        return new Feature(featureType);
    }

}