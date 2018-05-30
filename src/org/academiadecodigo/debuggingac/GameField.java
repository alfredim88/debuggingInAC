package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class GameField {

<<<<<<< HEAD
=======
    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 190;
    private static final int MARGIN_LEFT = 0;
    private static final int MARGIN_TOP = 500;
>>>>>>> origin/monica
    private Picture background;
    private static final int textMarginTop = 28;
    private Text displayLives;
    private Text displayScore;
    Text score = new Text(994, textMarginTop, "0");
    Text lives = new Text(208, textMarginTop, "3");


    public GameField() {
        //Game Window
        background = new Picture(0, 0, "resources/images/gameBG.png");
        background.getWidth();
        background.getHeight();

        //gameWindow.draw();

        //LIVES TEXT
        displayLives = new Text(28, textMarginTop, "LIVES: ");
        displayLives.setColor(Color.BLACK);
        lives.setColor(Color.BLACK);


        //SCORE TEXT
        displayScore = new Text(800, textMarginTop, "SCORE: ");
        displayScore.setColor(Color.BLACK);
        score.setColor(Color.BLACK);

    }

    public void drawField(){
        background.draw();
        displayLives.draw();
        lives.draw();
        displayScore.draw();
        score.draw();

    }

    public void updateScore(int score){
        this.score.delete();
        this.score.setText("" + score);
        this.score.draw();
    }

    public void updateLives(int lives){
        this.lives.delete();
        this.lives.setText("" + lives);
        this.lives.draw();
    }

}
