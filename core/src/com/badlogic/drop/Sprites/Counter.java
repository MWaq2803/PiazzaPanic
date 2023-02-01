package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

/**
 * Class to create Counter object which extends InteractiveTileObject
 */
public class Counter extends InteractiveTileObject{
    /**
     * Constructor to create Counter object
     * @param screen
     * @param bounds
     */
    public Counter(MyScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("Counter");
    }
}
