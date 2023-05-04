package controller;

import model.scoreObserver;
import model.Shape;
import model.GameObjectFactory;
import model.Strategy;
import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import model.BarObject;
import model.BombObject;
import model.ImageObject;
import model.PlateObject;
import model.pikachuObject;
import model.aObserver;
import model.Subject;
import model.GameObjectIterator;
import model.Observer;

public class CircusWorld implements World, Subject {

    private final int MAX_TIME;	
    private int score = 0;
    private final long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private String gameMode;
    private String clown;
    private Strategy gameStrategy;
    GameObjectFactory shapeFactory;
    private Shape gameObject;
    private int j = 0;
    private int k = 0;
    private int L = 0;
    private int M = 0;
    //creating lists 
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private List<GameObject> left = new LinkedList<GameObject>();
    private List<GameObject> right = new LinkedList<GameObject>();

    List<aObserver> observers;

    void attach(aObserver o) {
        observers.add(o);
    }

    void detach(aObserver o) {
        observers.remove(o);
    }

    void notifyallObservers() {
        for (aObserver obj : observers) {
            obj.update();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //GameObjectIterator movingIterator;
    public CircusWorld(int WidthOfScreen, int HeightOfScreen, Strategy gameStrategy, String gameMode, String clown) {

        int i;
        observers = new ArrayList<aObserver>();
        attach(new scoreObserver(this));
        shapeFactory = GameObjectFactory.getInstance();
        this.gameMode = gameMode;
        this.clown = clown;
        this.gameStrategy = gameStrategy;
        width = WidthOfScreen;
        height = HeightOfScreen;
        this.MAX_TIME = (gameStrategy.getTimeout())* 60 * 1000;

        constant.add(new ImageObject(0, 0, "/" + this.gameMode + ".png"));
        control.add(new ImageObject(WidthOfScreen / 3, (int) (HeightOfScreen * 0.6), this.clown));
        constant.add(new BarObject(0, 50, 250, true, Color.BLACK));
        constant.add(new BarObject(width - 250, 50, 250, true, Color.BLACK));
        constant.add(new BarObject(0, 100, 150, true, Color.BLACK));
        constant.add(new BarObject(width - 150, 100, 150, true, Color.BLACK));

        //Moving plate objects
        for (i = 0; i < 10; i++) {
            int r =new Random().nextInt(2);
            if(r==0)
            moving.add(shapeFactory.getShape("plate", -70 *  i, 43));
            else 
            moving.add(shapeFactory.getShape("Pikachu", -70 * i, 25));
           
            r =new Random().nextInt(2);
            if (r==0){

            PlateObject p2 = (PlateObject) shapeFactory.getShape("plate", -70 *  i, 93);
            p2.setLeftOrRightBar(2);
            moving.add(p2);
            }
            else{
             pikachuObject k2 = (pikachuObject) shapeFactory.getShape("Pikachu", -70 *  i, 75);
            k2.setLeftOrRightBar(2);
            moving.add(k2);
            }
            
            r =new Random().nextInt(2);
            if(r==0){
            PlateObject p1 = (PlateObject) shapeFactory.getShape("plate", width + 70 *  i, 43);
            p1.setLeftOrRightBar(1);
            moving.add(p1);
            }
            else{
                pikachuObject k1 = (pikachuObject) shapeFactory.getShape("Pikachu", width + 70  * i, 25);
            k1.setLeftOrRightBar(1);
            moving.add(k1);

            }
            r =new Random().nextInt(2);
            if (r==0){
            PlateObject p3 = (PlateObject) shapeFactory.getShape("plate", width + 70 *  i, 93);
            p3.setLeftOrRightBar(3);
            moving.add(p3);
            }
            else{
                 pikachuObject k3 = (pikachuObject) shapeFactory.getShape("Pikachu", width + 70 * i, 75);
                k3.setLeftOrRightBar(3);
                
                moving.add(k3);
            }
        }
        j=i;
        k=i;
        L=i;
        M=i;
        //Moving Bomb objects
        for (i = 0; i < 1; i++) {
            moving.add(shapeFactory.getShape("Bomb", -70 * j, 25));
        j++;
        }
    }
// Intersect Method checks if two shapes interseced  

    private boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth()) && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
    }
//

    private boolean gameObjectIntersected(Shape gameObject, int type) {
        GameObject clown = control.get(0);

        moving.remove(gameObject);
        gameObject.setClown((ImageObject) clown);
        gameObject.setHorizontalOnly(true);
        gameObject.setType(type);

        if (gameObject instanceof BombObject) {
            if (score >= 1) {
                score = score - 1;
            } else {
                constant.add(new ImageObject(0, 0, "/g1.JPG"));
                moving.clear();
                return false;
            }
        } else {
            control.add(gameObject);
            if (type == 1) {
                left.add(gameObject);
            }
            if (type == 2) {
                right.add(gameObject);
            }
        }
        return true;
    }

//Reuse objects out of frame
    private void reuseObjects(Shape gameObject, int flag) {
        switch (flag) {
            // falls from upper left bar
            case 0 -> {
                gameObject.setX(-70 * j);
                gameObject.setY(50 - gameObject.getHeight());
                j += 1;
            }
            // falls from upper right bar
            case 1 -> {
                gameObject.setX(width + 70 * k);
                gameObject.setY(50 - gameObject.getHeight());
                k += 1;
            }
            //falls from lower left bar
            case 2 -> {
                gameObject.setX(-70 * L);
                gameObject.setY(100 - gameObject.getHeight());
                L += 1;
            }
            //falls from lower right bar
            default -> {
                gameObject.setX(width + 70 * M);
                gameObject.setY(100 - gameObject.getHeight());
                M += 1;
            }
        }

        moving.add(gameObject);

    }
//Start Moving Shapes

    private void movingStarts(Shape gameObject, int flag) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        y = y + (int) (Math.random() * 1000) % 5;

        switch (flag) {
            case 0:
                x = x + gameStrategy.getSpeed();
                if (gameObject.getX() + 150 > width / 2) {
                    gameObject.setCurrentstState(new MovingState(gameObject));
                }
                break;
            case 2:
                x = x + gameStrategy.getSpeed();
                if (gameObject.getX() + 280 > width / 2) {
                    gameObject.setCurrentstState(new MovingState(gameObject));
                }
                break;
            case 1:
                x = x - gameStrategy.getSpeed();
                if (gameObject.getX() < width - 300) {
                    gameObject.setCurrentstState(new MovingState(gameObject));
                }
                break;
            case 3:
                x = x - gameStrategy.getSpeed();
                if (gameObject.getX() < width - 200) {
                    gameObject.setCurrentstState(new MovingState(gameObject));
                }
                break;
            default:
                break;
        }
        gameObject.getCurrentstState().move(x, y);
    }

    @Override
    public boolean refresh() {
        int flag;
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        GameObject Clown = control.get(0);
        GameObjectIterator iterator = new GameObjectIterator(moving);

        while (iterator.hasNext()) {

            GameObject m = iterator.next();
            gameObject = (Shape) m;

            // moving starts
            flag = gameObject.getLeftOrRightBar();
            movingStarts(gameObject, flag);

            //Checking Intersections Right
            if (right.isEmpty()) {
                if (clownIntersectright(gameObject)) {

                    if (!(gameObject instanceof BombObject)) {
                        gameObject.setY(Math.abs(Clown.getY() - m.getHeight()));
                    }
                    
                    if(!gameObjectIntersected(gameObject, 2)) {
                        return false;
                    }
                }
            } else {
                if (intersect(m, right.get(right.size() - 1))) {

                    if (!(gameObject instanceof BombObject)) {
                        gameObject.setY(Math.abs(right.get(right.size() - 1).getY() - gameObject.getHeight()));
                    }
                    if(!gameObjectIntersected(gameObject, 2)) {
                        return false;
                    }
                }
            }

            //Checking Intersections left
            if (left.isEmpty()) {
                if (clownIntersectleft(gameObject)) {

                    if (!(gameObject instanceof BombObject)) {
                        gameObject.setY(Math.abs(Clown.getY() - m.getHeight()));
                    }
                    if(!gameObjectIntersected(gameObject, 1)) {
                        return false;
                    }
                }
            } else {
                if (!(left.isEmpty()) && intersect(m, left.get(left.size() - 1))) {

                    if (!(gameObject instanceof BombObject)) {
                        gameObject.setY(Math.abs(left.get(left.size() - 1).getY() - gameObject.getHeight()));

                    }
                    if(!gameObjectIntersected(gameObject, 1)) {
                        return false;
                    }
                }
            }

            //Reusing objects out of frame
            if (m.getY() > height) {
                moving.remove(m);
                reuseObjects(gameObject, gameObject.getLeftOrRightBar());
                gameObject.setCurrentstState(new BarState(m));
            }

            //checking if 3 objects with same color intersected 
            updateLeft();
            updateRight();

            if (left.size() == 12) {
                constant.add(new ImageObject(0, 0, "/g1.JPG"));
                moving.clear();
                return false;
            }
            if (right.size() == 12) {
                constant.add(new ImageObject(0, 0, "/g1.JPG"));
                moving.clear();
                return false;
            }
            if (moving.isEmpty()) {
                constant.add(new ImageObject(0, 0, "/g1.JPG"));
                moving.clear();
                return false;
            }
            
            iterator.setIndex(iterator.getIndex() + 1);
           
        }
        
        if(timeout) {
            constant.add(new ImageObject(0, 0, "/g1.JPG"));
            moving.clear();
            
        }
        return !timeout;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);	// update status
    }

    private boolean clownIntersectleft(Shape gameObject) {
        ImageObject clown = (ImageObject) control.get(0);
        return (Math.abs(clown.getX() - gameObject.getX()) <= gameObject.getWidth() - 10
                && gameObject.getY() == control.get(0).getY() - 10);
    }

    private boolean clownIntersectright(Shape gameObject) {
        ImageObject clown = (ImageObject) control.get(0);
        return (Math.abs((clown.getX() + clown.getWidth() - 65) - gameObject.getX()) <= gameObject.getWidth() - 10
                && gameObject.getY() == control.get(0).getY() - 10);
    }

    private void updateLeft() {
        if (left.size() >= 3) {
            Shape p1 = (Shape) left.get(left.size() - 1);
            Shape p2 = (Shape) left.get(left.size() - 2);
            Shape p3 = (Shape) left.get(left.size() - 3);
            if (p1.getColor().equals(p2.getColor()) && p2.getColor().equals(p3.getColor())) {
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                this.notifyallObservers();
            }
        }
    }

    private void updateRight() {
        if (right.size() >= 3) {
            Shape p1 = (Shape) right.get(right.size() - 1);
            Shape p2 = (Shape) right.get(right.size() - 2);
            Shape p3 = (Shape) right.get(right.size() - 3);
            if (p1.getColor().equals(p2.getColor()) && p2.getColor().equals(p3.getColor())) {
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                this.notifyallObservers();
            }
        }
    }

    @Override
    public void notifyObserver(Observer observer) {
        observer.update();
    }
}
