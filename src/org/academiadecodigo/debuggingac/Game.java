package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.characters.Bug;
import org.academiadecodigo.debuggingac.characters.CharactersFactory;
import org.academiadecodigo.debuggingac.characters.Feature;
import org.academiadecodigo.debuggingac.characters.Hittable;
import org.academiadecodigo.debuggingac.menu.Menu;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardHandler;

public class Game implements Clickable {
    private static final int TOTAL_CHARACTERS = 30;
    private GameField gameField;//private Swatter swatter;
    private int mouseX;
    private int mouseY;
    private boolean quit;
    private boolean finished;
    private int gameLevel = 1;
    private int lives = 3;
    private int score = 0;
    private int currentCharacter = 0;
    private Hittable[] gameCharacters = new Hittable[TOTAL_CHARACTERS];


    public Game() {
        new Controller();
        System.out.println("game start");
    }


    public void startGame() throws InterruptedException{

        gameField = new GameField();
        init();
    }

    public void menu() throws InterruptedException {
        Menu menu = new Menu();
        menu.selection();
        init();
    }

    public void init() throws InterruptedException {

        System.out.println("creating characters");

        CharactersFactory factory = new CharactersFactory();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            int random = (int) (Math.random() * 10);

            if (random > 3) {
                gameCharacters[i] = factory.createBugs();
                System.out.println("bug");
            } else {
                gameCharacters[i] = factory.createFeatures();
                System.out.println("feature");
            }
        }

        System.out.println("chars created");

        start();

    }

    public void start() throws InterruptedException{

        System.out.println("it started allright");

        while (!finished && currentCharacter < TOTAL_CHARACTERS) {

            for (int i = 0; i < TOTAL_CHARACTERS; i++) {
                showRandomCharacter();
                //field.updateScore();


                gameField.score.delete();
                gameField.score.setText("" + score);
                gameField.score.draw();

                currentCharacter++;

            }
        }

        //levelUp();
        //nextLevelMenu();

    }

   /* private Hittable chooseRandomCharacter() {
        Hittable randomChar = gameCharacters[(int) (Math.random() * gameCharacters.length)];
        return randomChar;
    }*/

    private void showRandomCharacter() throws InterruptedException {

        //para aparecer apenas 1 character de cada vez
        Hittable character = gameCharacters[currentCharacter];

        //criar o movimento do boneco no local correto


        if (character instanceof Bug) {

            Bug bug = (Bug) character;

            bug.move(bug.getBugType().getSpeed());


            if (mouseX >= bug.getX() && mouseX <= bug.getOffsetX() || mouseX + 50 >= bug.getX() && mouseX <= bug.getOffsetX()
                    && mouseY >= bug.getY() && mouseY <= bug.getOffsetY() || mouseY + 50 >= bug.getY() && mouseY <= bug.getOffsetY()) {

                character.hit();

                score += bug.getPoints();
                System.out.println("score! " + score);
                return;
            }
        }


        if (character instanceof Feature) {

            Feature feature = (Feature) character;

            feature.move(feature.getFeatureType().getSpeed());

            if (mouseX >= feature.getX() && mouseX <= feature.getOffsetX() || mouseX +30 >= feature.getX() && mouseX <= feature.getOffsetX()
                    && mouseY >= feature.getY() && mouseY <= feature.getOffsetY() || mouseY - 30 >= feature.getY() && mouseY <= feature.getOffsetY()) {

                character.hit();
            }

            lives--;

            if (lives == 0) {
                gameOver();
            }
            return;
        }
    }

    /* private void levelUp(){

         if(score >= LevelScores(gameLevel)){
             gameLevel++;
             gameMenu();
         } else {
             gameOverMenu();
         }
     }
 */
    private void gameOver() {
        finished = true;
        //gameOverMenu();

    }

    public int getScore() {
        return score;
    }


    @Override
    public void setX(int x) {
        mouseX = x;
    }

    @Override
    public void setY(int y) {
        mouseY = y;
    }

    private class Controller implements KeyboardHandler {
        private Keyboard key;
        private KeyboardEvent[] escKey;

        Controller(){
            key = new Keyboard(this);
            escKey = new KeyboardEvent[2];
            createEvent();
            setEvents();
            addEventListener();
        }

        void createEvent() {
            for (int i = 0; i < escKey.length; i++) {
                escKey[i] = new KeyboardEvent();
            }
        }

        void setEvents() {
            escKey[0].setKey(KeyboardEvent.KEY_ESC);
            escKey[0].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            escKey[1].setKey(KeyboardEvent.KEY_ESC);
            escKey[1].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        }

        void addEventListener() {
            for (KeyboardEvent event : escKey) {
                key.addEventListener(event);
            }
        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            quit = true;
        }

        @Override
        public void keyReleased(KeyboardEvent e) {
        }
    }

}
