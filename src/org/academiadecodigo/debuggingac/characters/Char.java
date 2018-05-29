package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private BugType bugType;
    private boolean swattered;
    private int x = randomFolder();
    private int y = 500;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;

    public Char(BugType bugType) {
        this.bugType = bugType;
    }

    public void move(int speed) throws InterruptedException {

        if (goingUp) {
            System.out.println(pic1.getY());
            pic1.draw();
            pic1.translate(0,-10);

            if (reachTop() == true) {
                System.out.println("top reached");
                goingUp = false;
                topTimer = System.currentTimeMillis();

            }

            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            pic1.translate(0, 10);

            if (pic1.getY() == 500){
                pic1.delete();
            }
        }

    }

    public void hit() {

    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

    public boolean hasEnded() {

        return reachTop && pic1.getX() == x;
    }

    public boolean isSwattered() {
        return swattered;
    }

    public int getOffsetX() {
        return x + pic1.getMaxY();
    }

    public int getOffsetY() {
        return y + pic1.getMaxY();
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
