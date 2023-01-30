package com.badlogic.drop.Tools;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.drop.Sprites.*;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

/**
 * This class is responsible for creating the game world objects in the Piazza Panic game
 * Uses tiled maps to determine the positions of different objects and creates instances of each object in the world
 */
public class B2WorldCreator {
    /**
     * The constructor that creates the world objects
     * @param screen - the PlayScreen instance for the game
     */
    public B2WorldCreator(MyScreen screen) {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //create walls
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            //set the body type as static
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / PiazzaPanic.PPM, (rect.getY() + rect.getHeight() / 2) / PiazzaPanic.PPM);

            body = world.createBody(bdef);
            //create a body in the world

            shape.setAsBox(rect.getWidth() / 2 / PiazzaPanic.PPM, rect.getHeight() / 2 / PiazzaPanic.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
            //set the shape of the body as a rectangle
        }

        //create counter
        for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Counter(screen, rect);
        }

        //create pantry
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Pantry(screen, rect);
        }

        //create serving station
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new ServingStation(screen, rect);
        }

        //create cutting station
        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new CuttingStation(screen, rect);
        }

        //create frying station
        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new FryingStation(screen, rect);
        }
    }
}
