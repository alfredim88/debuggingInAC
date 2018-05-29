package org.academiadecodigo.debuggingac.characters;

public interface Hittable {

    boolean hasEnded();

    int getOffsetX();

    int getOffsetY();

    void hit() throws InterruptedException;

    void move() throws InterruptedException;

    boolean isSwattered();

    void delete();

    int getX();

    int getY();
}
