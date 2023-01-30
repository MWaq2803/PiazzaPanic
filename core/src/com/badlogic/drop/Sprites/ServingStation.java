package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

/**
 * The class ServingStation represents the serving station in the game
 * It is an extension of InteractiveTileObject and holds information about the serving station itself
 */
public class ServingStation extends InteractiveTileObject {
    /**
     * Constructor for ServingStation class
     * @param screen - a reference to the Playscreen instance
     * @param bounds - the bounds of the rectangle of the serving station on the map
     */
    public ServingStation(MyScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("ServingStation");
        //Setting the user data for the fixture to be ServingStation
    }
}