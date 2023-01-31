package com.badlogic.drop.Tools;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.CuttingScreen;
import com.badlogic.drop.Screens.FryingScreen;
import com.badlogic.drop.Screens.PantryScreen;
import com.badlogic.drop.Screens.ServingScreen;
import com.badlogic.drop.Sprites.Cook;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.drop.Sprites.Customer;
import com.badlogic.drop.Sprites.NPC;

/**
 * WorldContactListener is a class that implements ContactListener interface
 * It is used to detect and handle collisions in a physics simulation
 */
public class WorldContactListener implements ContactListener  {
    private PiazzaPanic game;
    private Stage stage;
    protected Cook cook;

    public WorldContactListener(PiazzaPanic game, Stage stage,Cook cook) {
        this.game = game;
        this.stage = stage;
        this.cook = cook;
    }
    /**
     * BeginContact is a method which acts when the sprite first touches the interactive tile object
     * @param contact - represents the collision
     */
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        //used to get the two fixtures involved in the collision

        if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "Pantry") || (fixA.getUserData() == "Pantry" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the pantry!");
            game.setScreen(new PantryScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "Counter") || (fixA.getUserData() == "Counter" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the counter!");
            //game.setScreen(new PantryScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "CuttingStation") || (fixA.getUserData() == "CuttingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the cutting station!");
            game.setScreen(new CuttingScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "FryingStation") || (fixA.getUserData() == "FryingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the frying station!");
            game.setScreen(new FryingScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "ServingStation") || (fixA.getUserData() == "ServingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the serving station!");
            game.setScreen(new ServingScreen(game, stage));
        }
        else if ((fixA.getUserData() == "customer" && fixB.getUserData() == "Counter") || (fixA.getUserData() == "Counter" && fixB.getUserData() == "customer")){
            System.out.println("The customer has collided with the counter!");
            //this does not work because it tries to parse a string to a class
            if(fixA.getUserData() == "customer"){
                ((Customer)fixA.getUserData()).MakingOrder();
            }
            else if(fixB.getUserData() == "customer"){
                ((Customer)fixB.getUserData()).MakingOrder();
            }
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
