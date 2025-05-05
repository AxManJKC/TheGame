package tile;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Tile {
    public BufferedImage image;
    public boolean collision = false;

    public Tile(BufferedImage image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }
}
