package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

/**
 * InteractiveTileObject is an abstract class that represents a tile object that is interactive
 * It contains instance variables that hold a reference to the World, TiledMap, Rectangle bounds, Body and Fixture
 */
public abstract class InteractiveTileObject {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    protected MyScreen screen;
    protected MapObject object;
    protected Fixture fixture;

    /**
     * Constructor for InteractiveTileObject
     * @param screen - Playscreen object where the InteractiveTileObject resides
     * @param bounds - Rectangle object that represents the bounds of the InteractiveTileObject
     */
    public InteractiveTileObject(MyScreen screen, Rectangle bounds) {
        this.world = screen.getWorld();
        this.screen = screen;
        this.map = screen.getMap();
        this.bounds = bounds;
        //sets the world, map and bounds instance variables to the corresponding objects in the PlayScreen

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        //creates a BodyDef and FixtureDef object for the InteractiveTileObject

        bdef.type = BodyDef.BodyType.StaticBody;
        //sets the type of the body to be static
        bdef.position.set((bounds.getX() + bounds.getWidth() / 2) / PiazzaPanic.PPM, (bounds.getY() + bounds.getHeight() / 2) / PiazzaPanic.PPM);

        body = world.createBody(bdef);
        //creates a body in the world

        shape.setAsBox(bounds.getWidth() / 2 / PiazzaPanic.PPM, bounds.getHeight() / 2 / PiazzaPanic.PPM);
        fdef.shape = shape;
        //sets the shape of the fixture to be a box based on the bounds of the InteractiveTileObject
        fixture = body.createFixture(fdef);
        //creates the fixture in the body
    }
}
