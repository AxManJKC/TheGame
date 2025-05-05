package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    GamePanel gp;
    public Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tiles = new Tile[10];
        mapTileNum = new int[gp.SCREEN_WIDTH / gp.TILE_SIZE][gp.SCREEN_HEIGHT / gp.TILE_SIZE];

        loadTileImages();
        generateSampleMap();
    }

    public void loadTileImages() {

        try {
            tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/DemoGrass.png")), false);
            tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/tiles/DemoWall.png")), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateSampleMap() {
        for (int x = 0; x< mapTileNum.length; x++) {
            for (int y = 0; y < mapTileNum[0].length; y++) {
                if (x == 0 || y == 0 || x == mapTileNum.length - 1 || y == mapTileNum[0].length - 1) {
                    mapTileNum[x][y] = 1;
                } else {
                    mapTileNum[x][y] = 0;
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        for (int x = 0; x < mapTileNum.length; x++) {
            for (int y = 0; y < mapTileNum[0].length; y++) {
                int tileNum = mapTileNum[x][y];
                int drawX = x * gp.TILE_SIZE;
                int drawY = y * gp.TILE_SIZE;

                g2.drawImage(tiles[tileNum].image, drawX, drawY, gp.TILE_SIZE, gp.TILE_SIZE, null);
            }
        }
    }
}
