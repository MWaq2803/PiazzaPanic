package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.MyScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Stack;

public class Cook extends Sprite {
    public World world;
    public Body b2body;
    private Texture cookTexture;
    private MyScreen screen;
    private Stack<String> inventory;

    public Cook(MyScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();

        defineCook();
        cookTexture = new Texture("cook.png");

        setBounds(0,0,128 / PiazzaPanic.PPM, 128 / PiazzaPanic.PPM);
        setRegion(cookTexture);
    }

    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
    }
    public void defineCook() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / PiazzaPanic.PPM,300 / PiazzaPanic.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData("Cook");

        inventory = new Stack<>();
    }

    public void addToInventory(String item) {
        inventory.push(item);
        System.out.println("The inventory is now" + inventory);
    }

    public void removeFromInventory() {
        if(inventory.empty() == true){
            System.out.println("The inventory is empty" + inventory);
        }
        else {
            inventory.pop();
            System.out.println("The inventory is now" + inventory);
        }
    }

    public String getIngredients(){
        return inventory.peek();
    }
}
