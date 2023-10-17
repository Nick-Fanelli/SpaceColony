package world;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class MoonTile extends Tile {

    private static final BufferedImage moonTileImage;

    static {
        try {
            moonTileImage = ImageIO.read(Objects.requireNonNull(MoonTile.class.getResourceAsStream("/images/moontile.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final int rand;

    public MoonTile() {
        rand = (int) (Math.random() * 10);
    }

    @Override
    public void Draw(Graphics g, int x, int y, int tileWidth, int tileHeight) {

        if(rand == 1) { // Detail One
            g.setColor(Color.BLUE);
            g.fillRect(x, y, tileWidth, tileHeight);
        } else if(rand == 2) { // Detail two
            g.setColor(Color.GREEN);
            g.fillRect(x, y, tileWidth, tileHeight);
        } else { // Standard
            g.drawImage(moonTileImage, x, y, tileWidth, tileHeight, null);
        }

    }

}
