package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.graphics.Texture;
/**
 *Customer is a class that extends NPC
 *it is an object that represents the customers in the game
 */
public class Customer extends NPC{
    private float stateTime;
    private boolean setToDestroy;
    private boolean destroyed;
    Texture customerTexture;

    /**
     * Constructor for Customer
     * @param screen - playScreen where the Customer resides
     * @param x - x coordinate for the Customer
     * @param y - y coordinate for the Customer
     */
    public Customer(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        stateTime = 0;
        customerTexture = new Texture("customer.png");
        setBounds(getX(),getY(),128/PiazzaPanic.PPM,128/PiazzaPanic.PPM);
        setRegion(customerTexture);
        setToDestroy = false;
        destroyed = false;

    }
/**
 * update is a subroutine that is called every frame updating the position of the Customer and checking the customer does not need to be removed
 */
    public void update(float dt){
        stateTime += dt;

        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
        }
        else if (!destroyed) {
            setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y-getHeight()/2);
            b2body.setLinearVelocity(velocity);
        }
    }

    /**
     *OrderFulfilled is a subroutine that is called when the customers order is completed that sets the customer to be removed
     */
    public void OrderFulfilled(){
        setToDestroy = true;
    }
    /**
     *MakingOrder is a subroutine that is called when the customer is making an order
     */
    public void MakingOrder(){
            System.out.println("Customer is making an order");
    }

    /**
     * draw is a subroutine that overrides draw that is called every frame and makes sure that customers that have been destroyed are not drawn
     */
    public void draw(Batch batch){
        if(!destroyed){
            super.draw(batch);
        }
    }

    @Override
/**
 *defineNPC is a subroutine that is called in the constructor that defines the Customers body, and fixture for reference throughout the programme
 */
    protected void defineNPC() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(575 / PiazzaPanic.PPM,900 / PiazzaPanic.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData("customer");
    }
}
