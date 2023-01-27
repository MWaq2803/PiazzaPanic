package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class FryingStation extends InteractiveTileObject {
    public FryingStation(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData("FryingStation");
    }
}
