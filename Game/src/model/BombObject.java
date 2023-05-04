package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ranaz
 */
public class BombObject extends Shape  {
 

   
    

    public BombObject(int posX, int posY, String path) {
        super(posX, posY, path, 0);
    }

   
    public BombObject(int posX, int posY, String path, int type) {
       super(posX, posY, path, type);
    }

}

   
