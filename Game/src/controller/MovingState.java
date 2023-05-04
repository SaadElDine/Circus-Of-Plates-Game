package controller;
import eg.edu.alexu.csd.oop.game.GameObject;

public class MovingState extends State {

    public MovingState(GameObject g) {
        super(g);
    }
    @Override
    public void move(int x, int y) {
        g.setX(x);
        g.setY(y);
    }
}
