package com.badlogic.drop.Sprites.StationSprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.InteractiveTileObject;
import com.badlogic.gdx.math.Polygon;

public class Knife extends InteractiveTileObject {
    public Knife(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Knife");
    }
}
