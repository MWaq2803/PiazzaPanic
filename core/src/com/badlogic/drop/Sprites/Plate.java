package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.gdx.math.Polygon;

public class Plate extends InteractiveTileObject{
    public Plate(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Plate");
    }
}
