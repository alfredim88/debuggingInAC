package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.characters.*;
import org.academiadecodigo.debuggingac.menu.Menu;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;


public class Game implements Clickable {

    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 200;
    private static final int MARGIN_LEFT = 0;
    private static final int MARGIN_TOP = 500;
    private static final int TOTAL_CHARACTERS = 10;
    private GameField gameField;
    private volatile int mouseX;
    private volatile int mouseY;
    private boolean quit;
    private boolean finished;
    private boolean levelFinished = false;
    private int gameLevel = 1;
    private int lives = 3;
    private int score = 0;
    private int currentCharacter = 0;
    private Char[] gameCharacters = new Char[TOTAL_CHARACTERS];
    private Picture[] folderPic = new Picture[FOLDERS_PER_ROW];

    public void init() throws InterruptedException {

        gameField = new GameField();

        CharactersFactory factory = new CharactersFactory();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {

            int random = (int) (Math.random() * 10);

            if (random > 2) {
                gameCharacters[i] = factory.createBugs();
            } else {
                gameCharacters[i] = factory.createFeatures();
            }
        }

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            String folderPath = FolderType.getRandomFolder().getFolderPic();
            folderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), MARGIN_TOP, "" + folderPath);
        }

        start();

    }

    public void start() throws InterruptedException {

        drawEverything();

        while (!levelFinished && lives > 0) {

            while (!finished && currentCharacter < TOTAL_CHARACTERS) {

                Char character = gameCharacters[currentCharacter];

                while (!character.hasEnded() && !character.isSwattered()) {

                    character.move();

                    if (mouseX >= character.getX() && mouseX <= character.getOffsetX()
                            && mouseY >= character.getY() && mouseY <= character.getOffsetY()) {

                        character.hit();

                        if (character instanceof Bug) {

                            Bug bug = (Bug) character;
                            score += bug.getPoints();
                            gameField.updateScore(score);
                            break;
                        }

                        lives--;
                        gameField.updateLives(lives);
                        break;
                    }

                    Thread.sleep(50);
                }

                if (lives == 0) {
                    finished = true;
                    gameOver();
                    return;
                }
                mouseX = 0;
                mouseY = 0;
                currentCharacter++;
                Thread.sleep(1000);
                levelFinished = true;
            }
        }

    }

    public void gameOver() throws InterruptedException {
        finished = true;
        Picture gameOver = new Picture(0, 0, "resources/images/gameover.png");
        gameOver.draw();
        Thread.sleep(2000);
    }

    private void drawEverything() {

        gameField.drawField();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            gameCharacters[i].drawCharacter();
        }

        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            folderPic[i].draw();
        }
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
