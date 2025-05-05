package main;

import input.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int TILE_SIZE = 32;
    final int SCREEN_WIDTH = TILE_SIZE * 20;
    final int SCREEN_HEIGHT = TILE_SIZE * 15;

    int playerX = 100, playerY = 100, speed = 4;

    KeyHandler keyHandler;
    Thread gameThread;

    public GamePanel(KeyHandler kh) {
        this.keyHandler = kh;
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(keyHandler);
        requestFocusInWindow();
    }

    public void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (true) {
            update();
            repaint();
            try { Thread.sleep(16); } catch (Exception ignored) {}
        }
    }

    public void update() {
        if (keyHandler.up) playerY -= speed;
        if (keyHandler.down) playerY += speed;
        if (keyHandler.left) playerX -= speed;
        if (keyHandler.right) playerX += speed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
    }
}