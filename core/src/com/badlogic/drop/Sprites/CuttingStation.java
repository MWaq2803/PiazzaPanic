package com.badlogic.drop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class CuttingStation extends InteractiveTileObject {
    public CuttingStation(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
    }
}
