import display.Display;
import scene.GameScene;

import java.awt.*;

public class Main {

    private static final double UPDATE_CAP = 1.0 / 60.0;

    public static void main(String[] args) {

        new Main().StartGameLoop();

    }

    private final GameScene gameScene = new GameScene();

    private Display display;
    private boolean isRunning = true;

    private void StartGameLoop() {

        this.display = new Display();
        this.display.CreateFrame();

        boolean shouldDraw = false;

        double currentUpdateTime;
        double lastUpdateTime = System.nanoTime() / 1000000000.0;
        double deltaTime = 0;

        double firstTime, passedTime;
        double lastTime = System.nanoTime() / 1000000000.0;
        double updateTime = 0;

        while(isRunning) {

            shouldDraw = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            updateTime += passedTime;

            while(updateTime >= UPDATE_CAP) {
                updateTime -= UPDATE_CAP;
                shouldDraw = true;

                // Calculate Delta Time
                currentUpdateTime = System.nanoTime() / 1000000000.0;
                deltaTime = currentUpdateTime - lastUpdateTime;
                lastUpdateTime = currentUpdateTime;

                update((float) deltaTime);
            }

            if(shouldDraw) {
                drawToScreen();
                draw();
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void update(float deltaTime) {
        gameScene.Update(deltaTime);
    }

    private void draw() {
        Graphics g = display.getDrawGraphics();
        gameScene.Render(g);
    }

    private void drawToScreen() {
        this.display.update();
    }

}