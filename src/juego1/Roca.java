/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego1;

import java.awt.Rectangle;

/**
 *
 * @author oscar
 */
public class Roca extends MuñecoGeneral {
    private final int ancho=65;
    private final int alto=59;

    public Roca(int x, int y) {
        super(x, y);
    }

    public void move() {
        y = getY();
        x = getX();
        x-=80;
        if (x <0) {
            x = 1100;
        }
    }

    public int getAncho() {
        return ancho;
    }


    public int getAlto() {
        return alto;
    }

   

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 65,59);
    }
}
