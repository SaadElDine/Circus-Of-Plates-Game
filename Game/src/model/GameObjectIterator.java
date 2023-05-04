package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

public class GameObjectIterator implements Iterator<GameObject> {

    private int index = 0;
    List<GameObject> x;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<GameObject> getX() {
        return x;
    }

    public void setX(List<GameObject> x) {
        this.x = x;
    }

    public GameObjectIterator(List<GameObject> x) {
        this.x = x;
    }

    @Override
    public boolean hasNext() {
        if (index < x.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GameObject next() {
        return x.get(index);
    }
}
