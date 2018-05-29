package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class GameField {

    private static final int PADDING = 10;
    private static final int FOLDERS_PER_ROW = 6;
    private static final int PADDING_FOLDERS = 200;
    private static final int MARGIN_LEFT = 70;
    private static final int MARGIN_TOP = 500;
    private Picture background;
    private Picture folderPic;
    Text score = new Text(1200, 50, "0");
    Text lives = new Text(300, 50, "3");


    public GameField() {

        try{
            Font f = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("resources/SuperMario.ttf"))).deriveFont(Font.PLAIN, 24);

        }  catch (Exception ex){
            ex.printStackTrace();
        }

        //Game Window
        background = new Picture(PADDING,PADDING,"resources/images/gameBG.png");
        background.draw();

        //LIVES TEXT
        Text displayLives = new Text(200, 50, "Lives: ");
        displayLives.setColor(Color.GREEN);
        displayLives.grow(80,50);

        displayLives.draw();

        lives.setColor(Color.GREEN);
        lives.grow(10,50);
        lives.draw();

        //SCORE TEXT
        Text displayScore = new Text(1100, 50, "SCORE: ");
        displayScore.setColor(Color.GREEN);
        displayScore.grow(80,50);
        displayScore.draw();

        score.setColor(Color.GREEN);
        score.grow(10,50);
        score.draw();

        //Grid for the folders
        for (int i = 0; i < FOLDERS_PER_ROW; i++) {
            folderPic = new Picture( MARGIN_LEFT + (PADDING_FOLDERS * i),MARGIN_TOP,"resources/images/Folders-PNG-File.png");

            folderPic.draw();
        }
    }

}
