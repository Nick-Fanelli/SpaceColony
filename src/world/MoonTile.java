package world;

import sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class MoonTile extends Tile {

    private static final Sprite moonTileSprite = new Sprite("/images/moontile.png");
    private static final Sprite moonTileOffsetSprite = new Sprite("/images/moontile-offset-1.png");

    static {
        moonTileSprite.init();
        moonTileOffsetSprite.init();
    }

    private final int rand;
    public boolean isClaimed = false;

    public MoonTile() {
        rand = (int) (Math.random() * 5);
    }

    @Override
    public void Draw(Graphics g, int x, int y, int tileWidth, int tileHeight) {

        if(rand <= 3)
            g.drawImage(moonTileSprite.getBufferedImage(), x, y, tileWidth, tileHeight, null);
        else
            g.drawImage(moonTileOffsetSprite.getBufferedImage(), x, y, tileWidth, tileHeight, null);

        if(!isClaimed) {
            g.setColor(new Color(0, 0, 0, 200));
            g.fillRect(x, y, tileWidth, tileHeight);
        }

    }

    private static final HashMap<Integer, BufferedImage> rotatedImages = new HashMap<>();
//
//    private static BufferedImage rotate(int degrees) {
//        if(rotatedImages.containsKey(degrees)) {
//
//        }
//
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
