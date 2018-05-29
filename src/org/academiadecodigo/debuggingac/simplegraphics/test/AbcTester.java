package org.academiadecodigo.debuggingac.simplegraphics.test;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Rectangle;

public class AbcTester {

    public static void main(String[] args) {

        Rectangle r = new Rectangle(10, 10, 200, 200);
        r.draw();

        new AbcKeyboardHandler();

    }
}
