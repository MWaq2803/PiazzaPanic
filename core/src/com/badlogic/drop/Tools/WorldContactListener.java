package com.badlogic.drop.Tools;

import com.badlogic.drop.Sprites.Cook;
import com.badlogic.gdx.physics.box2d.*;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        if ((fixA.getUserData() == "cook" && fixB.getUserData() == "Pantry") || (fixA.getUserData() == "Pantry" && fixB.getUserData() == "cook")){
            System.out.println("The cook has collided with the pantry!");
        }
        else if ((fixA.getUserData() == "cook" && fixB.getUserData() == "Counter") || (fixA.getUserData() == "Counter" && fixB.getUserData() == "cook")){
            System.out.println("The cook has collided with the counter!");
        }
        else if ((fixA.getUserData() == "cook" && fixB.getUserData() == "CuttingStation") || (fixA.getUserData() == "CuttingStation" && fixB.getUserData() == "cook")){
            System.out.println("The cook has collided with the cutting station!");
        }
        else if ((fixA.getUserData() == "cook" && fixB.getUserData() == "FryingStation") || (fixA.getUserData() == "FryingStation" && fixB.getUserData() == "cook")){
            System.out.println("The cook has collided with the frying station!");
        }
        else if ((fixA.getUserData() == "cook" && fixB.getUserData() == "ServingStation") || (fixA.getUserData() == "ServingStation" && fixB.getUserData() == "cook")){
            System.out.println("The cook has collided with the serving station!");
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
