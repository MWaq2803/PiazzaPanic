package com.badlogic.drop;

import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PiazzaPanic extends Game {
	public static final int V_WIDTH = 720;
	public static final int V_HEIGHT = 480;
	public static final float PPM = 100;
	public SpriteBatch batch;

	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new PlayScreen(this));
	}

	public void render() {
		super.render(); //delegate the render method to the active screen
	}

	public void dispose() {
		batch.dispose();
	}
}


