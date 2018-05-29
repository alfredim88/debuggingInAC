package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.characters.Bug;
import org.academiadecodigo.debuggingac.characters.CharactersFactory;
import org.academiadecodigo.debuggingac.characters.Feature;
import org.academiadecodigo.debuggingac.characters.Hittable;
import org.academiadecodigo.debuggingac.menu.Menu;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;


public class Game implements Clickable {


    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 200;
    private static final int MARGIN_LEFT = 70;
    private static final int MARGIN_TOP = 500;
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
    private Picture[] folderPic = new Picture[FOLDERS_PER_ROW];

    public void init() throws InterruptedException {

        gameField = new GameField();

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

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            String folderPath = FolderType.getRandomFolder().getFolderPic();
            folderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), MARGIN_TOP, "resources/images/folders/folder_arabian-nights.png");
        }

        start();

    }

    public void start() throws InterruptedException {

        drawEverything();


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
