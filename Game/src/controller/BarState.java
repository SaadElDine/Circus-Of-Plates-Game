package controller;
import eg.edu.alexu.csd.oop.game.GameObject;

public class BarState extends State {

    public BarState(GameObject g) {
        super(g);
    }
    @Override
    public void move(int x, int y) {
        g.setX(x);
    }
}
