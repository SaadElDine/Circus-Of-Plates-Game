//package view;
//
//import controller.CircusWorld;
//import controller.EasyStrategy;
//import eg.edu.alexu.csd.oop.game.GameEngine;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//
//public class Main {
//
//    public static void main(String[] args) {
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("File");
//        JMenuItem newMenuItem = new JMenuItem("New");
//        JMenuItem pauseMenuItem = new JMenuItem("Pause");
//        JMenuItem resumeMenuItem = new JMenuItem("Resume");
//        menu.add(newMenuItem);
//        menu.addSeparator();
//        menu.add(pauseMenuItem);
//        menu.add(resumeMenuItem);
//        menuBar.add(menu);
//        final GameEngine.GameController gameController = GameEngine.start("Hello", new CircusWorld(new EasyStrategy(), 800, 500), menuBar, Color.white);
//        newMenuItem.addActionListener((ActionEvent e) -> {
//            gameController.changeWorld(new CircusWorld(new EasyStrategy(), 800, 500));
//        });
//        pauseMenuItem.addActionListener((ActionEvent e) -> {
//            gameController.pause();
//        });
//        resumeMenuItem.addActionListener((ActionEvent e) -> {
//            gameController.resume();
//        });
//    }
//}
