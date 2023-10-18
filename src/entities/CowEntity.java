package entities;

import sprite.Sprite;
import utils.Vector2f;

import java.awt.*;

public class CowEntity extends Entity {

    private Sprite cowSprite = new Sprite("/images/cow.png");

    public CowEntity() {
        this.position = new Vector2f(50, 50);
        this.scale = new Vector2f(128, 128);
    }

    @Override
    public void init() {

        this.cowSprite.init();

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(cowSprite.getBufferedImage(), (int) position.x, (int) position.y, (int) scale.x, (int) scale.y, null);

    }

}
