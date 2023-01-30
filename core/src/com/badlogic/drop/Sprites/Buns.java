package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.gdx.math.Polygon;

public class Buns extends InteractiveTileObject{
    public Buns(MyScreen screen, Polygon bounds) {
        super(screen, bounds.getBoundingRectangle());
        fixture.setUserData("Buns");
    }
}