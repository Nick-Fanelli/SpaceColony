package scene;

import display.Display;
import display.Input;
import player.Player;
import world.Tileset;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene {

    private static final int TILE_PIXEL_SIZE = 128;

    private Tileset tileset;
    private Player player;

    public GameScene() {

        int targetWidth  = Math.ceilDiv(Display.DISPLAY_WIDTH, TILE_PIXEL_SIZE);
        int targetHeight = Math.ceilDiv(Display.DISPLAY_HEIGHT, TILE_PIXEL_SIZE);

        tileset = new Tileset(targetWidth, targetHeight, TILE_PIXEL_SIZE, TILE_PIXEL_SIZE);

        this.player = new Player();
    }

    public void Update(float deltaTime) {

        player.Update(deltaTime);

    }

    public void Render(Graphics g) {
        tileset.RenderTiles(g);
        player.Render(g);
    }

}
