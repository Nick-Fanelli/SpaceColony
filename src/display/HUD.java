package display;

import scene.GameScene;
import sprite.Sprite;
import world.TimeSystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Time;

public class HUD {

    private final Sprite hud = new Sprite("/images/hud.png");

    private final GameScene gameScene;

    public HUD(GameScene gameScene) {
        this.gameScene = gameScene;

        hud.init();
    }

    public void update(float deltaTime) {

    }

    public void render(Graphics g) {
        g.drawImage(hud.getBufferedImage(), 0, 0, 1280, 720, null);



        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString(gameScene.getTimeSystem().getFormattedDate(), 10,700);

    }


}
