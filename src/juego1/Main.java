/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego1;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author oscar
 */
public class  Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Juego");
        frame.setSize(1001, 768);
        frame.setLocationRelativeTo(null);
        Escenario juego = new Escenario();
       frame.add(juego);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        
    }
    
    

}
