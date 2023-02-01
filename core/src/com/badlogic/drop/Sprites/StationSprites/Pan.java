package com.badlogic.drop.Sprites.StationSprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

/**
 * Class to create Pan object (present in frying screen only) which extends InteractiveTileObject
 */
public class Pan extends InteractiveTileObject {
    /**
     * Constructor to create Pan object
     * @param screen
     * @param bounds
     */
    public Pan(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Pan");
    }
}