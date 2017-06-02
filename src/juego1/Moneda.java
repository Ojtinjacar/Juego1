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
public class Moneda extends MuñecoGeneral {

    private int alto;
    private int ancho;

    public Moneda(int x, int y, int alto, int ancho) {
        super(x, y);
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getAlto(), getAncho());
    }
}
