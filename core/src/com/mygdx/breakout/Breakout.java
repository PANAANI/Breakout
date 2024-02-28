package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer sr;
	// Ball properties
	int y = 50;
	int x = 50;
	int xSpeed = 5;
	int ySpeed = 5;
	int size = 10;
	Ball ball;
	// Paddle properties
	int width = 80;
	int height = 5;
	Paddle paddle;
	// Brick properties
	int brick_width = 80;
	int brick_height = 30;
	int gap = 10;
	int layers = 5;
	ArrayList<Brick> bricks = new ArrayList<>();
    @Override
    public void create () {
        sr = new ShapeRenderer();
		ball = new Ball(x, y, xSpeed, ySpeed, size);
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
		sr.begin(ShapeRenderer.ShapeType.Filled);
		ball.update(paddle, bricks);
		ball.draw(sr);
		paddle.update();
		paddle.draw(sr);
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (brick.destroy == true) {
				bricks.remove(brick);
				i--;
				continue;
			}
			brick.draw(sr);
		}
		sr.end();
    }
}