package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class CuttingStation extends InteractiveTileObject {
    //Interactive Tile Object effectively acts as the parents class
    public CuttingStation(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(PiazzaPanic.CUTTINGSTATION_BIT);
    }

    @Override
    public void onHeadHit() {

    }
}
