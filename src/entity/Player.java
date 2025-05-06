package entity;

import input.KeyHandler;
import main.GamePanel;

import java.awt.*;

public class Player {

    GamePanel gp;
    KeyHandler keyH;

    public int x, y;
    int speed;


    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {

        if (keyH.up) y -= speed;
        if (keyH.down) y += speed;
        if (keyH.left) x -= speed;
        if (keyH.right) x += speed;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, gp.TILE_SIZE, gp.TILE_SIZE);
    }
}
