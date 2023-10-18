package world;

import sprite.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class MoonTile extends Tile {

    private static final Sprite moonTileSprite = new Sprite("/images/moontile.png");

    static {
        moonTileSprite.init();
    }

    private final int rand;

    public MoonTile() {
        rand = (int) (Math.random() * 4);
    }

    @Override
    public void Draw(Graphics g, int x, int y, int tileWidth, int tileHeight) {

        g.drawImage(moonTileSprite.getBufferedImage(), x, y, tileWidth, tileHeight, null);

    }

//    private static BufferedImage rotate(int degrees) {
//        // Getting Dimensions of image
//        int width = moonTileSprite.getWidth();
//        int height = moonTileSprite.getHeight();
//
//        // Creating a new buffered image
//        BufferedImage newImage = new BufferedImage(
//                moonTileSprite.getWidth(), moonTileImage.getHeight(), moonTileImage.getType());
//
//        // creating Graphics in buffered image
//        Graphics2D g2 = newImage.createGraphics();
//
//        // Rotating image by degrees using toradians()
//        // method
//        // and setting new dimension t it
//        g2.rotate(Math.toRadians(degrees), width / 2,
//                height / 2);
//        g2.drawImage(moonTileImage, null, 0, 0);
//
//        // Return rotated buffer image
//        return newImage;
//    }

}
