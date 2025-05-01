package main;

import javax.swing.JFrame;

public class Game {
    public Game() {
        JFrame frame = new JFrame("The Game");
        GamePanel panel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.startGameLoop();
    }
}
