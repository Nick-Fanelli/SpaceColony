package entities;

import sprite.Sprite;
import utils.Vector2f;

import java.awt.*;

public class CowEntity extends Entity {

    private static final Sprite COW_SPRITE = new Sprite("/images/cow.png");

    public CowEntity() {
        this.position = new Vector2f(50, 50);
        this.scale = new Vector2f(64, 64);
    }

    @Override
    public void init() {

        CowEntity.COW_SPRITE.init();

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(COW_SPRITE.getBufferedImage(), (int) position.x, (int) position.y, (int) scale.x, (int) scale.y, null);

    }

}
