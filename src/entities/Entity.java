package entities;

import utils.Vector2f;

import java.awt.*;

public abstract class Entity {

    public Vector2f position = new Vector2f();
    public Vector2f scale = new Vector2f();

    public abstract void init();
    public abstract void update(float deltaTime);
    public abstract void render(Graphics g);

}
