package com.badlogic.drop.Scenes;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * The class Hud represents the Heads Up Display in the game which displays a timer in game
 * It contains a Stage object that displays the time count as a Label object
 */
public class Hud implements Disposable {
    public Stage stage;
    private Viewport viewport;

    private float timeCount;
    private Integer worldTimer;

    Label timeLabel;
    Label countdownLabel;

    /**
     * Constructor for the HUD class
     * @param sb - the SpriteBatch object to render the UI elements
     */
    public Hud(SpriteBatch sb) {
        timeCount = 0;
        worldTimer = 0;

        viewport = new FitViewport(PiazzaPanic.V_WIDTH, PiazzaPanic.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        //create a FitViewport and a stage, using the viewport and sprite batch

        Table table = new Table();
        table.top();
        table.setFillParent(true);
        //table is now size of stage

        BitmapFont font = new BitmapFont();
        font.getData().setScale(2.0f);
        timeLabel = new Label("TIME", new Label.LabelStyle(font, Color.WHITE));
        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(font, Color.WHITE));

        table.add(timeLabel).expandX();
        table.row();
        table.add(countdownLabel).expandX();
        //add the time label to the table, expand it horizontally, and add some padding - add game timer label

        stage.addActor(table);
        //add the table to the stage
    }

    /**
     * Updates the time counter and the countdown label
     * @param dt - the delta time passed since the last frame
     */
    public void update(float dt) {
        timeCount += dt;
        if (timeCount >= 1) {
            worldTimer ++;
            countdownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }

    /**
     * Disposes the stage when it is no longer needed
     */
    @Override
    public void dispose() {
        stage.dispose();
    }
}
