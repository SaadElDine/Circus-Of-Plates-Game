package model;
import controller.BarState;
import controller.State;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.ImageObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ranaz
 */
public abstract class Shape implements GameObject{
     private static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private boolean visible;
    private int type;//0 moving 1 leftstack 2 rightstack
    private boolean horizontalOnly;
    private ImageObject c;
    private String path;
    private int LeftOrRightBar;//0 Leftup 1 rightup 2lowerleft 3lowerright
    private State currentstState;
    private String Color ;

    public Shape(int x, int y, String path, int type) {
       this.x = x;
        this.y = y;
        this.type = type;
        this.visible = true;
        this.path = path;
        this.currentstState = new BarState((GameObject) this);
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
        }
    }
    
 @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        switch (type) {
            case 1:
                this.x = c.getX();
                break;
            case 2:
                this.x =c.getX()+ c.getWidth()-60;
                break;
            default:
                this.x = mX;
                break;
        }
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        if (!horizontalOnly) {
            this.y = mY;
        }
    }
     @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
     public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    

    public void setClown(ImageObject c) {
        this.c = c;
    }
     public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
     public boolean isHorizontalOnly() {
        return horizontalOnly;
    }

    public void setHorizontalOnly(boolean horizontalOnly) {
        this.horizontalOnly = horizontalOnly;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

   

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public State getCurrentstState() {
        return currentstState;
    }

    public void setCurrentstState(State currentstState) {
        this.currentstState = currentstState;
    }

    public int getLeftOrRightBar() {
        return LeftOrRightBar;
    }

    public void setLeftOrRightBar(int LeftOrRightBar) {
        this.LeftOrRightBar = LeftOrRightBar;
    }
 
}
