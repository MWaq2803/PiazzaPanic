package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

/**
 * The class Pantry represents the pantry in the game
 * It is an extension of InteractiveTileObject and holds information about the pantry itself
 */
public class Pantry extends InteractiveTileObject {
    /**
     * Constructor for FryingStation class
     * @param screen - a reference to the Playscreen instance
     * @param bounds - the bounds of the rectangle of the frying station on the map
     */
    public Pantry(MyScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("Pantry");
        //Setting the user data for the fixture to be Pantry
    }

}
