package org.academiadecodigo.debuggingac.characters;

public interface Hittable {

    void move(int speed) throws InterruptedException;

    int getOffsetX();

    int getOffsetY();

    void hit();

    boolean isSwattered();

    void delete();
}
