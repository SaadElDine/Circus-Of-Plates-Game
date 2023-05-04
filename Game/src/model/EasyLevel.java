package model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ranaz
 */
public class EasyLevel implements Strategy {
    @Override
     public int getSpeed(){
         return 1;
     }

     @Override
    public int getTimeout(){
        return 3;
    }
}
