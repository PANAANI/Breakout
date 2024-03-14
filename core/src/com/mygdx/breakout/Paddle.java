package com.mygdx.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    private int x,y,width,height;
    private CollisionRect coll;
    public Paddle (int width, int height) {
        x = Gdx.graphics.getWidth() / 2 - width / 2;
        y = 20;
        this.width = width;
        this.height = height;
        coll = new CollisionRect(width, height);
    }
    public void update() {
        x = (int)(((float)Gdx.input.getX() / (float)Gdx.graphics.getWidth()) * 1280 - width / 2);
        coll.updatePosition(x, y);
    }
    public void draw(ShapeRenderer sr) {
        sr.rect(x, y, width, height);
    }
    public CollisionRect getColl() {
        return coll;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}