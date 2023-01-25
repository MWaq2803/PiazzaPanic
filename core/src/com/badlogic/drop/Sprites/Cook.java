package com.badlogic.drop.Sprites;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PlayScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.sun.javafx.geom.Edge;

public class Cook extends Sprite {
    public World world;
    public Body b2body;
    Texture cookTexture;


    public Cook(PlayScreen screen) {
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
        bdef.position.set(32 / PiazzaPanic.PPM,200 / PiazzaPanic.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(60 / PiazzaPanic.PPM);
        fdef.filter.categoryBits = PiazzaPanic.COOK_BIT;
        fdef.filter.maskBits = PiazzaPanic.DEFAULT_BIT | PiazzaPanic.COUNTER_BIT | PiazzaPanic.PANTRY_BIT | PiazzaPanic.CUTTINGSTATION_BIT | PiazzaPanic.FRYINGSTATION_BIT | PiazzaPanic.SERVINGSTATION_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-20 / PiazzaPanic.PPM, 60 / PiazzaPanic.PPM), new Vector2(20 / PiazzaPanic.PPM, 60 / PiazzaPanic.PPM));
        fdef.shape = head;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData("head");
    }


}
