package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x,y,radius,xSpeed,ySpeed;
    CollisionCircle coll;
    public Ball (int _x, int _y, int _xSpeed, int _ySpeed, int _radius) {
        x = _x;
        y = _y;
        xSpeed = _xSpeed;
        ySpeed = _ySpeed;
        radius = _radius;
        coll = new CollisionCircle(_radius);
    }
    public void update(Paddle paddle, ArrayList<Brick> bricks) {
        x += xSpeed;
        y += ySpeed;
        coll.updatePosition(x, y);
        if (y > Gdx.graphics.getHeight() - radius || y < radius) {
			ySpeed = -ySpeed;
		}
        if (x > Gdx.graphics.getWidth() - radius || x < radius) {
			xSpeed = -xSpeed;
		}
        if (coll.collidesWith(paddle.coll)) {
            ySpeed = -ySpeed;
        }
        for (Brick brick : bricks) {
            if (coll.collidesWith(brick.coll)) {
                brick.destroy();
                break;
            }
        }
    }
    public void testBallUpdate (Brick brick) {
        x = Gdx.input.getX();
        y = Gdx.graphics.getHeight() - Gdx.input.getY();
        coll.updatePosition(x, y);
        coll.checkCollisionSide(brick.coll);
    }
    public void draw(ShapeRenderer sr) {
        sr.circle(x, y, radius);
    }
}
