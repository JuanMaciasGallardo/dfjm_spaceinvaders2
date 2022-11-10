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
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.model.Battalion;
import com.politecnicomalaga.sp2.model.PlayerSpaceShip;

/**
 * GameScreen Class. Where we play the game and we have the main battle
 * Created by Andrés Alcaraz Rey on 5/11/2022.
 *
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;

    private PlayerSpaceShip heroShip;


    public GameScreen(Game aGame) {
        game = aGame;

        //Esta orden se puede poner también en el show()
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // ADD THE BATTALION
        //Battalion empire = new Battalion(stage);

        // ADD PLAYER WITH EVENTS
        heroShip = new PlayerSpaceShip();
        stage.addActor(heroShip);
        heroShip.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }//EVENT

            // CHANGE THE X OF THE PLAYER
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                heroShip.setX(Gdx.input.getX() - SettingsManager.PLAYER_SIZE/2);
                heroShip.setY(SettingsManager.SCREEN_HEIGHT - Gdx.input.getY() - SettingsManager.PLAYER_SIZE/2);
            }//EVENT

            /*
            public void clicked(InputEvent event, float x, float y, int pointer, int button) { }//EVENT
            @Override public void touchUp(InputEvent event, float x, float y, int pointer, int button) { }//EVENT
            */
        });
        heroShip.setTouchable(Touchable.enabled);
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
        stage.act();
        stage.draw();
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