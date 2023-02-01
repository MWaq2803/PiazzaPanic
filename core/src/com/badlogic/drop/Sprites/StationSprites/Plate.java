package com.badlogic.drop.Sprites.StationSprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

/**
 * Class to create Plate object (present in serving screen only) which extends InteractiveTileObject
 */
public class Plate extends InteractiveTileObject {
    /**
     * Constructor to create Plate object
     * @param screen
     * @param bounds
     */
    public Plate(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Plate");
    }
}
