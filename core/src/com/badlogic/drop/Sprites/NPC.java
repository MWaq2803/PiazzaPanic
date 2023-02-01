package com.badlogic.drop.Sprites;

import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
/**
 * NPC is an abstract class that represents a non-player character
 *it contains variables that hold a reference for the world and screen,
 *represent a body and vector for velocity
 * */
public abstract class NPC extends Sprite{
    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;
    /**
     * Constructor for NPC
     * @param screen - playScreen object where the NPC resides
     * @param x - the x coordinate of the NPC
     * @param y - the y coordinate of the NPC
     * */
    public NPC(PlayScreen screen, float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x, y);
        defineNPC();
        //makes NPC move down
        velocity = new Vector2(0, -1);
    }
    protected abstract void defineNPC();

}
