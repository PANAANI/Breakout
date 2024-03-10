package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer sr;
	// Ball properties
	final int speed = 4; 
	final int size = 10;
	Ball ball;
	// Paddle properties
	final int width = 80;
	final int height = 5;
	Paddle paddle;
	// Brick properties
	final int brick_width = 80;
	final int brick_height = 30;
	final int gap = 10;
	final int layers = 5;
	ArrayList<Brick> bricks = new ArrayList<>();
	Brick brick;
	@Override
    public void create () {
        sr = new ShapeRenderer();
		ball = new Ball(speed, size);
		paddle = new Paddle(width, height);
		int brick_x = gap;
		for (int i = 0; i < Gdx.graphics.getWidth() / (brick_width + gap); i++) {
			int brick_y = Gdx.graphics.getHeight() - gap - brick_height;
			for (int j = 0; j < layers; j++) {
				bricks.add(new Brick(brick_x, brick_y, brick_width, brick_height));
				brick_y -= gap + brick_height;
			}
			brick_x += gap + brick_width;
		}
    }
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update(paddle, bricks);
		paddle.update();
		sr.begin(ShapeRenderer.ShapeType.Line);
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (brick.getDestroy()) {
				bricks.remove(brick);
				i--;
				continue;
			}
			brick.draw(sr);
		}
		ball.draw(sr);
		paddle.draw(sr);
		sr.end();
    }
}