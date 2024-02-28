package com.mygdx.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    int size;
    Color color = Color.WHITE;
    public Ball (int _x, int _y, int _xSpeed, int _ySpeed, int _size) {
        x = _x;
        y = _y;
        xSpeed = _xSpeed;
        ySpeed = _ySpeed;
        size = _size;
    }
    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle) == true) {
            color = Color.GREEN;
        }   else {
            color = Color.WHITE;
        }
    }
    private boolean collidesWith(Paddle paddle) {
        int xDist = Math.abs(paddle.width / 2 + paddle.x - x);
        int yDist = Math.abs(paddle.height / 2 + paddle.y - y);
        return xDist < size + paddle.width / 2 && yDist < size + paddle.height / 2;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (y > Gdx.graphics.getHeight() - size || y < size) {
			ySpeed = -ySpeed;
		}
        if (x > Gdx.graphics.getWidth() - size || x < size) {
			xSpeed = -xSpeed;
		}
    }
    public void draw(ShapeRenderer sr) {
        sr.setColor(color);
        sr.circle(x, y, size);
    }
}
