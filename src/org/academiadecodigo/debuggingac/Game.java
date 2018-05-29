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
    private static final int TOTAL_CHARACTERS = 5;
    private GameField gameField;
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
        System.out.println("game start");
    }


    public void startGame() throws InterruptedException {

        gameField = new GameField();
        init();
    }

    /*public void menu() throws InterruptedException {
        Menu menu = new Menu();
        menu.selection();
        init();
    }*/

    public void init() throws InterruptedException {

        System.out.println("creating characters");

        CharactersFactory factory = new CharactersFactory();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            int random = (int) (Math.random() * 10);

            if (random > -1) {
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

    public void start() throws InterruptedException {

        //long time = System.currentTimeMillis();

        while (!finished && currentCharacter < TOTAL_CHARACTERS) {

            for (int i = 0; i < TOTAL_CHARACTERS; i++) {

                showRandomCharacter();
                currentCharacter++;
                Thread.sleep(1000);
            }

        }

    }

    private void showRandomCharacter() throws InterruptedException {

        Hittable character = gameCharacters[currentCharacter];

        while (!character.hasEnded()) {

            character.move();

            if (mouseX >= character.getX() && mouseX <= character.getOffsetX() || mouseX + 50 >= character.getX() && mouseX <= character.getOffsetX()
                    && mouseY >= character.getY() && mouseY <= character.getOffsetY() || mouseY + 50 >= character.getY() && mouseY <= character.getOffsetY()) {



            if (character instanceof Bug) {

                Bug bug = (Bug) character;
                if(!bug.isSwattered()) {
                    bug.hit();
                    gameField.score.delete();
                    gameField.score.setText("" + score);
                    gameField.score.draw();
                    score += bug.getPoints();
                }
                break;

            }


            if (character instanceof Feature) {

                Feature feature = (Feature) character;

                feature.hit();

                    lives--;
                    gameField.lives.delete();
                    gameField.lives.setText("" + lives);
                    gameField.lives.draw();

                }

                if (lives == 0) {
                    gameOver();
                }
            }
            mouseY = 0;
            mouseX = 0;

            Thread.sleep(10);
        }

    }

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

}
