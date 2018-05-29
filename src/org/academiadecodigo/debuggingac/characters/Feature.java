package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class Feature implements Hittable {

    private FeatureType featureType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;

    public Feature(FeatureType featureType) {
        this.featureType = featureType;
        this.pic1 = new Picture(x, y, featureType.getNormal());
        this.pic2 = new Picture(x, y, featureType.getCaught());
    }

    @Override
    public void drawCharacter(){
        pic1.draw();
    }

    @Override
    public void hit() throws InterruptedException {
        swattered = true;
        this.pic1.delete();
        this.pic2.draw();
        Thread.sleep(500);
        this.pic2.delete();
        System.out.println("feature Autch!");
    }

    @Override
    public void move() throws InterruptedException {


    }

    public boolean reachTop() {

        if (pic1.getY() == 410) {

            reachTop = true;
        }

        return false;


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

    @Override
    public boolean hasEnded() {
        return false;
    }

    private int randomFolder() {
        return 100 + (200 * (int) (Math.random() * 6));
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }
}
