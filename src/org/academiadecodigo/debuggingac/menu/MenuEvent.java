package org.academiadecodigo.debuggingac.menu;

import org.academiadecodigo.debuggingac.Game;
import org.academiadecodigo.debuggingac.audio.Audio;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class MenuEvent {

    private static final int MENU_LOOPS = 1;

    private static Picture menuBG;
    private static Picture menuBG2;
    private static Picture tutorial;
    private static Picture credits;
    private static Audio menu;
    private static Picture loadingOne;
    private static Picture loadingTwo;
    private static Picture loadingThree;
    private static Picture loadingFour;
    private static Picture loadingFive;
    private static Picture loadingSix;
    private static Picture loadingSeven;
    private static Picture loadingEight;
    private static Audio loadingSound;

    public MenuEvent() {

        this.menuBG = new Picture(0, 0, "resources/images/menu/menu_x1.png");
        this.menuBG2 = new Picture(0,0,"resources/images/menu/menu_x2.png");
        this.tutorial = new Picture(0,0, "resources/images/menu/tutorial.png");
        this.credits = new Picture(0,0, "resources/images/menu/credits.png");
        this.loadingSound = new Audio("/resources/sounds/boot.wav");
        this.loadingOne = new Picture(0, 0, "resources/images/loadingmenu/1.jpg");
        this.loadingTwo = new Picture(0, 0, "resources/images/loadingmenu/2.jpg");
        this.loadingThree = new Picture(0, 0, "resources/images/loadingmenu/3.jpg");
        this.loadingFour = new Picture(0, 0, "resources/images/loadingmenu/4.jpg");
        this.loadingFive = new Picture(0, 0, "resources/images/loadingmenu/5.jpg");
        this.loadingSix = new Picture(0, 0, "resources/images/loadingmenu/6.jpg");
        this.loadingSeven = new Picture(0, 0, "resources/images/loadingmenu/7.jpg");
        this.loadingEight = new Picture(0, 0, "resources/images/loadingmenu/8.jpg");

    }

    public void init() throws InterruptedException{

        loadingOne.draw();
        Thread.sleep(1000);

       /* loadingTwo.draw();
        loadingOne.delete();
        game.init();
        Thread.sleep(500);

        loadingThree.draw();
        loadingTwo.delete();
        Thread.sleep(800);

        loadingFour.draw();
        loadingThree.delete();
        Thread.sleep(600);

        loadingFive.draw();
        loadingFour.delete();
        Thread.sleep(400);

        loadingSound.start(true);
        Thread.sleep(1750);

        loadingSix.draw();
        loadingFive.delete();
        Thread.sleep(400);

        loadingSeven.draw();
        loadingSix.delete();
        Thread.sleep(400);
*/
        loadingEight.draw();
        loadingSeven.delete();
        Thread.sleep(400);

    }

    public void mainMenuLoop(int menuLoops) throws  InterruptedException {

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

            Rectangle teste = new Rectangle(1036, 735, 1188 - 1036 , 784 - 735);
            teste.draw();

        }

    }

    public void mainMenu() throws InterruptedException{

        mainMenuLoop(MENU_LOOPS);

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


}
