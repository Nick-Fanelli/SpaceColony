package world;

import java.awt.*;

public class Tileset {

    public final int width;
    public final int height;

    public final int pixelWidth;
    public final int pixelHeight;

    private final Tile[] tiles;

    public Tileset(int width, int height, int pixelWidth, int pixelHeight) {
        this.width = width;
        this.height = height;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        this.tiles = new Tile[this.width * this.height];

        for(int i = 0; i < tiles.length; i++) {
            this.tiles[i] = new MoonTile();
        }

        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 2; y++) {

                Tile tile = GetTileAt(x, y);

                if(tile instanceof MoonTile) {
                    MoonTile moonTile = (MoonTile) tile;

                    moonTile.isClaimed = true;
                }

            }
        }

    }

    public Tile GetTileAt(int x, int y) {

        if(x > width || x < 0 || y > height || y < 0) {
            System.err.println("TILE OUTSIDE OF BOUNDS");
            return null;
        }

        return tiles[x + y * width];

    }

    public void RenderTiles(Graphics g) {

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {

                Tile tile = GetTileAt(x, y);
                tile.Draw(g, x * pixelWidth, y * pixelHeight, pixelWidth, pixelHeight);

            }
        }
    }

}
