package com.badlogic.drop.Screens;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Scenes.Hud;
import com.badlogic.drop.Sprites.Cook;
import com.badlogic.drop.Tools.B2WorldCreator;
import com.badlogic.drop.Tools.WorldContactListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.drop.Sprites.Customer;

/**
 * The PlayScreen class is a screen that implements the libGDX Screen interface
 * Represents the main game screen in the PiazzaPanic game
 * Contains instance variables for game objects, such as TiledMap, World, Box2dDebugRenderer and Cook
 * Provides methods for handling player input, updating the game world and objects and rendering the screen
 */
public class PlayScreen extends MyScreen {
    private Hud hud;
    private Stage stage;
    private Skin skin;

    //Tiled map variables
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;
    private B2WorldCreator creator;
    private Cook player;
    private Customer customer;

    public PlayScreen(final PiazzaPanic game, Stage stage) {
        super(game,stage);

        //create our new HUD for timer
        hud = new Hud(game.batch);

        //load our map and setup our map renderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / PiazzaPanic.PPM);

        //create our Box2D world, setting no gravity in X, Y and allow bodies to sleep
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();

        creator = new B2WorldCreator(this);
        //create the game world

        player = new Cook(this);
        //initialise the player character

        world.setContactListener(new WorldContactListener(game, stage,player));
        //set the contact listener for the Box2D world, so we can detect collisions

        customer = new Customer(this, .32f, .32f);

    }

    @Override
    public void show() {
    }

    /**
     * Method to handle the user inputs in the game so player can control cook using arrow keys
     * Player's acceleration is set to being decided by arrow keys and max speed is set at 2
     * @param dt - delta time for frame-independent movements
     */
    public void handleInput(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2) {
            player.b2body.applyLinearImpulse(new Vector2(1f, 0), player.b2body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2) {
            player.b2body.applyLinearImpulse(new Vector2(-1f, 0), player.b2body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && player.b2body.getLinearVelocity().y <= 2) {
            player.b2body.applyLinearImpulse(new Vector2(0, 1f), player.b2body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && player.b2body.getLinearVelocity().y >= -2) {
            player.b2body.applyLinearImpulse(new Vector2(0, -1f), player.b2body.getWorldCenter(), true);
        }
    }
    public void update(float dt) {
        handleInput(dt);

        world.step(1/60f, 6, 2);
        //updates the game state

        player.update(dt);
        customer.update(dt);
        hud.update(dt);

        gamecam.position.x = player.b2body.getPosition().x;
        gamecam.position.y = player.b2body.getPosition().y;
        //gamecam object position is updated to follow the player object

        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render(); //render our game map

        b2dr.render(world, gamecam.combined); //render our Box2DDebugLines

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player.draw(game.batch);
        customer.draw(game.batch);
        game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
    }

    public TiledMap getMap() {
        return map;
    }

    public World getWorld() {
        return world;
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
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();
    }
}







