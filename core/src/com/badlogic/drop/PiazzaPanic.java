package com.badlogic.drop;

import com.badlogic.drop.Screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * PiazzaPanic is the first class called when the game is run on the desktop
 * It extends LibGDX Game class and is responsible for creating the Sprite Batch
 * It is also responsible for creating and switching over to the menu screen
 */
public class PiazzaPanic extends Game {
	public static final int V_WIDTH = 1400; //width of the virtual screen in pixels
	public static final int V_HEIGHT = 765; //height of the virtual screen in pixels
	public static final float PPM = 100; //pixels per metre ratio used in calculations

	public SpriteBatch batch; //used to draw the game's sprites
	public BitmapFont font;

	/**
	 * This method is called when the game is first created
	 * It initialises the SpriteBatch and sets the initial screen to the Main Menu Screen
	 */
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new MainMenuScreen(this));
	}

	/**
	 * Renders the current screen
	 * Delegates the render method to the active screen
	 */
	public void render() {
		super.render();
	}

	/**
	 * Called when the game is closed
	 * Disposes of the SpriteBatch
	 */
	public void dispose() {
		batch.dispose();
	}
}


