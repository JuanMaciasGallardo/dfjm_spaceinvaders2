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
import com.politecnicomalaga.sp2.managers.ScreensManager;
//import com.politecnicomalaga.sp2.managers.LanguageManager;

public class SplashScreen implements Screen {

    private Stage stage;
    private Game game;
    private Skin skin;

    public SplashScreen(final Game aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        Gdx.input.setInputProcessor(stage);

        //Label title = new Label(LanguageManager.getSingleton().getString(LanguageManager.SPLASH_LABEL), AssetsManager.getTextSkin(),"big-black");
        Label title = new Label("SPACE INVADERS", skin);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()-title.getHeight()*2);
        title.setWidth(Gdx.graphics.getWidth());
        title.setFontScale(2);

        stage.addActor(title);

        //TextButton playButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.START_BUTTON), AssetsManager.getTextSkin());
        TextButton playButton = new TextButton("PLAY", skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()-playButton.getHeight()*4);

        //Cambiar el tamaño de los botones
        //playButton.setTransform(true);
        //playButton.setScale(1.25f);

        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.PLAYING));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);

        //TextButton settingsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.SETTINGS_BUTTON), AssetsManager.getTextSkin());
        TextButton settingsButton = new TextButton("SETTINGS", skin);
        settingsButton.setWidth(Gdx.graphics.getWidth()/2);
        settingsButton.setPosition(Gdx.graphics.getWidth()/2-settingsButton.getWidth()/2,Gdx.graphics.getHeight()-settingsButton.getHeight()*6);

        settingsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Hay que cambiarlo por la SettingScreen cuando exista
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.PLAYING));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(settingsButton);

        //TextButton playButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.START_BUTTON), AssetsManager.getTextSkin());
        TextButton creditsButton = new TextButton("CREDITS", skin);
        creditsButton.setWidth(Gdx.graphics.getWidth()/2);
        creditsButton.setPosition(Gdx.graphics.getWidth()/2-creditsButton.getWidth()/2,Gdx.graphics.getHeight()-creditsButton.getHeight()*8);

        creditsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.PLAYING));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(creditsButton);


    }

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