package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.GdxSpaceInvaders2;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
//import com.politecnicomalaga.sp2.managers.LanguageManager;

public class SplashScreen implements Screen {

    private Stage stage;
    private Game game;
    private Skin skin;

    public SplashScreen(final Game aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());

        skin = AssetsManager.getSingleton().getTextSkin();

        Gdx.input.setInputProcessor(stage);

        // LABEL
        Label title = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_GAME_NAME_ID), skin);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()-title.getHeight()*2);
        title.setWidth(Gdx.graphics.getWidth());
        title.setFontScale(2);

        // BUTTONs
        TextButton playButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.LBL_PLAY_ID), skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(stage.getWidth()/2 - playButton.getWidth()/2.5f,stage.getHeight()/2 + playButton.getHeight()/2.5f);

        TextButton settingsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.BTN_CONFIG_ID), skin);
        settingsButton.setWidth(Gdx.graphics.getWidth()/2);
        settingsButton.setPosition(stage.getWidth()/2 - settingsButton.getWidth()/2.5f,stage.getHeight()/2 - settingsButton.getHeight()/2.5f * 2);

        TextButton creditsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.LBL_CREDITS_ID), skin);
        creditsButton.setWidth(Gdx.graphics.getWidth()/2);
        creditsButton.setPosition(stage.getWidth()/2 - creditsButton.getWidth()/2.5f,stage.getHeight()/5 - creditsButton.getHeight()/2.5f);

        // EVENTS
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.GAME));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        settingsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SETTINGS));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        creditsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.CREDITS));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        // ADD TO ACTOR
        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(settingsButton);
        stage.addActor(creditsButton);

        //CHANGE BTN SIZE
        playButton.setTransform(true);
        settingsButton.setTransform(true);
        creditsButton.setTransform(true);

        playButton.setScale(0.75f);
        settingsButton.setScale(0.75f);
        creditsButton.setScale(0.75f);
    }//Constructor

    @Override
    public void show() {
        Gdx.app.log("SplashScreen","show");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }


}