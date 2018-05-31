package org.academiadecodigo.debuggingac.menu;

public enum ButtonType {
    PLAY(326, 107, 875, 639),
    TUTORIAL(13, 735, 278, 784),
    CREDITS(1036, 735, 1188, 784),
    BACK(527, 716, 667, 784),
    RESTART(360, 466, 583, 532),
    QUIT(516, 466, 844, 532);

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    ButtonType(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
