package sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Sprite {

    private final String resourcePath;

    private BufferedImage bufferedImage;

    public Sprite(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void init() {

        try {
            this.bufferedImage = ImageIO.read(Objects.requireNonNull(Sprite.class.getResourceAsStream(this.resourcePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public BufferedImage getBufferedImage() { return this.bufferedImage; }

}