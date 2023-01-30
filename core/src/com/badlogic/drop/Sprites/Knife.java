package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.gdx.math.Polygon;

public class Knife extends InteractiveTileObject{
    public Knife(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Knife");
    }
}
