package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

public class ServingStation extends InteractiveTileObject {
    public ServingStation(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("ServingStation");
    }
}