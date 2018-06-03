
package org.academiadecodigo.debuggingac.menu;

import org.academiadecodigo.debuggingac.Clickable;


public class Menu implements Clickable{

    private MenuEvent menuEvent;
    private volatile int mouseX;
    private volatile int mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private Buttons easterEgg;
    private boolean startSelection;
    private boolean secondaryMenu;
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public Menu() throws InterruptedException {

        menuEvent = new MenuEvent();
        //loading();

        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        easterEgg = ButtonFactory.getNewButton(ButtonType.EASTER_EGG);
        startSelection = false;
        secondaryMenu = false;

    }

    public void selection() throws InterruptedException {

        menuEvent.init();

        if (isUnix()) {
            //menuEvent.soundMenu();
        } else {
            menuEvent.soundMenu();
        }

        menuEvent.mainMenuLoop();

        while (!startSelection) {

            //back button
            if (secondaryMenu) {
                if ((mouseX >= back.getStartX() && mouseX <= back.getEndX()) &&
                        (mouseY >= back.getStartY() && mouseY <= back.getEndY())) {
                    menuEvent.removeCredits();
                    menuEvent.removeTutorial();
                    menuEvent.removeEasterEgg();
                    Thread.sleep(200);
                    secondaryMenu = false;
                    mainMenu();
                }
            }
            /*
             * If the player presses start
             */
            if ((mouseX >= play.getStartX() && mouseX <= play.getEndX()) &&
                    (mouseY >= play.getStartY() && mouseY <= play.getEndY())) {
               //menuEvent.killSoundMenu();
                startSelection = true;
            }
            /*
             * If the the Tutorial submenu is selected
             */
            if ((mouseX >= tutorial.getStartX() && mouseX <= tutorial.getEndX()) &&
                    (mouseY >= tutorial.getStartY() && mouseY <= tutorial.getEndY())) {
                secondaryMenu = true;
                tutorial();
                menuEvent.removeCredits();

            }

            if ((mouseX >= easterEgg.getStartX() && mouseX <= easterEgg.getEndX()) &&
                    (mouseY >= easterEgg.getStartY() && mouseY <= easterEgg.getEndY())) {

                secondaryMenu = true;
                easterEgg();

            }
            /*
             * If the Credits submenu is selected
             */
            if ((mouseX >= credits.getStartX() && mouseX <= credits.getEndX()) &&
                    (mouseY >= credits.getStartY() && mouseY <= credits.getEndY())) {
                secondaryMenu = true;
                credits();
                menuEvent.removeTutorial();

            }
        }
    }



    private void tutorial() {

        menuEvent.tutorial();

    }
    private void credits() {

        menuEvent.credits();

    }

    private void easterEgg() {

        menuEvent.easterEgg();

    }

    private void mainMenu() throws InterruptedException{

        menuEvent.mainMenuLoop();

    }

    public void setX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setY(int mouseY) {
        this.mouseY = mouseY;
    }

}