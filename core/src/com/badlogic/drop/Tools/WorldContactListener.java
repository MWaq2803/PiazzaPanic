package com.badlogic.drop.Tools;

import com.badlogic.drop.PiazzaPanic;
import com.badlogic.drop.Screens.PantryScreen;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * WorldContactListener is a class that implements ContactListener interface
 * It is used to detect and handle collisions in a physics simulation
 */
public class WorldContactListener implements ContactListener  {
    private PiazzaPanic game;
    private Stage stage;

    public WorldContactListener(PiazzaPanic game, Stage stage) {
        this.game = game;
        this.stage = stage;
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
            game.setScreen(new PantryScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "CuttingStation") || (fixA.getUserData() == "CuttingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the cutting station!");
            game.setScreen(new PantryScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "FryingStation") || (fixA.getUserData() == "FryingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the frying station!");
            game.setScreen(new PantryScreen(game, stage));
        }
        else if ((fixA.getUserData() == "Cook" && fixB.getUserData() == "ServingStation") || (fixA.getUserData() == "ServingStation" && fixB.getUserData() == "Cook")){
            System.out.println("The cook has collided with the serving station!");
            game.setScreen(new PantryScreen(game, stage));
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
