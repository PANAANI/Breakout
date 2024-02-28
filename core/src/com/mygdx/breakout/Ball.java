package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends GameObject {
    int xSpeed, ySpeed, size;
    public Ball (int _x, int _y, int _xSpeed, int _ySpeed, int _size) {
        x = _x;
        y = _y;
        xSpeed = _xSpeed;
        ySpeed = _ySpeed;
        size = _size;
    }
    private boolean collidesWithPaddle(Paddle paddle) {
        int xDist = Math.abs(paddle.width / 2 + paddle.x - x);
        int yDist = Math.abs(paddle.height / 2 + paddle.y - y);
        return xDist < size + paddle.width / 2 && yDist < size + paddle.height / 2;
    }
    private boolean collidesWithBrick(Brick brick) {
        int xDist = Math.abs(brick.width / 2 + brick.x - x);
        int yDist = Math.abs(brick.height / 2 + brick.y - y);
        return xDist < size + brick.width / 2 && yDist < size + brick.height / 2;
    }
    public void update(Paddle paddle, ArrayList<Brick> bricks) {
        x += xSpeed;
        y += ySpeed;
        if (y > Gdx.graphics.getHeight() - size || y < size) {
			ySpeed = -ySpeed;
		}
        if (x > Gdx.graphics.getWidth() - size || x < size) {
			xSpeed = -xSpeed;
		}
        if (collidesWithPaddle(paddle)) {
            ySpeed = -ySpeed;
        }
        for (Brick brick : bricks) {
            if (collidesWithBrick(brick)) {
                ySpeed = -ySpeed;
                brick.destroy = true;
                break;
            }
        }
    }
    public void draw(ShapeRenderer sr) {
        sr.circle(x, y, size);
    }
}
