package com.mygdx.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class GameObject {
    protected int x = 0, y = 0;
    public abstract void draw(ShapeRenderer sr);
}
