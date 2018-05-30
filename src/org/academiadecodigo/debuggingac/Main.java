package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.menu.Menu;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Swatter swatter = new Swatter();

        Menu menu = new Menu();
        swatter.setClickable(menu);

        menu.selection();

        Game game = new Game();
        swatter.setClickable(game);
        game.startGame();
    }
}
