package com.badlogic.drop.Sprites.StationSprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

/**
 * Class to create Knife object (present in cutting screen only) which extends InteractiveTileObject
 */
public class Knife extends InteractiveTileObject {
    /**
     * Constructor to create Knife object
     * @param screen
     * @param bounds
     */
    public Knife(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Knife");
    }
}
