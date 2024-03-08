 package com.mygdx.breakout;

public class CollisionCircle extends Collision2D {
    private int radius;
    public CollisionCircle(int _radius) {
        radius = _radius;
    }
    public int getRadius() {
        return radius;
    }
    public boolean collidesWith(CollisionRect coll) {
        int xDist = Math.abs(coll.getWidth() / 2 + coll.x - x);
        int yDist = Math.abs(coll.getHeight() / 2 + coll.y - y);
        return xDist < radius + coll.getWidth() / 2 && yDist < radius + coll.getHeight() / 2;
    }
    public boolean collidesWith(CollisionCircle coll) {
        // TODO: implement this
        return true;
    }
}
