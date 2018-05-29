package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class Bug implements Hittable {

    private BugType bugType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private int points;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;

    public Bug(BugType bugType) {
        this.bugType = bugType;
        this.pic1 = new Picture(x, y, bugType.getPic1());
        this.pic2 = new Picture(x, y, bugType.getPic2());
        this.points = bugType.getKillPoints();
        goingUp = true;
    }

    @Override
    public void hit() {

        System.out.println("AUTCH!");
    }

    @Override
    public boolean isSwattered() {
        return swattered;
    }

    @Override
    public void move(int speed) throws InterruptedException {

        if (goingUp) {

            pic1.draw();
            pic1.translate(0,-10);

            if (reachTop() == true) {
                goingUp = false;
                topTimer = System.currentTimeMillis();
                System.out.println("top reached");
            }

            return;
        }

        if (System.currentTimeMillis() - topTimer > 3000) {
            pic1.translate(0, 10);
        }

    }

    public boolean reachTop(){

        if(pic1.getY() == 410){

            reachTop = true;
        }

        return false;


    }

    @Override
    public boolean hasEnded() {

        return reachTop && pic1.getX() == x;
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
        return 100 + (200 * (int) (Math.random() * 6));
    }

    public BugType getBugType() {
        return bugType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPoints() {
        return points;
    }
}