package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.model.Battalion;
import com.politecnicomalaga.sp2.model.Collisions;
import com.politecnicomalaga.sp2.model.EnemyShip;
import com.politecnicomalaga.sp2.model.HeroBullet;
import com.politecnicomalaga.sp2.model.PlayerSpaceShip;
import com.politecnicomalaga.sp2.model.Squadron;

/**
 * GameScreen Class. Where we play the game and we have the main battle
 * Created by Andrés Alcaraz Rey on 5/11/2022.
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;

    private Battalion empire;
    private PlayerSpaceShip heroShip;

    private Collisions collisions;


    public GameScreen(Game aGame) {
        game = aGame;

        // THIS SENTENCE CAN BE TYPED IN SHOW() TOO.
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // ADD THE BATTALION
        empire = new Battalion(stage);
        empire.addActors();

        // ADD PLAYER WITH EVENTS
        heroShip = new PlayerSpaceShip();
        stage.addActor(heroShip);

        // EVENTS FOR THE PLAYER
        heroShip.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                heroShip.canShoot(true);

                return true;
            }//EVENT

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                heroShip.canShoot(false);
            }//EVENT

            // CHANGE THE X OF THE PLAYER
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (Gdx.input.getX() > 0 + heroShip.getWidth() && Gdx.input.getX() < stage.getWidth() - heroShip.getWidth()) {
                    heroShip.setX(Gdx.input.getX() - SettingsManager.PLAYER_SIZE/2);
                }//IF

                //heroShip.setY(SettingsManager.SCREEN_HEIGHT - Gdx.input.getY() - SettingsManager.PLAYER_SIZE/2);
            }//EVENT
        });
        heroShip.setTouchable(Touchable.enabled);

        // ADD COLLISIONS CONTROLLER
        collisions = new Collisions(heroShip, empire, game);
    }//Constructor

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
    }//SHOW

    @Override
    public void render(float delta) {
        //jave 8

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // RENDER COLLISIONS
        collisions.checkCollisionsEmemyShip();
        collisions.checkCollisionsPlayerSpaceShip();

        // PAINT ACTORS
        stage.act(delta);
        stage.draw();

        // BATALLION AUTO SHOT
        empire.shoot();
    }//RENDER

    @Override
    public void dispose() {
        stage.dispose();
    }//DISPOSE

    @Override public void resize(int width, int height) {}//RESIZE

    @Override public void pause() {}//PAUSE

    @Override public void resume() {}//RESUME

    @Override public void hide() {}//HIDE
}//CLASS