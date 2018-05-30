package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private boolean swattered;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp = true;
    private long topTimer;
    private int x;
    private int y = 500;

    public Char(String pic1, String pic2){
        this.x = Randomizer.randomFolder();
        this.pic1 = new Picture(x,y,pic1);
        this.pic2 = new Picture(x,y,pic2);
    }

    public void drawCharacter(){
        pic1.draw();
    }

    public void hit() {
        pic1.delete();
        swattered = true;
        System.out.println("AUTCH!");
    }

    public boolean isSwattered() {
        return swattered;
    }

    public void move(){

        if (goingUp) {

            pic1.translate(0,-10);

            if (reachTop()) {
                goingUp = false;
                topTimer = System.currentTimeMillis();
            }
            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            pic1.translate(0, 10);

            if (pic1.getY() >= 500){
                pic1.delete();
            }
        }

    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

    public boolean hasEnded() {

        return !goingUp && pic1.getY() >= 500;
    }

    public void delete() {

    }

    public int getX(){
        return pic1.getX();
    }

    public int getY(){
        return pic1.getY();
    }

    public int getOffsetX() {
        return pic1.getMaxX();
    }

    public int getOffsetY() {
        return pic1.getMaxY();
    }

}
