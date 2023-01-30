package com.badlogic.drop.Sprites.StationSprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


import java.awt.*;
import java.lang.annotation.Target;
import java.util.Scanner;

/**
 * The class CuttingStation represents the cutting station in the game
 * It is an extension of InteractiveTileObject and holds information about the cutting station itself
 */
public class CuttingStation extends InteractiveTileObject {
    /**
     * Constructor for CuttingStation class
     * @param screen - a reference to the Playscreen instance
     * @param bounds - the bounds of the rectangle of the cutting station on the map
     */
    public CuttingStation(MyScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("CuttingStation");
        //Setting the user data for the fixture to be CuttingStation
    }

//    @Override
//    public void onCollision(Cook cook) {
//        System.out.println("The cook collided with the cutting station");
//        Stage stage = new Stage();
//        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
//
//        Table table = new Table();
//        table.setFillParent(true);
//        stage.addActor(table);
//
//        Scanner scanner = new Scanner(System.in);
//        for(int i =0; i<pantry.pantryContents.size(); i++){
//            String ingredient = pantry.pantryContents.get(i);
//            Label label = new Label(i+ ":"+ ingredient, skin);
//            table.add(label).pad(10);
//            table.row();
//        }
//
//        stage.addListener(new InputListener(){
//        @Override
//        public boolean keyTyped(InputEvent event, char character) {
//            int index = Integer.parseInt(Character.toString(character));
//            if(index >= 0 && index < pantry.pantryContents.size()){
//                String selectedIngredient = pantry.pantryContents.get(index);
//                System.out.println("Selected Ingredient:" + selectedIngredient);
//            }
//            else{
//                System.out.println("Invalid index entered");
//            }
//
//
//            return true;
//        }
//        });
//
//        Gdx.input.setInputProcessor(stage);

    }

