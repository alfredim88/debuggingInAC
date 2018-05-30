package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public abstract class Char {

    private boolean swattered;
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> parent of 42f88c0... Stuff
=======
    private int x = randomFolder();
    private int y = 500;
>>>>>>> parent of b3a5e0b... new stuff
    private Picture pic1;
    private Picture pic2;
    private boolean goingUp;
    private long topTimer;
    private boolean reachTop;



    public void hit() {

        System.out.println("AUTCH!");
    }

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 42f88c0... Stuff
=======
>>>>>>> parent of 42f88c0... Stuff
=======

>>>>>>> parent of b3a5e0b... new stuff
    public boolean isSwattered() {
        return swattered;
    }

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> parent of 42f88c0... Stuff
    public void move(){
=======
>>>>>>> parent of b3a5e0b... new stuff

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
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 42f88c0... Stuff
=======
>>>>>>> parent of 42f88c0... Stuff
=======

>>>>>>> parent of b3a5e0b... new stuff
            return;
        }

        if (System.currentTimeMillis() - topTimer > 2000) {
            pic1.translate(0, 10);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

            if (pic1.getY() == 500){
=======
            pic2.translate(0,10);

            if (pic1.getY() >= 500){
>>>>>>> parent of 42f88c0... Stuff
=======
            pic2.translate(0,10);

            if (pic1.getY() >= 500){
>>>>>>> parent of 42f88c0... Stuff
=======

            if (pic1.getY() == 500){
>>>>>>> parent of b3a5e0b... new stuff
                pic1.delete();
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> parent of 42f88c0... Stuff
=======
>>>>>>> parent of 42f88c0... Stuff
=======


>>>>>>> parent of b3a5e0b... new stuff
    }

    public boolean reachTop(){

        return pic1.getY() < 440;

    }

<<<<<<< HEAD
<<<<<<< HEAD
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
