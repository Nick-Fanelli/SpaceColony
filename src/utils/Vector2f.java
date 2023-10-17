package utils;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f vector2f) {
        this.x = vector2f.x;
        this.y = vector2f.y;
    }

    public void clear() {
        this.x = 0;
        this.y = 0;
    }

    public void add(Vector2f r) {
        this.x += r.x;
        this.y += r.y;
    }

}
