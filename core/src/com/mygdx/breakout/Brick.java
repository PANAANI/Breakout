package com.mygdx.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick extends GameObject {
    boolean destroy = false;
    int width,height;
    public Brick(int _x, int _y, int _width, int _height) {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
    }
    public void draw(ShapeRenderer sr) {
        sr.rect(x, y, width, height);
    }
}