package player;

import display.Input;
import utils.Vector2f;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public static final float PLAYER_SPEED = 200.0f;

    public Vector2f position = new Vector2f();

    private Vector2f deltaPosition = new Vector2f();

    public void Update(float deltaTime) {

        deltaPosition.clear();

        if(Input.isKey(KeyEvent.VK_UP)) {
            deltaPosition.y -= PLAYER_SPEED;
        }

        if(Input.isKey(KeyEvent.VK_DOWN)) {
            deltaPosition.y += PLAYER_SPEED;
        }

        if(Input.isKey(KeyEvent.VK_LEFT)) {
            deltaPosition.x -= PLAYER_SPEED;
        }

        if(Input.isKey(KeyEvent.VK_RIGHT)) {
            deltaPosition.x += PLAYER_SPEED;
        }

        deltaPosition.x *= deltaTime;
        deltaPosition.y *= deltaTime;

        this.position.add(deltaPosition);
    }

    public void Render(Graphics g) {

        g.setColor(new Color(0x00CCCC));
        g.fillRect((int) position.x, (int) position.y, 32, 32);

    }

}
