/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego1;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author oscar
 */
public class Muñeco extends MuñecoGeneral {

    private int dx;
    private int dy;
    private int velocidad;

    public Muñeco(int x, int y) {
        super(x, y);
    }

    public void move() {
        y = 500;
        x += dx;
        y += dy;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            dx = -30;

        }

        if (key == KeyEvent.VK_F) {
            dx = 30;

        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -5;

        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;

        }

        if (key == KeyEvent.VK_SPACE) {
            dy = -100;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_SPACE) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
       if (key == KeyEvent.VK_D) {
            dx = 0;

        }

        if (key == KeyEvent.VK_F) {
            dx = 0;

        }

    }

    public void getXY() {
        x = getX();
        y = getY();
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 115, 134);
    }
}
