package com.mygdx.breakout;

public abstract class Collision2D {
    int x,y;
    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract boolean collidesWith(CollisionRect coll);
    public abstract boolean collidesWith(CollisionCircle coll);
}
