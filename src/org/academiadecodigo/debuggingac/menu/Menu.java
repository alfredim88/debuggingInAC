
package org.academiadecodigo.debuggingac.menu;

import org.academiadecodigo.debuggingac.Clickable;


public class Menu implements Clickable{

    private MenuEvent menuEvent;
    private int mouseX;
    private int mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private boolean startSelection;
    private boolean secondaryMenu;

    public Menu() throws InterruptedException {

        menuEvent = new MenuEvent();
        //loading();
        menuEvent.soundMenu();
        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        startSelection = false;
        secondaryMenu = false;

    }

    public void selection() throws InterruptedException {

        menuEvent.init();
        menuEvent.mainMenu();

        while (!startSelection) {
            //long time = System.currentTimeMillis();

            System.out.println(mouseX +" " + mouseY);


            //back button
            if (secondaryMenu) {
                if ((mouseX >= back.getStartX() && mouseX <= back.getEndX()) &&
                        (mouseY >= back.getStartY() && mouseY <= back.getEndY())) {
                    menuEvent.removeCredits();
                    menuEvent.removeTutorial();
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
                menuEvent.killSoundMenu();
                startSelection = true;
            }
            /*
             * If the the Credits submenu is selected
             */
            if ((mouseX >= tutorial.getStartX() && mouseX <= tutorial.getEndX()) &&
                    (mouseY >= tutorial.getStartY() && mouseY <= tutorial.getEndY())) {
                secondaryMenu = true;
                tutorial();
                menuEvent.removeCredits();
            }
            /*
             * If the Tutorial submenu is selected
             */
            if ((mouseX >= credits.getStartX() && mouseX <= credits.getEndX()) &&
                    (mouseY >= credits.getStartY() && mouseY <= credits.getEndY())) {
                secondaryMenu = true;
                credits();
                menuEvent.removeTutorial();
            }
        }
    }

   /* private void loading() throws InterruptedException {

        //menuEvent.init();
        menuEvent.soundMenu();
        mainMenu();

    }*/
    private void tutorial() {

        menuEvent.tutorial();

    }
    private void credits() {

        menuEvent.credits();

    }

    private void mainMenu() throws InterruptedException{

        menuEvent.mainMenu();

    }

    public void setX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setY(int mouseY) {
        this.mouseY = mouseY;
    }

}