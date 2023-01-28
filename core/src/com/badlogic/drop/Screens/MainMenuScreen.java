package com.badlogic.drop.Screens;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * MainMenuScreen is the class that displays the main menu once the game is first launched
 * It contains the elements that allow the user to navigate to the different parts of the game
 */
public class MainMenuScreen extends ScreenAdapter {
    final PiazzaPanic game;
    OrthographicCamera camera;
    private Stage stage;
    private Skin skin;
    private Batch batch;
    private Sprite sprite;

    /**
     * This is the constructor for the MainMenuScreen class. It sets up the elements to be displayed on screen
     * @param game - the game object that this screen will be displayed in
     */
    public MainMenuScreen(final PiazzaPanic game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("MainMenuScreen.jpg")));
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        skin = new Skin(Gdx.files.internal("metal-ui.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        //Begin layout
        Label welcomeText = new Label("Welcome to Piazza Panic!", skin);
        root.add(welcomeText);
        root.row();
        root.row();

        TextButton textButton = new TextButton("Scenario Mode", skin);
        root.add(textButton).width(140).height(60).padTop(20);

        //Checks if button is clicked
        textButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
                dispose();
            }
        });
    }

    @Override
    public void show() {
    }

    /**
     * Renders the main menu screen
     * Draws the background sprite and the stage containing the main menu elements
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
    }

    /**
     * Resizes the main menu screen
     * Updates the viewport of the stage to match the new window size
     * @param width - the new width of the window
     * @param height - the new height of the window
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
    }

    public void dispose () {
        skin.dispose();
        stage.dispose();
    }
}