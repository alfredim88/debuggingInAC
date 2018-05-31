package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.characters.*;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;


public class Game implements Clickable {

    private static final int FOLDERS_PER_ROW = 8;
    private static final int PADDING_FOLDERS = 150;
    private static final int MARGIN_LEFT = 0;
    private static final int ROW_MARGIN_TOP =650;
    private static final int TOTAL_CHARACTERS = 100;
    private GameField gameField;
    private volatile int mouseX;
    private volatile int mouseY;
    private boolean finished;
    private int time = 99;
    private long startTime;
    private long currentTime;
    private int gameLevel = 1;
    private int lives = 3;
    private int score = 0;
    private int currentCharacter = 0;
    private Char[] gameCharacters = new Char[TOTAL_CHARACTERS];
    private Picture[] row1FolderPic = new Picture[FOLDERS_PER_ROW];
    private Picture[] row2FolderPic = new Picture[FOLDERS_PER_ROW];
    private Picture[] row3FolderPic = new Picture[FOLDERS_PER_ROW];

    private String randomFolder(){
        return FolderType.getRandomFolder().getFolderPic();
    }

    public void init() throws InterruptedException {

        gameField = new GameField();


        CharactersFactory factory = new CharactersFactory();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {

            int random = (int) (Math.random() * 10);

            if (random > 1) {
                gameCharacters[i] = factory.createBugs();
            } else {
                gameCharacters[i] = factory.createFeatures();
            }
        }

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {



            String folderPath = randomFolder();
            row1FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP,  folderPath);

            if(gameLevel > 1){
                folderPath = randomFolder();
                row2FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 180,  folderPath);
            }
            folderPath = randomFolder();
            if(gameLevel > 2){
                row3FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 360,  folderPath);
            }
        }
        start();
    }

    public void start() throws InterruptedException {

        startTime = System.currentTimeMillis();


        drawEverything();


        while (!finished && currentCharacter < TOTAL_CHARACTERS) {

            Char character = gameCharacters[currentCharacter];

            while (!character.hasEnded() && !character.isSwattered()) {
                currentTime = System.currentTimeMillis();
               updateTime();
               levelUp();
                character.move(character.getSpeed());

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

                Thread.sleep(10);
            }

            if (lives == 0) {
                finished = true;
                gameOver();
                return;
            }
            mouseX = 0;
            mouseY = 0;
            currentCharacter++;
            Thread.sleep(1000/gameLevel);
        }

    }

    public void gameOver() {
        finished = true;
        Picture gameOver = new Picture(0, 0, "resources/images/gameover.png");
        gameOver.draw();
    }

    private void drawEverything() {

        gameField.drawField();
        gameField.updateTime(time);
        gameField.updateLives(lives);
        gameField.updateScore(score);

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            gameCharacters[i].drawCharacter();
        }

        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            row1FolderPic[i].draw();

            if(gameLevel > 1){
                row2FolderPic[i].draw();
            }

            if (gameLevel > 2){
                row3FolderPic[i].draw();
            }
        }
}

    public static int getFoldersPerRow() {
        return FOLDERS_PER_ROW;
    }

    public static int getPaddingFolders() {
        return PADDING_FOLDERS;
    }

    public static int getRowMarginTop() {
        return ROW_MARGIN_TOP;
    }

    private void updateTime(){

        if(currentTime - startTime > 1000){
            time--;
            startTime = currentTime;
            gameField.updateTime(time);

            if(time <= 0){
                finished = true;
                gameOver();
               // gameFinished();
            }
        }
    }

    private void levelUp(){
        if(score > 199 * gameLevel){
            time += 20;
            gameLevel++;
            System.out.println("level up");
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
