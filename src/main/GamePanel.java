package main;

import input.KeyHandler;
import tile.TileManager;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int TILE_SIZE = 32;
    public final int SCREEN_WIDTH = TILE_SIZE * 20;
    public final int SCREEN_HEIGHT = TILE_SIZE * 15;

    int playerX = 100, playerY = 100, speed = 4;

    TileManager tileManager;
    KeyHandler keyHandler;
    Thread gameThread;
    Player player;

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
        tileManager = new TileManager(this);
        player = new Player(this, keyHandler);
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
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);
        player.draw(g2);
    }
}