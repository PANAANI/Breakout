package com.mygdx.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    private boolean destroy = false;
    private int x,y,width,height;
    private CollisionRect coll;
    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        coll = new CollisionRect(width, height);
        coll.updatePosition(x, y);
    }
    public void draw(ShapeRenderer sr) {
        sr.rect(x, y, width, height);
    }
    public void destroy() {
        destroy = true;
    }
    public boolean getDestroy() {
        return destroy;
    }
    public CollisionRect getColl() {
        return coll;
    }
    public int getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
}