package scene;

import display.Display;
import display.HUD;
import entities.CowEntity;
import player.Player;
import world.Tileset;
import world.TimeSystem;

import java.awt.*;

public class GameScene {

    private static final int TILE_PIXEL_SIZE = 64;

    private final TimeSystem timeSystem = new TimeSystem(TimeSystem.Month.September, 30, 2341);

    private Tileset tileset;
    private Player player;

    private CowEntity cowEntity;

    private HUD hud;

    public GameScene() {

        int targetWidth  = Math.ceilDiv(Display.DISPLAY_WIDTH, TILE_PIXEL_SIZE);
        int targetHeight = Math.ceilDiv(Display.DISPLAY_HEIGHT, TILE_PIXEL_SIZE);

        tileset = new Tileset(targetWidth, targetHeight, TILE_PIXEL_SIZE, TILE_PIXEL_SIZE);

        this.player = new Player();

        this.cowEntity = new CowEntity();
        this.cowEntity.init();

        this.hud = new HUD(this);
    }

    public void Update(float deltaTime) {

        player.Update(deltaTime);
        this.cowEntity.update(deltaTime);

    }

    public void Render(Graphics g) {
        tileset.RenderTiles(g);
        player.Render(g);
        cowEntity.render(g);
        hud.render(g);
    }

    public TimeSystem getTimeSystem() { return this.timeSystem; }

}
