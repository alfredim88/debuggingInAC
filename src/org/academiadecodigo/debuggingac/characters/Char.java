package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private boolean swattered;
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

    public boolean isSwattered() {
        return swattered;
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


    public void move(){

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
            pic2.translate(0,10);

            if (pic1.getY() >= 500){

            pic2.translate(0,10);

            if (pic1.getY() >= 500){


            if (pic1.getY() == 500){
                pic1.delete();
            }
        }

    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

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
=======
>>>>>>> parent of 42f88c0... Stuff
=======

>>>>>>> parent of b3a5e0b... new stuff
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

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 42f88c0... Stuff
=======
>>>>>>> parent of 42f88c0... Stuff
=======
    public int getY() {
        return y;
    }
>>>>>>> parent of b3a5e0b... new stuff
}
