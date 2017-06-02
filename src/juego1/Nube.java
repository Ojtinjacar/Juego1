/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego1;

/**
 *
 * @author oscar
 */
public class Nube extends MuñecoGeneral {

    public Nube(int x, int y) {
        super(x, y);
    }

    public void move() {
        y = getY();
        x = getX();
        if (getX() < 0) {
            x = 700;
        }
    }
}
