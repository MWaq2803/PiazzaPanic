package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.CuttingScreen;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * The Cook class represents the sprite for a cook in the game
 * It extends the Sprite class and contains methods to manage the inventory of the Cook
 */
public class Cook extends Sprite {
    public World world;
    public Body b2body;
    private Texture cookTexture;
    private MyScreen screen;
    private Stack<String> inventory;


    /**
     * Constructor for the Cook class
     * @param screen - the screen which the cook is on
     */
    public Cook(MyScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();

        defineCook();
        //set the Texture for the cook
        cookTexture = new Texture("cook.png");

        setBounds(0,0,128 / PiazzaPanic.PPM, 128 / PiazzaPanic.PPM);
        setRegion(cookTexture);
    }

    /**
     * Method to update the position of the Cook
     * @param dt
     */
    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
    }

    /**
     * Method to define the physical properties of the Cook in the world
     */
    public void defineCook() {
        //create a new body and position for the cook
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / PiazzaPanic.PPM,300 / PiazzaPanic.PPM);
        //define the body as dynamic, so it can move
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        //create a new fixture for the cook, to detect for collisions
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData("Cook");

        inventory = new Stack<>();
    }

    /**Method to add a new item to the inventory stack
     * @param item - this item is added to the stack
     */
    public void addToInventory(String item) {
        inventory.push(item);
        System.out.println("The inventory is now" + inventory);
    }

    /**
     * Method to remove the top item from the inventory
     * If the inventory is empty then print the inventory is empty
     */
    public void removeFromInventory() {
        if(inventory.empty() == true){
            System.out.println("The inventory is empty" + inventory);
        }
        else {
            inventory.pop();
            System.out.println("The inventory is now" + inventory);
        }
    }


    public void  topIngredients(){
        System.out.println(inventory.peek());
    }
}
