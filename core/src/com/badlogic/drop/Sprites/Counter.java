package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;


public class Counter extends InteractiveTileObject{
    public Counter(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("Counter");
    }
}
