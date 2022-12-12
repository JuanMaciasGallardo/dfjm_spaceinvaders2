package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;


import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class SettingsScreen implements Screen {
   private Stage stage;
    private Game game;
    public SettingsScreen(Game agame){

        stage = new Stage(new ScreenViewport());
        game=agame;
        Gdx.input.setInputProcessor(stage);

        //LABELS
        Label lSettings;
        Skin skin = AssetsManager.getSingleton().getTextSkin();

        //LanguageManager.getSingleton().getString(LanguageManager.lCredits)
        lSettings = new Label(LanguageManager.getSingleton().getString(LanguageManager.BTN_CONFIG_ID), skin);
        lSettings.setAlignment(Align.center);
        lSettings.setY(stage.getHeight()-lSettings.getHeight()*2);
        lSettings.setWidth(stage.getWidth());

        //BUTTONS
        TextButton bSpanish= new TextButton("Espaniol",skin);
        TextButton bEnglish= new TextButton("English",skin);
        TextButton bGerman= new TextButton("Deutsch",skin);

        stage.addActor(lSettings);
        stage.addActor(bEnglish);
        stage.addActor(bGerman);
        stage.addActor(bSpanish);


        //BUTTONS FUNCTIONS
        bSpanish.setWidth(stage.getWidth()/2);

        float btnX= Gdx.graphics.getWidth()/2 - bSpanish.getWidth()/2.5f;
        float btnWidth = stage.getWidth()/2;

        bSpanish.setWidth(btnWidth);
        bSpanish.setPosition(btnX,stage.getHeight()-bSpanish.getHeight()*2);
        bSpanish.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                changeLang(LanguageManager.Languages.SPANISH);
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SPLASH));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        bEnglish.setWidth(btnWidth);
        bEnglish.setPosition(btnX,stage.getHeight()-bEnglish.getHeight()*3);

        bEnglish.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                changeLang(LanguageManager.Languages.ENGLISH);
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SPLASH));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        bGerman.setWidth(btnWidth);
        bGerman.setPosition(btnX,stage.getHeight()-bGerman.getHeight()*4);

        bGerman.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                changeLang(LanguageManager.Languages.GERMAN);
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SPLASH));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        bSpanish.setTransform(true);
        bEnglish.setTransform(true);
        bGerman.setTransform(true);

        bSpanish.setScale(0.75f);
        bEnglish.setScale(0.75f);
        bGerman.setScale(0.75f);

    }

    private void changeLang(LanguageManager.Languages lang) {
        LanguageManager.getSingleton().setActiveLanguage(lang);
    }//CHANGELANG



    @Override
    public void show() {
        Gdx.app.log("CreditScreen","show");
    }

    @Override
    public void render(float delta) {
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
