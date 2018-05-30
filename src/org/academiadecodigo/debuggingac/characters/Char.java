package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private boolean swattered;
<<<<<<< HEAD
    private int x = randomFolder();
    private int y = 500;
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;



    public void hit() {

        System.out.println("AUTCH!");
    }


=======
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

    public void hit() throws InterruptedException {
        pic1.delete();
        pic2.draw();
        Thread.sleep(300);
        pic2.delete();
        swattered = true;
        System.out.println("AUTCH!");
    }

>>>>>>> parent of 42f88c0... Stuff
    public boolean isSwattered() {
        return swattered;
    }

<<<<<<< HEAD

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

=======
    public void move(){

        if (goingUp) {

            pic1.translate(0,-10);
            pic2.translate(0,-10);

            if (reachTop()) {
                goingUp = false;
                topTimer = System.currentTimeMillis();
            }
>>>>>>> parent of 42f88c0... Stuff
            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            pic1.translate(0, 10);
<<<<<<< HEAD

            if (pic1.getY() == 500){
=======
            pic2.translate(0,10);

            if (pic1.getY() >= 500){
>>>>>>> parent of 42f88c0... Stuff
                pic1.delete();
            }
        }

<<<<<<< HEAD


=======
>>>>>>> parent of 42f88c0... Stuff
    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

<<<<<<< HEAD

    public boolean hasEnded() {

        return reachTop && pic1.getX() == x;
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
=======
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

>>>>>>> parent of 42f88c0... Stuff
}
