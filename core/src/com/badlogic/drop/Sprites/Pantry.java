package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;


public class Pantry extends InteractiveTileObject{
    ArrayList<String> pantryContents;
    public Pantry(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        pantryContents = new ArrayList<String>();
        pantryContents.add("lettuce");
        pantryContents.add("tomatoes");
        pantryContents.add("onions");
        pantryContents.add("patty");
        pantryContents.add("buns");
        fixture.setUserData("Pantry");
    }
}
