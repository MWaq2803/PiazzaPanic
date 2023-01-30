package com.badlogic.drop.Sprites.PantrySprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

public class Onion extends InteractiveTileObject {
    public Onion(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Onion");
    }
}
