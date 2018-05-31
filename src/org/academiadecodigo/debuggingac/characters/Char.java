package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.Game;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private boolean swattered;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp = true;
    private long topTimer;
    private int x;
    private int y = Game.getRow1MarginTop()-15;
    private int size = -33;
    private int speed;

    public Char(String pic1, String pic2, int speed){
        this.x = Randomizer.randomFolder();
        this.pic1 = new Picture(x,y,pic1);
        this.pic2 = new Picture(x,y,pic2);
        this.speed = speed;
    }

    public void drawCharacter(){
        pic1.grow(size,size);
        pic1.draw();
        }

    public void hit() throws InterruptedException {
        pic1.delete();
        pic2.grow(size,size);
        pic2.draw();
        Thread.sleep(300);
        pic2.delete();
        swattered = true;
    }

    public boolean isSwattered() {
        return swattered;
    }

    public void move(int speed){

        if (goingUp) {

            pic1.translate(0,-10);
            pic2.translate(0,-10);

            if (reachTop()) {
                goingUp = false;
                topTimer = System.currentTimeMillis();
            }
            return;
        }

        if (System.currentTimeMillis() - topTimer > 1000/speed) {
            pic1.translate(0, 10);
            pic2.translate(0,10);

            if (pic1.getY() >= y){
                pic1.delete();
            }
        }

    }

    public boolean reachTop(){

        return pic1.getY() < y - 40;

    }

    public boolean hasEnded() {

        return !goingUp && pic1.getY() >= y;
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

    public int getSpeed() {
        return speed;
    }
}
