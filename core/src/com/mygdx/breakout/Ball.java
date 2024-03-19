package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private final static String collision_sound_name = "collision.wav";
    private int x,y,radius;
    private float xSpeed,ySpeed,speed;
    private CollisionCircle coll;
    private Sound collision_sound;
    public Ball (int speed, int radius) {
        this.x = Gdx.graphics.getWidth() / 2;
        this.y = 100;
        this.speed = speed;
        this.ySpeed = speed;
        this.radius = radius;
        collision_sound = Gdx.audio.newSound(Gdx.files.internal(collision_sound_name));
        coll = new CollisionCircle(radius);
    }
    public void update(Paddle paddle, ArrayList<Brick> bricks) {
        x += xSpeed;
        y += ySpeed;
        coll.updatePosition(x, y);
        if ((y > Breakout.screen_height - radius && ySpeed > 0) || (y < radius && ySpeed < 0)) {
            collision_sound.play();
			ySpeed = -ySpeed;
		}
        if ((x > Breakout.screen_width - radius && xSpeed > 0) || (x < radius && xSpeed < 0)) {
            collision_sound.play();
			xSpeed = -xSpeed;
		}
        if (coll.collidesWith(paddle.getColl())) {
            collision_sound.play();
            calculateNewSpeedVectorPaddle(paddle);
        }
        for (Brick brick : bricks) {
            if (coll.collidesWith(brick.getColl())) {
                collision_sound.play();
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
    private void calculateNewSpeedVectorBrick(Brick brick) {
        if ((y > brick.getY() - radius / 2 && y < brick.getY() + brick.getHeight() + radius / 2)) {
            xSpeed = -xSpeed;
        } else {
            ySpeed = -ySpeed;
        }
    }
    public void reset() {
        xSpeed = 0;
        ySpeed = speed;
        x = Gdx.graphics.getWidth() / 2;
        y = 100;
    }
    public void draw(ShapeRenderer sr) {
        sr.circle(x, y, radius);
    }
}
