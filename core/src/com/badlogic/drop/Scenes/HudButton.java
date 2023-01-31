package com.badlogic.drop.Scenes;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.drop.Sprites.Cook;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HudButton implements Disposable {
    public Stage stage;
    private Viewport  viewport;

    private TextButton button;
    private Skin skin;
    private PiazzaPanic game;

    public HudButton(SpriteBatch sb, final PiazzaPanic game) {
        this.game = game;
        viewport = new ScreenViewport();
        stage = new Stage(viewport, sb);
        Gdx.input.setInputProcessor(stage);

        //table to organise labels
        Table table = new Table();
        table.left();
        table.setFillParent(true);

        skin = new Skin(Gdx.files.internal("metal-ui.json"));
        TextButton button = new TextButton("Back!", skin);
        button.toFront();
        table.add(button).width(140).height(30).padTop(450);


        TextButton button1 = new TextButton("Drop Top Item!", skin);
        button.toFront();
        table.add(button1).width(140).height(30).padTop(-450);

        //Checks if button is clicked
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked");
                game.setScreen(new PlayScreen(game, stage));
                dispose();
            }
        });

        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Drop clicked");
                //Cook cook = new Cook(new PlayScreen(game, stage));
                //cook.removeFromInventory();
            }
        });

        stage.addActor(table);
    }

    public void update(float dt) {
        stage.act();
    }

    public void draw() {
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
