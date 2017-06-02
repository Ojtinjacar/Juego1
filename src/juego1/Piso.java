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
public class Piso extends MuñecoGeneral {

    private final int ancho = 112;
    private final int alto = 68;

    public Piso(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void mover() {

    }
        public void getXY(){
            x=getX();
            y=getY();
        }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 112, 68);
    }

}
