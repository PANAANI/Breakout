package com.mygdx.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    boolean destroy = false;
    int x,y,width,height;
    CollisionRect coll;
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
}