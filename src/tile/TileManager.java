package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tiles;
    public int[][] mapTileNum;

    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tiles = new Tile[10];

        getTileImage();
        mapTileNum = new int[gp.MAX_WORLD_ROW][gp.MAX_WORLD_ROW];
        laodMap("/maps/map01");

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

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            while (row < gp.MAX_WORLD_ROW) {
                String line  = br.readLine();
                String[] numbers = line.split(" ");

                for(int col = 0; col < go.MAX_WORLD_COL; col++) {

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            br.close();
        } catch (Exception e){
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
            for (int y = 0; col < mapTileNum[0].length; y++) {
                int tileNum = mapTileNum[x][y];

                int x = col * gp.TILE_SIZE;
                int y = col * gp.TILE_SIZE;

                g2.drawImage(tiles[tileNum].image, x, y, gp.TILE_SIZE, gp.TILE_SIZE, null);
            }
        }
    }
}
