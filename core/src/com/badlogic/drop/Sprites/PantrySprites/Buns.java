package com.badlogic.drop.Sprites.PantrySprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

/**
 * Class to create Buns object (present in pantry only) which extends InteractiveTileObject
 */
public class Buns extends InteractiveTileObject {
    public Buns(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Buns");
    }
}