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
    private int lives = 1;
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

        createChars();
        createFolders();
        start();
    }

    public void start() throws InterruptedException {

        startTime = System.currentTimeMillis();

        Picture getReadyImage = new Picture(0, 0, "resources/images/ready_bg.png");
        getReadyImage.draw();
        Thread.sleep(3000);
        getReadyImage.delete();
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
                character.move(character.getSpeed() + gameLevel, initialBugPosition);

                if (mouseX >= character.getX() && mouseX <= character.getOffsetX()
                    && mouseY >= character.getY() && mouseY <= character.getOffsetY()) {

                    character.hit();

                    if (character instanceof Bug) {
                        Bug bug = (Bug) character;
                        bugHitted(bug);
                        break;
                    }

                    lives--;
                    gameField.updateLives(lives);
                    break;
                }
                resetMouse();
                Thread.sleep(30);
            }

         featureNotHitted(character);

            if (lives == 0) {
                finished = true;
                gameOver();
                return;
            }
            resetMouse();
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
            }

            if(mouseX >= quitButton.getStartX() && mouseX <= quitButton.getEndX() &&
                    mouseY >= quitButton.getStartY() && mouseY <= quitButton.getEndY()){

                System.exit(0);
            }
        }
    }

    public void reset(){
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            row1FolderPic[i].delete();
            row2FolderPic[i].delete();
            row3FolderPic[i].delete();
        }

        for (int j = 0; j < TOTAL_CHARACTERS; j++) {
            gameCharactersRow3[j].getPic1().delete();
            gameCharactersRow2[j].getPic1().delete();
            gameCharactersRow1[j].getPic1().delete();
            gameCharactersRow3[j].getPic2().delete();
            gameCharactersRow2[j].getPic2().delete();
            gameCharactersRow1[j].getPic2().delete();
        }


        Char.setY(Game.getRowMarginTop()-15);
        finished = false;
        time = 99;
        lives = 3;
        score = 0;
        gameLevel = 1;

    }

    private void resetMouse(){
        mouseX = 0;
        mouseY = 0;
    }

    private void bugHitted(Bug bug){
            score += bug.getPoints();
            gameField.updateScore(score);
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

    private void levelUp() throws InterruptedException{
        if (score > 199 * gameLevel) {
            time += 20;
            gameLevel++;
            bugsInterval /= 2;
            Picture levelUpImage = new Picture(0, 0, "resources/images/levelup.png");
            levelUpImage.draw();

                if (gameLevel == 2) {

                    for (int i = 0; i < TOTAL_CHARACTERS; i++) {

                        int random = (int) (Math.random() * 10);

                        if (random > 1) {
                            Char.setY(ROW_MARGIN_TOP - 195);
                            gameCharactersRow2[i] = factory.createBugs();
                        } else {
                            Char.setY(ROW_MARGIN_TOP - 195);
                            gameCharactersRow2[i] = factory.createFeatures();
                        }
                    }

                }

                if (gameLevel == 3) {

                    for (int i = 0; i < TOTAL_CHARACTERS; i++) {

                        int random = (int) (Math.random() * 10);

                        if (random > 1) {
                            Char.setY(ROW_MARGIN_TOP - 375);
                            gameCharactersRow3[i] = factory.createBugs();
                        } else {
                            Char.setY(ROW_MARGIN_TOP - 375);
                            gameCharactersRow3[i] = factory.createFeatures();
                        }
                    }
                }
            Thread.sleep(2000);
            levelUpImage.delete();
            drawFolders();
            Thread.sleep(500);
            }
    }

    private void featureNotHitted(Char character){
        if(character instanceof Feature){

            Feature feature = (Feature) character;
            score = score + feature.getPointsWon();
            gameField.updateScore(score);
        }
    }

    private void createChars(){
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
    }

    private void createFolders(){
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {

            String folderPath = randomFolder();
            row1FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP,  folderPath);
            row2FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 180,  folderPath);
            row3FolderPic[i] = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), ROW_MARGIN_TOP - 360,  folderPath);

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

    private void drawFolders(){
        if (gameLevel == 2) {

            for (int i = 0; i < TOTAL_CHARACTERS; i++) {
                gameCharactersRow2[i].drawCharacter();
            }
            for (int i = 0; i < FOLDERS_PER_ROW; i++) {
                row2FolderPic[i].draw();
            }
        }

        if (gameLevel == 3) {

            for (int i = 0; i < TOTAL_CHARACTERS; i++) {
                    gameCharactersRow3[i].drawCharacter();
                }

            for (int i = 0; i < FOLDERS_PER_ROW; i++) {
                row3FolderPic[i].draw();
            }
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
