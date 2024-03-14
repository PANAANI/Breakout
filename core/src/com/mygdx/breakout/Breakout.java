package com.mygdx.breakout;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Breakout extends ApplicationAdapter {
	public final static int screen_width = 1280;
	public final static int screen_height = 720;
    ShapeRenderer sr;
	// Ball properties
	final int speed = 6; 
	final int size = 10;
	Ball ball;
	// Paddle properties
	final int paddle_width = 80;
	final int paddle_height = 5;
	Paddle paddle;
	// Brick properties
	final int brick_width = 80;
	final int brick_height = 30;
	final int gap = 10;
	final int layers = 5;
	ArrayList<Brick> bricks = new ArrayList<>();
	private OrthographicCamera cam;
	private FitViewport fitViewport;
	@Override
    public void create () {
        sr = new ShapeRenderer();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, screen_width, screen_height);
		fitViewport = new FitViewport(screen_width, screen_height, cam);
		sr.setProjectionMatrix(fitViewport.getCamera().combined);
		ball = new Ball(speed, size);
		paddle = new Paddle(paddle_width, paddle_height);
		int brick_x = gap;
        for (int i = 0; i < screen_width / (brick_width + gap); i++) {
			int brick_y = screen_height - gap - brick_height;
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
		sr.begin(ShapeRenderer.ShapeType.Filled);
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