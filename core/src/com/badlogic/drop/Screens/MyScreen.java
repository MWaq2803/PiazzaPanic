package com.badlogic.drop.Screens;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Sprites.Cook;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * An abstract class representing a screen in a game
 * This class implements the Screen interface and provides basic screen functionality
 */
public abstract class MyScreen implements Screen {
    protected PiazzaPanic game;
    protected OrthographicCamera gamecam;
    protected Viewport gameport;
    protected Stage stage;


    /**
     * Constructor for the MyScreen class
     * @param game
     * @param stage
     */
    public MyScreen(final PiazzaPanic game, Stage stage) {
        this.game = game;
        this.stage = stage;
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, 2040, 1920);
        //create new gameport with the following dimensions
        gameport = new FitViewport(PiazzaPanic.V_WIDTH / PiazzaPanic.PPM + 2,
                PiazzaPanic.V_HEIGHT / PiazzaPanic.PPM + 2,
                gamecam);

        //initially set our gamecam to be centred correctly at the start of the map
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        stage = new Stage(gameport, game.batch);
        Gdx.input.setInputProcessor(stage);
    }

    /**
     * Abstract method to retrieve World object for this screen
     * @return The World object for this screen
     */
    public abstract World getWorld();

    /**
     * Abstract method to retrieve TiledMap for this screen
     * @return The TiledMap for this screen
     */
    public abstract TiledMap getMap();

    /**
     * Abstract method to resize the screen
     * @param width
     * @param height
     */
    public abstract void resize(int width, int height);
}
