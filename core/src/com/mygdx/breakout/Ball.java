package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x,y,radius;
    private float xSpeed,ySpeed,speed;
    private CollisionCircle coll;
    public Ball (int speed, int radius) {
        this.x = Gdx.graphics.getWidth() / 2;
        this.y = 100;
        this.speed = speed;
        this.ySpeed = speed;
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
        if (coll.collidesWith(paddle.getColl())) {
            calculateNewSpeedVectorPaddle(paddle);
        }
        for (Brick brick : bricks) {
            if (coll.collidesWith(brick.getColl())) {
                calculateNewSpeedVectorBrick(brick);
                brick.destroy();
                break;
            }
        }
    }
    private void calculateNewSpeedVectorPaddle(Paddle paddle) {
        float angle = (float)Math.acos((float)(x - paddle.getX() - (paddle.getWidth() / 2)) / (float)(paddle.getWidth() / 2 + radius));
        xSpeed = (float)(Math.cos(angle) * speed);
        ySpeed = (float)(Math.sin(angle) * speed);
    }
    //TODO Figure out how to make the ball bounce properly without changing speed
    private void calculateNewSpeedVectorBrick(Brick brick) {
        if ((y > brick.getY() - radius / 2 && y < brick.getY() + brick.getHeight() + radius / 2)) {
            xSpeed = -xSpeed;
            float angle = (float)Math.cos(xSpeed / speed);
            System.out.println(angle / Math.PI);
        } else {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer sr) {
        sr.circle(x, y, radius);
    }
}
