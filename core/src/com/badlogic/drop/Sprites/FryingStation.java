package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

/**
 * The class FryingStation represents the frying station in the game
 * It is an extension of InteractiveTileObject and holds information about the frying station itself
 */
public class FryingStation extends InteractiveTileObject {
    /**
     * Constructor for FryingStation class
     * @param screen - a reference to the Playscreen instance
     * @param bounds - the bounds of the rectangle of the frying station on the map
     */
    public FryingStation(MyScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("FryingStation");
        //Setting the user data for the fixture to be FryingStation
    }
}
