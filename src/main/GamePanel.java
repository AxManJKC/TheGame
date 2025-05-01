package main;

import input.KeyHandler;

import javax.swing.JPanel;
import java.awt.*;
public class GamePanel extends JPanel implements Runnable {


    //Screen settings
    final int TILE_SIZE = 32;
    final int SCREEN_COLS = 20;
    final int SCREEN_ROWS = 15;
    final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;
    final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;

    Thread gameThread;
    int FPS = 60;

    //Player position
    public int playerX = 100;
    public int playerY = 100;
    public int playerSpeed = 4;

    KeyHandler keyHandler = new KeyHandler();

    public GamePanel() {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
    }

    public void startGameLoop() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.00 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }

    }

    public void update() {

        

    }

}
