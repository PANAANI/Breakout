package com.mygdx.breakout;

import java.util.ArrayList;

public class LevelManager {
    private ArrayList<Brick> bricks;
    private final int brick_width, brick_height, layers, gap;
    public LevelManager(int brick_width, int brick_height, int layers, int gap) {
        this.brick_width = brick_width;
        this.brick_height = brick_height;
        this.layers = layers;
        this.gap = gap;
        bricks = new ArrayList<Brick>();
    }
    public void update(Ball ball) {
        for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			if (brick.getDestroy()) {
				bricks.remove(brick);
				i--;
			}
		}
        if (bricks.isEmpty()) {
            ball.reset();
            createLevel();
        }
    }
    public void createLevel() {
        int brick_x = gap;
        for (int i = 0; i < Breakout.screen_width / (brick_width + gap); i++) {
			int brick_y = Breakout.screen_height - gap - brick_height;
			for (int j = 0; j < layers; j++) {
				bricks.add(new Brick(brick_x, brick_y, brick_width, brick_height));
				brick_y -= gap + brick_height;
			}
			brick_x += gap + brick_width;
		}
    } 
    public ArrayList<Brick> getBricks () {
        return bricks;
    }
}
