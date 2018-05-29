package org.academiadecodigo.debuggingac.characters;

public interface Hittable {

    void move(int speed) throws InterruptedException;

    boolean hasEnded();

    int getOffsetX();

    int getOffsetY();

    void hit() throws InterruptedException;

    boolean isSwattered();

    void delete();
}
