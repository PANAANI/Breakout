package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x,y,radius,xSpeed,ySpeed;
    CollisionCircle coll;
    public Ball (int x, int y, int xSpeed, int ySpeed, int radius) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.radius = radius;
        coll = new CollisionCircle(radius);
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
                if ((y > brick.y - radius / 2 && y < brick.y + brick.height + radius / 2)) {
                    xSpeed = -xSpeed;
                } else {
                    ySpeed = -ySpeed;
                }
                brick.destroy();
                break;
            }
        }
    }
    public void draw(ShapeRenderer sr) {
        sr.circle(x, y, radius);
    }
}
