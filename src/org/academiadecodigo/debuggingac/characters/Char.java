package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private BugType bugType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private Picture alivePic;
    private Picture hitPic;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;

    public Char(BugType bugType) {
        this.bugType = bugType;
    }

    public void move(int speed) throws InterruptedException {

        if (goingUp) {
            alivePic.draw();
            alivePic.translate(0,-10);

            if (reachTop() == true) {
                System.out.println("top reached");
                goingUp = false;
                topTimer = System.currentTimeMillis();

            }

            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            alivePic.translate(0, 10);

            if (alivePic.getY() == 500){
                alivePic.delete();
            }
        }

    }

    public void hit() {

    }

    public boolean reachTop(){

        return alivePic.getY() < 440;

    }

    public boolean hasEnded() {

        return reachTop && alivePic.getX() == x;
    }

    public boolean isSwattered() {
        return swattered;
    }

    public int getOffsetX() {
        return x + alivePic.getMaxY();
    }

    public int getOffsetY() {
        return y + alivePic.getMaxY();
    }

    public void delete() {

    }

    private int randomFolder() {
        return 100 + (200 * (int) (Math.random() * 6));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
