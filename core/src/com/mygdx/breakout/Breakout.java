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
	// Ball properties
	private final int speed = 6; 
	private final int size = 10;
	private Ball ball;
	// Paddle properties
	private final int paddle_width = 80;
	private final int paddle_height = 5;
	private Paddle paddle;
	// Brick properties
	private final int brick_width = 80;
	private final int brick_height = 30;
	private final int gap = 10;
	private final int layers = 5;
	private LevelManager manager;
	private OrthographicCamera cam;
	private FitViewport fitViewport;
    private ShapeRenderer sr;
	@Override
    public void create () {
        sr = new ShapeRenderer();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, screen_width, screen_height);
		fitViewport = new FitViewport(screen_width, screen_height, cam);
		ball = new Ball(speed, size);
		paddle = new Paddle(paddle_width, paddle_height);
		manager = new LevelManager(brick_width, brick_height, layers, gap);
		manager.createLevel();
    }
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update(paddle, manager.getBricks());
		paddle.update();
		sr.setProjectionMatrix(fitViewport.getCamera().combined);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		for (Brick brick : manager.getBricks()) {
			brick.draw(sr);
		}	
		ball.draw(sr);
		paddle.draw(sr);
		sr.end();
    }
}