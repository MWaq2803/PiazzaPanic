package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Rectangle;

public class FryingStation extends InteractiveTileObject {
    public FryingStation(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("FryingStation");
    }
}
