package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.mouse.Mouse;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.debuggingac.audio.Audio;


public class Swatter implements MouseHandler {

    private Clickable clickable;
    private Audio swatHit;

    public Swatter() {
        Mouse swatter = new Mouse(this);
        swatHit = new Audio("/resources/sounds/hammer.wav");
        swatter.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (clickable == null) {
            return;
        }

        clickable.setX((int) e.getX());
        clickable.setY((int) e.getY());

        swatHit.start(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void setClickable(Clickable clickable) {
        this.clickable = clickable;
    }
}
