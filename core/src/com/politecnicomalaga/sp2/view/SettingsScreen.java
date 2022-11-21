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
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        //LanguageManager.getSingleton().getString(LanguageManager.lCredits)
        lSettings = new Label("Settings", skin);
        lSettings.setAlignment(Align.center);
        lSettings.setY(stage.getHeight()-lSettings.getHeight()*2);
        lSettings.setWidth(stage.getWidth());
        //BUTTONS
        TextButton bSpanish= new TextButton("Spanish",skin);
        TextButton bEnglish= new TextButton("English",skin);
        TextButton bGerman= new TextButton("German",skin);

        stage.addActor(lSettings);
        stage.addActor(bEnglish);
        stage.addActor(bGerman);
        stage.addActor(bSpanish);


        //BUTTONS FUNCTIONS



        bSpanish.setWidth(stage.getWidth()/2);
        float buttonsWidth= stage.getWidth()/2-bSpanish.getWidth()/2;
        bSpanish.setPosition(buttonsWidth,stage.getHeight()-bSpanish.getHeight()*4);
        bSpanish.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
               //LanguageManager.getSingleton().setActiveLanguage(LanguageManager.Screens.SPANISH);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        bEnglish.setWidth(stage.getWidth()/2);
        bEnglish.setPosition(buttonsWidth,stage.getHeight()-bSpanish.getHeight()*8);

        bEnglish.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //LanguageManager.getSingleton().setActiveLanguage(LanguageManager.Screens.ENGLISH);

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });


        bGerman.setWidth(stage.getWidth()/2);
        bGerman.setPosition(buttonsWidth,stage.getHeight()-bSpanish.getHeight()*12);

        bGerman.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //LanguageManager.getSingleton().setActiveLanguage(LanguageManager.Screens.GERMAN);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

    }



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
