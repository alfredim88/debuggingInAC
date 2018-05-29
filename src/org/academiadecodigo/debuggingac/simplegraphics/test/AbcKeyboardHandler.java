package org.academiadecodigo.debuggingac.simplegraphics.test;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardHandler;

public class AbcKeyboardHandler implements KeyboardHandler {

    public AbcKeyboardHandler() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_M);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(event);
    }

    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {
            case KeyboardEvent.KEY_R:
                System.out.println("You pressed R");
                break;
            case KeyboardEvent.KEY_M:
                Text text = new Text(10, 10, "M");
                text.setColor(Color.RED);
                text.draw();
                break;
        }

    }

    public void keyReleased(KeyboardEvent event) {
        System.out.println(event);
    }
}
