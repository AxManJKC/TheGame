package main;

import javax.swing.*;

public class Game {
    public Game() {
        JFrame frame = new JFrame("Movement Test");
        GamePanel panel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.startGame();
    }
}