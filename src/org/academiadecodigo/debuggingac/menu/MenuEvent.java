package org.academiadecodigo.debuggingac.menu;

import org.academiadecodigo.debuggingac.audio.Audio;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class MenuEvent {

    private int menuLoops = 1;
    private static Picture menuBG;
    private static Picture menuBG2;
    private static Picture tutorial;
    private static Picture credits;
    private static Picture easterEgg;
    private static Audio menu;
    private static Picture loadingZero;
    private static Picture loadingOne;
    private static Picture loadingTwo;
    private static Picture loadingThree;
    private static Picture loadingFour;
    private static Picture loadingFive;
    private static Picture loadingSix;
    private static Picture loadingSeven;
    private static Picture loadingEight;

    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public MenuEvent() {

        this.menuBG = new Picture(0, 0, "resources/images/menu/menu_x1.png");
        this.menuBG2 = new Picture(0,0,"resources/images/menu/menu_x2.png");
        this.tutorial = new Picture(0,0, "resources/images/menu/tutorial.png");
        this.credits = new Picture(0,0, "resources/images/menu/credits.png");
        this.easterEgg = new Picture(0, 0, "resources/images/menu/easter.png");
        this.loadingZero = new Picture(0, 0, "resources/images/loading/0.jpg");
        this.loadingOne = new Picture(0, 0, "resources/images/loading/1.jpg");
        this.loadingTwo = new Picture(0, 0, "resources/images/loading/2.jpg");
        this.loadingThree = new Picture(0, 0, "resources/images/loading/3.jpg");
        this.loadingFour = new Picture(0, 0, "resources/images/loading/4.jpg");
        this.loadingFive = new Picture(0, 0, "resources/images/loading/5.jpg");
        this.loadingSix = new Picture(0, 0, "resources/images/loading/6.jpg");
        this.loadingSeven = new Picture(0, 0, "resources/images/loading/7.jpg");
        this.loadingEight = new Picture(0, 0, "resources/images/loading/8.jpg");


    }

    public void init() throws InterruptedException{

        loadingZero.draw();
        Thread.sleep(500);

        loadingOne.draw();
        loadingZero.delete();
        Thread.sleep(500);

        loadingTwo.draw();
        loadingOne.delete();
        Thread.sleep(500);

        loadingThree.draw();
        loadingTwo.delete();
        Thread.sleep(500);

        loadingFour.draw();
        loadingThree.delete();
        Thread.sleep(600);

        loadingFive.draw();
        loadingFour.delete();
        Thread.sleep(400);

        loadingSix.draw();
        loadingFive.delete();
        Thread.sleep(400);

        loadingSeven.draw();
        loadingSix.delete();
        Thread.sleep(400);

        loadingEight.draw();
        loadingSeven.delete();
        Thread.sleep(400);



    }

    public void mainMenuLoop() throws  InterruptedException {

        while (menuLoops > 0) {

            menuBG2.draw();
            menuBG.delete();
            loadingEight.delete();
            Thread.sleep(150);

            menuBG.draw();
            menuBG2.delete();
            Thread.sleep(150);

            menuBG2.draw();
            menuBG.delete();
            Thread.sleep(150);

            menuBG.draw();
            menuBG2.delete();
            Thread.sleep(150);
            menuLoops--;

        }

    }


    public void killSoundMenu(){

        menu.stop();

    }

    public void soundMenu(){

        menu = new Audio("/resources/sounds/menubg.wav");
        menu.createLoop(5);
        menu.start(true);

    }
    public void tutorial() {

        tutorial.draw();

    }

    public void credits() {

        credits.draw();

    }

    public void removeCredits() {

        credits.delete();

    }

    public void removeTutorial() {

        tutorial.delete();

    }

    public void easterEgg() {

        easterEgg.draw();

    }

    public void removeEasterEgg() {

        easterEgg.delete();

    }


}
