/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package renzettialessandrozoltarclient;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author renze
 */
public class RenzettiAlessandroZoltarClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new FrameZoltar().setVisible(true));
    }
    
}


