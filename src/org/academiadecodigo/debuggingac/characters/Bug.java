package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class Bug implements Hittable {

    private int points;
    private BugType bugType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;

    public Bug(BugType bugType) {
        this.bugType = bugType;
        this.pic1 = new Picture(x, y, bugType.getAlive());
        this.pic2 = new Picture(x, y, bugType.getDead());
        this.points = bugType.getKillPoints();
        goingUp = true;
    }

    @Override
    public void hit() {
        pic1.delete();
        swattered = true;
        System.out.println("AUTCH!");
    }

    @Override
    public boolean isSwattered() {
        return swattered;
    }

    @Override
    public void move() throws InterruptedException {

        if (goingUp) {

            pic1.draw();
            pic1.translate(0,-10);

            if (reachTop() == true) {
                goingUp = false;
                topTimer = System.currentTimeMillis();
            }
            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            pic1.translate(0, 10);

            if (pic1.getY() >= 500){
                pic1.delete();
                return;
                }
            }

    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

    @Override
    public boolean hasEnded() {

        return !goingUp && pic1.getY() >= 500;
    }

    @Override
    public int getOffsetX() {
        return x + pic1.getMaxY();
    }

    @Override
    public int getOffsetY() {
        return y + pic1.getMaxY();
    }

    @Override
    public void delete() {

    }

    private int randomFolder() {
        return (190 * (int) (Math.random() * 6));
    }

    public BugType getBugType() {
        return bugType;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getPoints() {
        return points;
    }
}