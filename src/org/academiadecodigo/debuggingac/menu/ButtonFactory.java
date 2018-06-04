package org.academiadecodigo.debuggingac.menu;

public class ButtonFactory {

    public static Buttons getNewButton(ButtonType type) {
        return new Buttons(type.getStartX(), type.getStartY(), type.getEndX(), type.getEndY());
    }
}
