/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Subject;
import model.Observer;
import model.GameController;
import controller.CircusWorld;
import model.HardLevel;
import model.EasyLevel;
import model.MediumLevel;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.Strategy;


/**
 *
 * @author Saad
 */

public class chooseAvatarWindow extends javax.swing.JFrame implements Observer{

    private Subject mainWindow;
    private String gameMode;
    private String difficultyLevel;
    private Strategy gameStrategy;
    private Options op;
    
    /**
     * Creates new form chooseAvatarWindow
     */
    public chooseAvatarWindow(String gameMode, String difficultyLevel) {
        initComponents();
        this.gameMode = gameMode;
        this.difficultyLevel = difficultyLevel;
        op = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    @Override
    public void update() {
        ((DifficultyLevel) mainWindow).setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void setSubject(Subject mainWindow) {
        this.mainWindow = mainWindow;   
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Choose an avatar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(102, 0, 0));
        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("       Choose Your Avatar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 320, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/clown1 (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 160, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/clown2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 190, 200));

        jRadioButton1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Avatar 1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 110, 50));

        jRadioButton2.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Avatar 2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 110, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/back-button (2).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));
        jButton1.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/avat1 (1).png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        setSize(new java.awt.Dimension(1014, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Pause Game");
//        JMenuItem pauseMenuItem = new JMenuItem("Pause");
//        menu.addSeparator();
//        menu.add(pauseMenuItem);
//        menuBar.add(menu);
             
        if(difficultyLevel.equals("easy")) {
            gameStrategy = new EasyLevel();
        }
        else  if(difficultyLevel.equals("med")) {  
            gameStrategy = new MediumLevel();
        }
        else  if(difficultyLevel.equals("hard")) {
            gameStrategy = new HardLevel();
        }
        
        GameController gameController = new GameController(() ->  new CircusWorld(800, 500,gameStrategy,gameMode,"/clown.png"));
        gameController.start();
        
//        final GameEngine.GameController gameController = GameEngine.start("Hello", new CircusWorld(800, 500,gameStrategy,gameMode,"/clown.png"), menuBar, Color.white);
//        pauseMenuItem.addActionListener((ActionEvent e) -> {
//            gameController.pause();
//            op = new Options(gameController,gameMode,gameStrategy,"/clown.png");
//            op.setVisible(true);
//        });
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Pause Game");
//        JMenuItem pauseMenuItem = new JMenuItem("Pause");
//        menu.addSeparator();
//        menu.add(pauseMenuItem);
//        menuBar.add(menu);
             
        if(difficultyLevel.equals("easy")) {
            gameStrategy = new EasyLevel();
        }
        else  if(difficultyLevel.equals("med")) {  
            gameStrategy = new MediumLevel();
        }
        else  if(difficultyLevel.equals("hard")) {
            gameStrategy = new HardLevel();
        }
        
        GameController gameController = new GameController(() -> new CircusWorld(800, 500, gameStrategy, gameMode, "/clowng.png"));
        gameController.start();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        ((DifficultyLevel) mainWindow).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ((DifficultyLevel) mainWindow).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(chooseAvatarWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(chooseAvatarWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(chooseAvatarWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(chooseAvatarWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new chooseAvatarWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
