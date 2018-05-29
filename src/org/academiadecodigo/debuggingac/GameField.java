package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class GameField {

    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 190;
    private static final int MARGIN_LEFT = 0;
    private static final int MARGIN_TOP = 500;
    private Picture background;
    private Picture folderPic;
    private static final int textMarginTop = 28;
    Text score = new Text(994, textMarginTop, "00000");
    Text lives = new Text(208, textMarginTop, "3");


    public GameField() {
        //Game Window
        background = new Picture(0, 0, "resources/images/gameBG.png");
        background.getWidth();
        background.getHeight();
        background.draw();
        //gameWindow.draw();

        //LIVES TEXT
        Text displayLives = new Text(28, textMarginTop, "LIVES: ");
        displayLives.setColor(Color.BLACK);
        displayLives.draw();
        lives.setColor(Color.BLACK);
        lives.draw();

        //SCORE TEXT
        Text displayScore = new Text(800, textMarginTop, "SCORE: ");
        displayScore.setColor(Color.BLACK);
        displayScore.draw();
        score.setColor(Color.BLACK);
        score.draw();

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            folderPic = new Picture(MARGIN_LEFT + (PADDING_FOLDERS * i), MARGIN_TOP, "resources/images/folders/folder_arabian-nights.png");
            folderPic.draw();
        }
    }

}
