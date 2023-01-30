package com.badlogic.drop.Sprites.PantrySprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

public class Patty extends InteractiveTileObject {
    public Patty(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Patty");
    }
}
