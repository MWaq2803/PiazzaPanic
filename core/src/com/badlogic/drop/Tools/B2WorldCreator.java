package com.badlogic.drop.Tools;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.drop.Sprites.*;
import com.badlogic.drop.Sprites.PantrySprites.*;
import com.badlogic.drop.Sprites.StationSprites.*;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

/**
 * This class is responsible for creating the game world objects in the Piazza Panic game
 * Uses tiled maps to determine the positions of different objects and creates instances of each object in the world
 */
public class B2WorldCreator {
    /**
     * The constructor that creates the world objects
     *
     * @param screen - the PlayScreen instance for the game
     */
    public B2WorldCreator(MyScreen screen) {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body = null;
        String name = map.getProperties().get("Name", String.class);

        createWalls(map, world, bdef, shape, fdef, body);
        switch (name) {
            case "Kitchen":
                new Pantry(screen, createMethod1(map, 3));
                new ServingStation(screen, createMethod1(map, 4));
                new CuttingStation(screen, createMethod1(map, 5));
                new FryingStation(screen, createMethod1(map, 6));
                new Counter(screen, createMethod1(map, 7));
                break;

            case "Pantry":
                new Lettuce(screen, createMethod(map, 2));
                new Tomato(screen, createMethod(map, 3));
                new Onion(screen, createMethod(map, 4));
                new Patty(screen, createMethod(map, 5));
                new Buns(screen, createMethod(map, 6));
                break;

            case "CuttingStation":
                new Knife(screen, createMethod(map, 2));
                break;

            case "FryingStation":
                new Pan(screen, createMethod(map, 2));
                break;

            case "ServingStation":
                new Plate(screen, createMethod(map, 2));
                break;

            default:
                break;
        }
    }

    private void createWalls(TiledMap map, World world, BodyDef bdef, PolygonShape shape, FixtureDef fdef, Body body) {
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / PiazzaPanic.PPM, (rect.getY() + rect.getHeight() / 2) / PiazzaPanic.PPM);
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2 / PiazzaPanic.PPM, rect.getHeight() / 2 / PiazzaPanic.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
    }

    private Polygon createMethod(TiledMap map, int index) {
        for (MapObject object : map.getLayers().get(index).getObjects().getByType(PolygonMapObject.class)) {
            Polygon polygon = ((PolygonMapObject) object).getPolygon();
            return polygon;
        }
        return null;
    }

    private Rectangle createMethod1(TiledMap map, int index) {
        for (MapObject object : map.getLayers().get(index).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            return rect;
        }
        return null;
    }
}



