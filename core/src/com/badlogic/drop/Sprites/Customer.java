package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.graphics.Texture;


public class Customer extends NPC{
    private float stateTime;
    Texture customerTexture;
    public Customer(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        stateTime = 0;
        customerTexture = new Texture("cook.png");
        setBounds(getX(),getY(),128/PiazzaPanic.PPM,128/PiazzaPanic.PPM);
        setRegion(customerTexture);
    }

    public void update(float dt){
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y-getHeight()/2);
    }

    @Override

    protected void defineNPC() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / PiazzaPanic.PPM,200 / PiazzaPanic.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData("cook");
    }
}
