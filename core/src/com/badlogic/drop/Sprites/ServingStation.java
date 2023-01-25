package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ServingStation extends InteractiveTileObject {
    public ServingStation(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
    }

    @Override
    public void onHeadHit() {

    }
}