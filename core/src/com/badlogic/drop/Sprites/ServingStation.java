package com.badlogic.drop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ServingStation extends InteractiveTileObject {
    public ServingStation(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
    }
}