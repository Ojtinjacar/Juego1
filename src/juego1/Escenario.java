/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author oscar
 */
public class Escenario extends JPanel implements ActionListener {

    private int Puntaje;
    private Timer timer;
    private int secuencia;
    private int secuencia1;
    private int x;
    private int y;
    private int xx;
    private int MovMuñ;
    private Image Fondo;
    private Image Piso;
    private Image MuñecoAnimacion;
    private Image MuñecoMalo;
    private Image Piedra;
    private Roca[] piedra;
    private Muñeco Jessica;
    private int MovPiedra;
    private Fondo fondo;
    private Nube nube;
    private Piso[] piso;
    private Moneda moneda;
    private Font fuente;

    public Escenario() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
        Fondo = cargarimagen("blue_background.png");
        Piso = cargarimagen("ground_loop.png");
        MuñecoMalo = cargarimagen("enemy_run.png");
        this.fondo = new Fondo(0, 0);
        this.nube = new Nube(700, 10);
        this.piedra = new Roca[2];
        this.piedra[0] = new Roca(600, 550);
        this.piedra[1] = new Roca(900, 355);
        this.piso = new Piso[2];
        this.piso[0] = new Piso(600, 534);
        this.piso[1] = new Piso(0, 640);
        this.Jessica = new Muñeco(0, 500);
        this.moneda = new Moneda(805, 550, 55, 55);
    }

    public void Piedra(Graphics p) {
        Piedra = cargarimagen("stone.png");
        for (int i = 0; i < piedra.length; i++) {
            p.drawImage(Piedra, piedra[i].getX(), piedra[i].getY(), this);
            // p.drawRect(piedra[i].getX(), piedra[i].getY(), piedra[i].getAncho(), piedra[i].getAlto());

        }

    }

    public void MuñecoCorriendo(Graphics g) {
        MuñecoAnimacion = cargarimagen("walking.png");
        Image MuñecoSalta = cargarimagen("jump.png");

        if (Jessica.getY() > 400) {
            g.drawImage(MuñecoAnimacion, MovPiedra + Jessica.getX(), Jessica.getY(), MovPiedra + 115 + Jessica.getX(), Jessica.getY() + 134, (this.secuencia * 115), 0, (this.secuencia * 115) + 115, 134, this);
           g.drawRect(MovPiedra + Jessica.getX(), Jessica.getY(), 115, 134);
        } else if (Jessica.getY() > 300) {
            g.drawImage(MuñecoSalta, Jessica.getX(), Jessica.getY(), this);
           g.drawRect(MovPiedra + Jessica.getX(), Jessica.getY(), 115, 134);
        }
    }

    public void PisoFondo(Graphics g) {
        int Pox = 0;
        Pox = piso[1].getX();
        while (Pox < 1001) {
            g.drawImage(Piso, Pox, piso[1].getY(), this);

            Pox += 112;
        }
    }

    public void Fondo(Graphics g) {
        Image Nubes1 = cargarimagen("Nubes1.png");
        int Pox = 0;
        Pox = fondo.getX();
        while (Pox < 1001) {
            g.drawImage(Fondo, Pox, fondo.getY(), this);

            Pox += 22;
        }
        g.drawImage(Nubes1, nube.getX() - Jessica.getX(), nube.getY(), this);

    }

    public void Piso(Graphics g) {

        g.drawImage(Piso, piso[0].getX(), piso[0].getY(), this);
     //   g.drawRect(piso[0].getX(), piso[0].getY(), piso[0].getAncho(), piso[0].getAlto());
    }

    public void Moneda(Graphics g) {
        Image coin = cargarimagen("coin.png");
        g.drawImage(coin, moneda.getX(), moneda.getY(), this);
      g.drawRect(moneda.getX(), moneda.getY(), 55, 55);
    }

    public void CheckCollisions() {
        int Guarda = 0;
        Guarda = nube.getX() - Jessica.getX();
        Rectangle rMuñeco = Jessica.getBounds();
        Rectangle[] rPiedra = new Rectangle[piedra.length];
        Rectangle[] rPiso = new Rectangle[piso.length];
        Rectangle rMoneda = moneda.getBounds();

        for (int i = 0; i < rPiedra.length; i++) {
           rPiedra[i] = piedra[i].getBounds();
                 if (rPiedra[i].intersects(Jessica.getBounds())) {
                   Jessica.setX(0);
                 nube.setX(Guarda);
           }
        }
        for (int i = 0; i < rPiso.length; i++) {
            rPiso[0] = piso[0].getBounds();
            if (rMuñeco.intersectsLine(rPiso[0].getX(), rPiso[0].getY(), 50 + rPiso[0].getX(), rPiso[0].getY())) {
                Jessica.setY((int) rPiso[0].getY() - 130);

            }
        }
        if (rMuñeco.intersectsLine(rMoneda.getX(), rMoneda.getY(),rMoneda.getX()+55, rMoneda.getY())) {
            System.out.println("colision");
            this.moneda = new Moneda(300, 550, 55, 55);
            Puntaje++;
            if (Puntaje == 2) {
                timer.stop();

            }
        }

    }

    @Override

    protected void paintComponent(Graphics Grafico) {
        super.paintComponent(Grafico);
        Fondo(Grafico);
        PisoFondo(Grafico);
        Moneda(Grafico);
        MuñecoCorriendo(Grafico);
        Piedra(Grafico);
        Piso(Grafico);
        fuente = new Font("Arial", Font.BOLD, 60);
        Grafico.setFont(fuente);
        Grafico.drawString("Puntaje:" + Puntaje, 600, 200);
        System.out.println(Puntaje);

    }

    public Image cargarimagen(String imagen) {
        ImageIcon aaaaa = new ImageIcon(imagen);
        Image image = aaaaa.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Jessica.move();
        nube.move();
        CheckCollisions();
        for (int i = 0; i < piedra.length; i++) {
            piedra[i].move();
        }
        if (this.secuencia == 3) {

            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        if (this.secuencia1 == 1) {

            this.secuencia1 = 0;
        } else {
            this.secuencia1++;

        }
        repaint();

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            Jessica.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            Jessica.keyPressed(e);
        }
    }

}
