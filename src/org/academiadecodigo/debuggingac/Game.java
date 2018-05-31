package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.characters.*;
import org.academiadecodigo.debuggingac.menu.ButtonFactory;
import org.academiadecodigo.debuggingac.menu.ButtonType;
import org.academiadecodigo.debuggingac.menu.Buttons;
import org.academiadecodigo.debuggingac.menu.MenuEvent;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;


public class Game implements Clickable {

    private static final int FOLDERS_PER_ROW = 8;
    private static final int PADDING_FOLDERS = 150;
    private static final int MARGIN_LEFT = 0;
    private static final int ROW_MARGIN_TOP =650;
    private static final int TOTAL_CHARACTERS = 100;
    private GameField gameField;
    private CharactersFactory factory = new CharactersFactory();
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
    private int bugsInterval = 1000;
    private int initialBugPosition;
    private Char[] gameCharactersRow1 = new Char[TOTAL_CHARACTERS];
    private Char[] gameCharactersRow2 = new Char[TOTAL_CHARACTERS];
    private Char[] gameCharactersRow3 = new Char[TOTAL_CHARACTERS];
    private Picture[] row1FolderPic = new Picture[FOLDERS_PER_ROW];
    private Picture[] row2FolderPic = new Picture[FOLDERS_PER_ROW];
    private Picture[] row3FolderPic = new Picture[FOLDERS_PER_ROW];
    private Buttons restartButton = ButtonFactory.getNewButton(ButtonType.RESTART);
    private Buttons quitButton = ButtonFactory.getNewButton(ButtonType.QUIT);

    private String randomFolder(){
        return FolderType.getRandomFolder().getFolderPic();
    }

    public void init() throws InterruptedException {

        if(gameField == null){
        gameField = new GameField();}

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {

            int random = (int) (Math.random() * 10);

            if (random > 1) {
                gameCharactersRow1[i] = factory.createBugs();
                gameCharactersRow2[i] = factory.createBugs();
                gameCharactersRow3[i] = factory.createBugs();
            } else {
                gameCharactersRow1[i] = factory.createFeatures();
                gameCharactersRow2[i] = factory.createFeatures();
                gameCharactersRow3[i] = factory.createFeatures();
            }
        }

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {

            String folderPath = randomFolder();
            row1FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP,  folderPath);
            row2FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 180,  folderPath);
            row3FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 360,  folderPath);

        }
        start();
    }

    public void start() throws InterruptedException {

        startTime = System.currentTimeMillis();

        drawEverything();

        while (!finished && currentCharacter < TOTAL_CHARACTERS) {

            Char character = chooseCharToMove();
            initialBugPosition = character.getY();

            while (!character.hasEnded() && !character.isSwattered()) {

                if(finished){
                    break;
                }

                currentTime = System.currentTimeMillis();
                updateTime();
                levelUp();
                character.move(character.getSpeed(), initialBugPosition);

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

                Thread.sleep(30);
            }

            if (lives == 0) {
                finished = true;
                gameOver();
                return;
            }
            mouseX = 0;
            mouseY = 0;
            currentCharacter++;
            Thread.sleep(bugsInterval);
        }

    }

    public void gameOver() throws InterruptedException{
        finished = true;
        Picture gameOver = new Picture(0, 0, "resources/images/gameover.png");
        gameOver.draw();
        inGameMenu(gameOver);
    }

    public void inGameMenu(Picture gameOver) throws InterruptedException {

        while(true){

            if (mouseX >= restartButton.getStartX() && mouseX <= restartButton.getEndX() &&
                    mouseY >= restartButton.getStartY() && mouseY <= restartButton.getEndY()) {

                gameOver.delete();
                reset();
                init();

                return;
            }

            if(mouseX >= quitButton.getStartX() && mouseX <= quitButton.getEndX() &&
                    mouseY >= quitButton.getStartY() && mouseY <= quitButton.getEndY()){

                System.exit(0);
            }
        }
    }

    public void reset(){
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            row2FolderPic[i].delete();
            row3FolderPic[i].delete();
        }
        Char.setY(Game.getRowMarginTop()-15);
        finished = false;
        time = 99;
        lives = 3;
        score = 0;
    }

    private void drawEverything() {

        gameField.drawField();
        gameField.updateTime(time);
        gameField.updateLives(lives);
        gameField.updateScore(score);

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            gameCharactersRow1[i].drawCharacter();
        }

        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            row1FolderPic[i].draw();
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

    private void updateTime() throws InterruptedException{

        if(currentTime - startTime > 1000){
            time--;
            startTime = currentTime;
            gameField.updateTime(time);

            if(time <= 0){
                finished = true;
                gameOver();
            }
        }
    }

    private void levelUp() {
        if (score > 19 * gameLevel) {
            time += 20;
            gameLevel++;
            bugsInterval /= 2;

                if (gameLevel == 2) {

                    for (int i = 0; i < TOTAL_CHARACTERS; i++) {

                        int random = (int) (Math.random() * 10);

                        if (random > 1) {
                            Char.setY(ROW_MARGIN_TOP - 195);
                            gameCharactersRow2[i] = factory.createBugs();
                            gameCharactersRow2[i].drawCharacter();
                        } else {
                            Char.setY(ROW_MARGIN_TOP - 195);
                            gameCharactersRow2[i] = factory.createFeatures();
                            gameCharactersRow2[i].drawCharacter();
                        }
                    }

                    for (int i = 0; i < FOLDERS_PER_ROW; i++) {
                        row2FolderPic[i].draw();
                    }
                }

                if (gameLevel == 3) {

                    for (int i = 0; i < TOTAL_CHARACTERS; i++) {

                        int random = (int) (Math.random() * 10);

                        if (random > 1) {
                            Char.setY(ROW_MARGIN_TOP - 375);
                            gameCharactersRow3[i] = factory.createBugs();

                            gameCharactersRow3[i].drawCharacter();
                        } else {
                            Char.setY(ROW_MARGIN_TOP - 375);
                            gameCharactersRow3[i] = factory.createFeatures();
                            gameCharactersRow3[i].drawCharacter();
                        }
                    }

                    for (int i = 0; i < FOLDERS_PER_ROW; i++) {
                        row3FolderPic[i].draw();
                    }
                }
            }
    }

    private Char chooseCharToMove(){
        int switcher = gameLevel;

        if(gameLevel > 3){
            switcher = 3;
        }

        int randomRow = (int) (Math.random() * switcher);
        Char character;
        switch (randomRow){

            case 0:
                character = gameCharactersRow1[currentCharacter];
                break;
            case 1:
                character = gameCharactersRow2[currentCharacter];
                break;
            case 2:
                character = gameCharactersRow3[currentCharacter];
                break;
                default:
                    character = gameCharactersRow1[currentCharacter];
        }

        return character;
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
