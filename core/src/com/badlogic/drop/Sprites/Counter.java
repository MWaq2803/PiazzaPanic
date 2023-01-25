package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class Counter extends InteractiveTileObject{
    public Counter(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
    }
}
