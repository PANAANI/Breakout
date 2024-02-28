package com.mygdx.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends GameObject {
    int width, height;
    public Paddle (int _width, int _height) {
        x = Gdx.graphics.getWidth() / 2 - _width / 2;
        y = 20;
        width = _width;
        height = _height;
    }
    public void update() {
        x = Gdx.input.getX() - width / 2;
    }
    public void draw(ShapeRenderer sr) {
        sr.rect(x, y, width, height);
    }
}