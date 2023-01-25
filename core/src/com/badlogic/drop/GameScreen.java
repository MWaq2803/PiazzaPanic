//package com.badlogic.drop;
//
//import java.util.Iterator;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.TimeUtils;
//
//public class GameScreen implements Screen {
//
//    final PiazzaPanic game;
//
//    Texture dropImage;
//    Texture bucketImage;
//    Sound dropSound;
//    Music rainMusic;
//    OrthographicCamera camera;
//    Rectangle cook;
//    Array<Rectangle> raindrops;
//    Array<Rectangle> cooks;
//    long lastDropTime;
//    int dropsGathered;
//
//    public GameScreen(final PiazzaPanic game) {
//        this.game = game;
//
//        // load the images for the droplet and the bucket, 64x64 pixels each
//        dropImage = new Texture(Gdx.files.internal("droplet.png"));
//        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
//
//        // load the drop sound effect and the rain background "music"
//        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
//        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
//        rainMusic.setLooping(true);
//
//        // create the camera and the SpriteBatch
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
//
//         //create a Rectangle to logically represent the cook
//        cook = new Rectangle();
//        cook.x = 800 / 2; // center the bucket horizontally
//        cook.y = 480 / 2; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
//        cook.width = 64;
//        cook.height = 64;
//
//
//
//        // create the raindrops array and spawn the first raindrop
//        // raindrops = new Array<Rectangle>();
//        // spawnRaindrop();
//
//    }
//    private void spawnRaindrop() {
//        Rectangle raindrop = new Rectangle();
//        raindrop.x = MathUtils.random(0, 800 - 64);
//        raindrop.y = 480;
//        raindrop.width = 64;
//        raindrop.height = 64;
//        raindrops.add(raindrop);
//        lastDropTime = TimeUtils.nanoTime();
//    }
//
//    @Override
//    public void render(float delta) {
//        // clear the screen with a dark blue color. The
//        // arguments to clear are the red, green
//        // blue and alpha component in the range [0,1]
//        // of the color to be used to clear the screen.
//        ScreenUtils.clear(0, 0, 0.2f, 1);
//
//        // tell the camera to update its matrices.
//        camera.update();
//
//        // tell the SpriteBatch to render in the
//        // coordinate system specified by the camera.
//        game.batch.setProjectionMatrix(camera.combined);
//
//        // begin a new batch and draw the bucket and all drops
//        game.batch.begin();
//        //game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);
//        game.batch.draw(bucketImage, cook.x, cook.y);
//        //for (Rectangle raindrop : raindrops) {
//        //    game.batch.draw(dropImage, raindrop.x, raindrop.y);
//        //}
//
//
//        game.batch.end();
//
//        if (Gdx.input.isKeyPressed(Keys.LEFT))
//            cook.x -= 500 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Keys.RIGHT))
//            cook.x += 500 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Keys.UP))
//            cook.y += 500 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed((Keys.DOWN)))
//            cook.y -= 500 * Gdx.graphics.getDeltaTime();
//
//
//        // make sure the bucket stays within the screen bounds
//        if (cook.x < 0)
//            cook.x = 0;
//        if (cook.x > 800 - 64)
//            cook.x = 800 - 64;
//        if (cook.y < 0)
//            cook.y = 0;
//        if (cook.y > 480 - 64)
//            cook.y = 480 - 64;
//
//        // check if we need to create a new raindrop
//        //if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
//        //    spawnRaindrop();
//
//        // move the raindrops, remove any that are beneath the bottom edge of
//        // the screen or that hit the bucket. In the later case we play back
//        // a sound effect as well.
////        Iterator<Rectangle> iter = raindrops.iterator();
////        while (iter.hasNext()) {
////            Rectangle raindrop = iter.next();
////            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
////            if (raindrop.y + 64 < 0)
////                iter.remove();
////            if (raindrop.overlaps(cook)) {
////                dropsGathered++;
////                dropSound.play();
////                iter.remove();
////            }
////        }
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void show() {
//        // start the playback of the background music
//        // when the screen is shown
//        rainMusic.play();
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void dispose() {
//        dropImage.dispose();
//        bucketImage.dispose();
//        dropSound.dispose();
//        rainMusic.dispose();
//    }
//
//}