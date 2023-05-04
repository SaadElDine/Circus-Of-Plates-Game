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
public class scoreObserver extends aObserver  {

    public scoreObserver(CircusWorld w) {
        super.w = w;
    }

    @Override
    public void update() {
        w.setScore(w.getScore()+1);
    }

    @Override
    public void setSubject(Subject subject) {
        super.w = (CircusWorld) w; 
    }    
}
