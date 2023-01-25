package com.badlogic.drop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Pantry extends InteractiveTileObject{
    public Pantry(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
    }
}
