package sprite;

import javax.imageio.ImageIO;
import java.awt.*;
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

        BufferedImage tempBufferedImage;

        try {
            tempBufferedImage = ImageIO.read(Objects.requireNonNull(Sprite.class.getResourceAsStream(this.resourcePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(tempBufferedImage == null) {
            return;
        }

        BufferedImage alphaBufferedImage = new BufferedImage(tempBufferedImage.getWidth(), tempBufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

        replaceAlphas(tempBufferedImage, alphaBufferedImage);

        this.bufferedImage = alphaBufferedImage;


    }

    private static final Color PINK_COLOR = new Color(0xff00ff);

    private void replaceAlphas(BufferedImage srcImage, BufferedImage targetImage) {

        for(int y = 0; y < srcImage.getHeight(); y++) {

            for(int x = 0; x < srcImage.getWidth(); x++) {

                int color = srcImage.getRGB(x, y);

                if(color == PINK_COLOR.getRGB()) {

                    // Replace Color to transparent
                    targetImage.setRGB(x, y, 0x00000000);

                } else {
                    targetImage.setRGB(x, y, color);
                }

            }

        }

    }

    public BufferedImage getBufferedImage() { return this.bufferedImage; }

}