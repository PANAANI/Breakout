package com.mygdx.breakout;

public class CollisionRect extends Collision2D {
    private int width,height;
    public CollisionRect(int _width, int _height) {
        width = _width;
        height = _height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    // TODO implement collision detection methods here
    public boolean collidesWith(CollisionCircle coll) {
        return true;
    }
    public boolean collidesWith(CollisionRect coll) {
        return true;
    }
}
