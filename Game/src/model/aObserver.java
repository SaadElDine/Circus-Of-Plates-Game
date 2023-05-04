/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.CircusWorld;



/**
 *
 * @author Saif
 */
public abstract  class aObserver implements Observer{
    protected CircusWorld w ;
    public abstract void update();
}
