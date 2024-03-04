package com.mygdx.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x,y,width,height;
    CollisionRect coll;
    public Paddle (int width, int height) {
        x = Gdx.graphics.getWidth() / 2 - width / 2;
        y = 20;
        this.width = width;
        this.height = height;
        coll = new CollisionRect(width, height);
    }
    public void update() {
        x = Gdx.input.getX() - width / 2;
        coll.updatePosition(x, y);
    }
    public void draw(ShapeRenderer sr) {
        sr.rect(x, y, width, height);
    }
}