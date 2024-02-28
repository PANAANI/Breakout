package com.mygdx.breakout;

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
    @Override
    public void create () {
        sr = new ShapeRenderer();
		ball = new Ball(x, y, xSpeed, ySpeed, size);
		paddle = new Paddle(width, height);
    }
    @Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		ball.draw(sr);
		paddle.update();
		paddle.draw(sr);
		sr.end();
    }
}