package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class GameField {

    private Picture background;
    private static final int textMarginTop = 28;
    private Text displayLives;
    private Text displayScore;
    private Text displayTime;

    Text time = new Text(550, textMarginTop, "");
    Text score = new Text(994, textMarginTop, "");
    Text lives = new Text(208, textMarginTop, "");


    public GameField() {
        //Game Window
        background = new Picture(0, 0, "resources/images/gameBG.png");
        background.getWidth();
        background.getHeight();

        //TIME TEXT
        displayTime = new Text(400, textMarginTop, "TIME: ");
        displayTime.setColor(Color.BLACK);
        time.setColor(Color.BLACK);

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
        displayTime.draw();
        time.draw();

    }

    public void updateTime(int time){

        this.time.delete();

        if(time >= 10){
            this.time.setText("" + time);
            this.time.draw();
        } else {
            this.time.setText("0" + time);
            this.time.draw();
        }
    }

    public void updateScore(int score){
        this.score.delete();
        this.score.setText(scoreToText(score));
        this.score.draw();
    }

    public void updateLives(int lives){
        this.lives.delete();
        this.lives.setText("" + lives);
        this.lives.draw();
    }

    private String scoreToText(int score) {

        System.out.println((score+"").length());

        int numberSize = 5;
        int padSize = numberSize - Integer.toString(score).length();

        String paddedNumber = "";

        for (int i = 0; i < padSize; i++) {
            paddedNumber += "0";
        }

        paddedNumber += Integer.toString(score);

        return paddedNumber;

    }

}
