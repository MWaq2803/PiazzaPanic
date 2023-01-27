package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.PlayScreen;
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

public class CuttingStation extends InteractiveTileObject {
    Pantry pantry;
    //Interactive Tile Object effectively acts as the parents class
    public CuttingStation(PlayScreen screen, Rectangle bounds, Pantry pantry) {
        super(screen, bounds);
        this.pantry = pantry;
        fixture.setUserData(this);
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

