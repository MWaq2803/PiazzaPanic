package com.badlogic.drop.Screens;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Scenes.HudButton;
import com.badlogic.drop.Sprites.Cook;
import com.badlogic.drop.Tools.B2WorldCreator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FryingScreen extends MyScreen{
    private int screenWidth = 1080;
    private int screenHeight = 720;

    //Tiled map variables
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Cook player;

    //Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;
    private B2WorldCreator creator;
    private Skin skin;
    private HudButton hud;

    public FryingScreen(final PiazzaPanic game, Stage stage) {
        super(game,stage);

        // create our game HUD for score/timer
        hud = new HudButton(game.batch, game);

        //Load our map and setup our map renderer
        maploader = new TmxMapLoader();
        map = maploader.load("fryingStation.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1  / PiazzaPanic.PPM);

        //create our Box2D world, setting no gravity in X, -10 gravity in Y, and allow bodies to sleep
        world = new World(new Vector2(0, 0), true);
        //allows for debug lines of our box2d world.
        b2dr = new Box2DDebugRenderer();

        creator = new B2WorldCreator(this);

        skin = new Skin(Gdx.files.internal("metal-ui.json"));

    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public TiledMap getMap() {
        return map;
    }

    @Override
    public void show() {

    }


    public void update(float dt) {
        hud.update(dt);
        //takes 1 step in the physics simulation (60x per second)
        world.step(1/60f, 6, 2);

        // update our gamecam with correct coordinates after changes
        gamecam.update();

        //tell our rendered to draw only what our camera can see in our game world
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        //separate our gamecam update logic from render
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1); // clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //fills the screen

        stage.act();
        stage.draw();

        //render our game map
        renderer.render();

        //renderer our Box2DDebugLines
        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.end();

        // set our batch to now draw what the Hud camera sees
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        hud.dispose();

    }
}
