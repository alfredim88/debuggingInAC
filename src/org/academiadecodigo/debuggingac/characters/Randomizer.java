package org.academiadecodigo.debuggingac.characters;

import org.academiadecodigo.debuggingac.Game;

public class Randomizer {

    public static int randomFolder() {
        return  Game.getPaddingFolders() * (int) (Math.random() * Game.getFoldersPerRow());
    }

}
