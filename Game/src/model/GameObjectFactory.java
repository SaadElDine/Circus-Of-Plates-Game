package model;
import eg.edu.alexu.csd.oop.game.GameObject;


public class GameObjectFactory {
    int Random;

    private static GameObjectFactory shapeFactory ;

    private GameObjectFactory() {

    }
//factory is Singlton
    public static GameObjectFactory getInstance() {
        if (shapeFactory == null) {
            shapeFactory = new GameObjectFactory();
        }
        return shapeFactory;
    }

    public GameObject getShape(String name, int x, int y) {
        if (name == null) {
            return null;
        }
        switch (name) {
            case "plate":
                Random=((int) (Math.random() * 1000) % 5 + 1);
                PlateObject p= new PlateObject(x, y, "/plate" + Random + ".png");
                
            switch (Random) {
                case 1 -> p.setColor("Red");
                case 2 -> p.setColor("Blue");
                case 3 -> p.setColor("Green");
                case 4 -> p.setColor("MintGreen");
                default -> p.setColor("Yellow");
            }
            return p;
                        
            case "Bomb":
                BombObject b=new BombObject(x, y, "/Bomb.png");
                b.setColor("Black");
                return b;
            case "Pikachu":
                pikachuObject pika= new pikachuObject(x, y, "/pika.png");
                pika.setColor("Yellow");
                return pika;
            default:
                break;
        }
        return null;
    }
}
