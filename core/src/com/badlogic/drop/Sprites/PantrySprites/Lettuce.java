package com.badlogic.drop.Sprites.PantrySprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class Lettuce extends InteractiveTileObject {
    public Lettuce(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Lettuce");
    }
}
