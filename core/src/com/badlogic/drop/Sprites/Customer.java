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

public class Customer extends NPC{
    private float stateTime;
    private boolean setToDestroy;
    private boolean destroyed;
    Texture customerTexture;
    public Customer(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        stateTime = 0;
        customerTexture = new Texture("cook.png");
        setBounds(getX(),getY(),128/PiazzaPanic.PPM,128/PiazzaPanic.PPM);
        setRegion(customerTexture);
        setToDestroy = false;
        destroyed = false;

    }

    public void update(float dt){
        stateTime += dt;

        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
        }
        else if (!destroyed) {
            setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y-getHeight()/2);
        }
    }
    public void OrderFulfilled(){
        setToDestroy = true;
    }
    public void MakingOrder(){
            System.out.println("Customer is making an order");
    }
    public void draw(Batch batch){
        if(!destroyed){
            super.draw(batch);
        }
    }

    @Override

    protected void defineNPC() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(232 / PiazzaPanic.PPM,700 / PiazzaPanic.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData("customer");
    }
}
