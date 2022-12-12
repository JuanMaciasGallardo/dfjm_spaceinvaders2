package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GUISettings;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

/**
 * GameOverScreen Class. Where we can see here, the stats, played time, score, etc...
 * Created by David Montiel Nieto on 15/11/2022.
 */
public class GameOverScreen implements Screen {

    private Stage stage;
    private Game game;

    private Sound sndClick;

    public GameOverScreen(Game aGame) {
        game = aGame;

        // SOUND CREATION.
        sndClick = Gdx.audio.newSound(Gdx.files.internal(AssetsManager.SND_CLICK));

        // THIS SENTENCE CAN BE TYPED IN SHOW() TOO.
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // CREATE A TYPINGLABELs
        Label textPlay = createLabel(LanguageManager.getSingleton().getString(LanguageManager.LBL_PLAY_ID), GUISettings.COLOR_PLAY, 0, 60);
         textPlay.setFontScale(1f);
        Label textGameName = createLabel(LanguageManager.getSingleton().getString(LanguageManager.LBL_GAME_NAME_ID), GUISettings.COLOR_GAME_NAME, 0, (int) textPlay.getY() - 60);
         textGameName.setFontScale(1f);
        Label textCorporationName = createLabel(LanguageManager.getSingleton().getString(LanguageManager.LBL_STUDIOS_NAME_ID), GUISettings.COLOR_CORPORATION_GAME, 0, -190);
         textCorporationName.setFontScale(1f);
        Label textScore = createLabel(LanguageManager.getSingleton().getString(LanguageManager.LBL_MONEY_ID), GUISettings.COLOR_CREDIT, 160, -250);
         textScore.setFontScale(1f);
        Label textScoreValue = createLabel("0", GUISettings.COLOR_CREDIT_VALUE, (int) textScore.getX() + 130, (int) textScore.getY());
         textScoreValue.setFontScale(1f);

        // ADD THE LABELs TO THE STAGE
        stage.addActor(textPlay);
        stage.addActor(textGameName);
        stage.addActor(textCorporationName);
        stage.addActor(textScore);
        stage.addActor(textScoreValue);

        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }//EVENT

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                sndClick.play();
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SPLASH));
            }//EVENT
        });
    }//Constructor

    public Label createLabel(String text, Color color, int x, int y){
        text = setSpaceInLetters(text);
        Label label = new Label(text, AssetsManager.getSingleton().getTextSkin());
        label.setBounds(x, y, stage.getWidth(), stage.getHeight());
        label.setColor(color);
        label.setAlignment(Align.center);
        label.setFontScale(2);

        return label;
    }//CREATELABEL

    public String setSpaceInLetters(String text) {
        String newText ="";
        newText += text.charAt(0);

        for (int f=1; f<text.length(); f++) {
            newText += " "+text.charAt(f);
        }//FOR

        return newText;
    }//SETSPACEINLETTERS

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
    }//SHOW

    @Override
    public void render(float delta) {
        //jave 8

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
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