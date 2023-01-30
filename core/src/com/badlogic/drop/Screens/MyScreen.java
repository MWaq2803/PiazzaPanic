package com.badlogic.drop.Screens;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class MyScreen implements Screen {
    protected PiazzaPanic game;
    protected OrthographicCamera gamecam;
    protected Viewport gameport;
    protected Stage stage;

    public MyScreen(final PiazzaPanic game, Stage stage) {
        this.game = game;
        this.stage = stage;
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, 1920, 1040);
        gameport = new FitViewport(PiazzaPanic.V_WIDTH / PiazzaPanic.PPM + 2,
                PiazzaPanic.V_HEIGHT / PiazzaPanic.PPM + 2,
                gamecam);

        //initially set our gamecam to be centred correctly at the start of the map
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        stage = new Stage(gameport, game.batch);
        Gdx.input.setInputProcessor(stage);
    }

    public abstract World getWorld();

    public abstract TiledMap getMap();

    public abstract void resize(int width, int height);
}
