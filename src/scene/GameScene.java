package scene;

import display.Display;
import world.Tileset;

import java.awt.*;

public class GameScene {

    private static final int TILE_PIXEL_SIZE = 64;

    private Tileset tileset;

    public GameScene() {

        int targetWidth  = Math.ceilDiv(Display.DISPLAY_WIDTH, TILE_PIXEL_SIZE);
        int targetHeight = Math.ceilDiv(Display.DISPLAY_HEIGHT, TILE_PIXEL_SIZE);

        tileset = new Tileset(targetWidth, targetHeight, TILE_PIXEL_SIZE, TILE_PIXEL_SIZE);
    }

    public void Update(float deltaTime) {

    }

    public void Render(Graphics g) {
        tileset.RenderTiles(g);
    }

}
