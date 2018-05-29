package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class Feature implements Hittable {

    private FeatureType featureType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private Picture pic1;
    private Picture pic2;

    public Feature(FeatureType featureType) {
        this.featureType = featureType;
        this.pic1 = new Picture(x, y, featureType.getPic1());
        this.pic2 = new Picture(x, y, featureType.getPic2());
    }


    @Override
    public void hit() {
        System.out.println("feature Autch!");
    }

    @Override
    public void move(int speed) throws InterruptedException {
        pic1.draw();
        pic1.translate(0,-10);
        Thread.sleep(100);
        pic1.translate(0,-30);
        Thread.sleep(100);
        pic1.translate(0,-50);
        Thread.sleep(500);
        pic1.translate(0,10);
        Thread.sleep(100);
        pic1.translate(0,30);
        Thread.sleep(100);
        pic1.translate(0,50);
    }

    @Override
    public boolean isSwattered() {
        return swattered;
    }

    @Override
    public int getOffsetX() {
        return x + pic1.getMaxX();
    }

    @Override
    public int getOffsetY() {
        return y + pic1.getMaxY();
    }

    @Override
    public void delete() {

    }

    private int randomFolder(){
        return 100 + (200 * (int)(Math.random() * 6));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }
}
