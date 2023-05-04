package controller;
import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class State {

    protected GameObject g;

    public State(GameObject g) {
        this.g = g;
    }
    public abstract void move(int x, int y);
}
