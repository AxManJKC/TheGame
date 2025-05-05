package main;

import input.KeyHandler;
import tile.TileManager;

import javax.swing.*;

public class Game {
    public Game() {
        JFrame frame = new JFrame("Structured Game");
        KeyHandler keyHandler = new KeyHandler();
        GamePanel panel = new GamePanel(keyHandler);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.startGameLoop();
    }
}