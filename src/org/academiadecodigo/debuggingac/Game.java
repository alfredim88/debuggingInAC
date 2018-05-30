package org.academiadecodigo.debuggingac;

<<<<<<< HEAD
import org.academiadecodigo.debuggingac.characters.Bug;
import org.academiadecodigo.debuggingac.characters.CharactersFactory;
import org.academiadecodigo.debuggingac.characters.Feature;
import org.academiadecodigo.debuggingac.characters.Hittable;
=======
import org.academiadecodigo.debuggingac.characters.*;
>>>>>>> parent of 42f88c0... Stuff
import org.academiadecodigo.debuggingac.menu.Menu;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;


public class Game implements Clickable {

<<<<<<< HEAD

    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 200;
    private static final int MARGIN_LEFT = 70;
    private static final int MARGIN_TOP = 500;
    private static final int TOTAL_CHARACTERS = 5;
    private GameField gameField;
    private int mouseX;
    private int mouseY;
=======
    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 200;
    private static final int MARGIN_LEFT = 0;
    private static final int MARGIN_TOP = 500;
    private static final int TOTAL_CHARACTERS = 30;
    private GameField gameField;
    private volatile int mouseX;
    private volatile int mouseY;
>>>>>>> parent of 42f88c0... Stuff
    private boolean quit;
    private boolean finished;
    private int gameLevel = 1;
    private int lives = 3;
    private int score = 0;
    private int currentCharacter = 0;
<<<<<<< HEAD
    private Hittable[] gameCharacters = new Hittable[TOTAL_CHARACTERS];
=======
    private Char[] gameCharacters = new Char[TOTAL_CHARACTERS];
>>>>>>> parent of 42f88c0... Stuff
    private Picture[] folderPic = new Picture[FOLDERS_PER_ROW];

    public void init() throws InterruptedException {

        gameField = new GameField();

        CharactersFactory factory = new CharactersFactory();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
<<<<<<< HEAD
            int random = (int) (Math.random() * 10);

            if (random > -1) {
                gameCharacters[i] = factory.createBugs();
                System.out.println("bug");
            } else {
                gameCharacters[i] = factory.createFeatures();
                System.out.println("feature");
=======

            int random = (int) (Math.random() * 10);

            if (random > 2) {
                gameCharacters[i] = factory.createBugs();
            } else {
                gameCharacters[i] = factory.createFeatures();
>>>>>>> parent of 42f88c0... Stuff
            }
        }

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            String folderPath = FolderType.getRandomFolder().getFolderPic();
<<<<<<< HEAD
            folderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), MARGIN_TOP, "resources/images/folders/folder_arabian-nights.png");
=======
            folderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), MARGIN_TOP, "" + folderPath);
>>>>>>> parent of 42f88c0... Stuff
        }

        start();

    }

    public void start() throws InterruptedException {

        drawEverything();

<<<<<<< HEAD

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

            if (mouseX >= character.getX() && mouseX <= character.getOffsetX()
                    || mouseX + 50 >= character.getX() && mouseX <= character.getOffsetX()
                    && mouseY >= character.getY() && mouseY <= character.getOffsetY()
                    || mouseY + 50 >= character.getY() && mouseY <= character.getOffsetY()) {

                if (character instanceof Bug) {

                    Bug bug = (Bug) character;
                    bug.hit();
                    score += bug.getPoints();
                    gameField.updateScore(score);
                    return;
                }


                if (character instanceof Feature) {

                    Feature feature = (Feature) character;
                    feature.hit();
                    lives--;
                    gameField.updateScore(lives);
                }

            }

            if (lives == 0) {
                gameOver();
                return;
            }

            Thread.sleep(5);
        }
=======
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
        }

>>>>>>> parent of 42f88c0... Stuff
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
