package display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Display {

    public static final int DISPLAY_WIDTH = 1280;
    public static final int DISPLAY_HEIGHT = 720;

    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    private Dimension resolution;
    private Dimension scaledContext;

    public void CreateFrame() {

        resolution = new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        scaledContext = new Dimension(resolution.width, resolution.height);

        Dimension windowSize = new Dimension(scaledContext.width, scaledContext.height);

        image = new BufferedImage(windowSize.width, windowSize.height, BufferedImage.TYPE_INT_ARGB);

        canvas = new Canvas();
        canvas.setPreferredSize(windowSize);

        frame = new JFrame("Space Colony");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(scaledContext.width / 2, scaledContext.height / 2));

        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        frame.getContentPane().setIgnoreRepaint(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();

        frame.setVisible(true);

    }

    public void update() {
        try {
            g.setColor(new Color(0x222222));
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.drawImage(image, (canvas.getWidth() - scaledContext.width) / 2, (canvas.getHeight() - scaledContext.height) / 2,
                    scaledContext.width, scaledContext.height, null);
            bs.show();
        } catch (Exception ignored) {}

        frame.requestFocus();
    }

    public Graphics getDrawGraphics() { return this.image.getGraphics(); }

}
