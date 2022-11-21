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

public class CreditsScreen implements Screen {
    private Stage stage;
    private Game game;

    private String JUAN="Juan Macias Gallardo",
            MIGUEL="Miguel Pina Guerrero",
            DAVID = "David Montiel Nieto",
            FELIPE="Felipe Gonzalez Villablanca",
            KOJIMA="Hideo Kojima",
            CTHULHU="Cthulhu",
            ENTERPRISE="Kartoffel Studios",
            JUNIT="JUnit",
            TEACHER="Andres Alcaraz Rey";


    public CreditsScreen(Game agame){
        //STRINGS WITH EACH ONE NAME


        Label lCredits;
        Label lEnterprise = null;

        //CATEGORY+PEOPLE IN IT
        Label lJUnitSupremeLider;
        Label lJuan;
        Label lHideoKojima1;

        //CATEGORY+PEOPLE IN IT
        Label lJUnitGigaChad;

        Label lMiguel;
        Label lDavid;
        Label lFelipe;
        Label lHideoKojima2;

        //CATEGORY+PEOPLE IN IT
        Label lHonorableMentions;
        Label lJunit;
        Label lPotato;
        Label lTeacher;
        Label lHideoKojima3;
        Label lChulhu;

        //BUTTON
        Skin skin = AssetsManager.getSingleton().getTextSkin();

        stage = new Stage(new ScreenViewport());
        game=agame;
        Gdx.input.setInputProcessor(stage);

        //Labels
        lCredits = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_CREDITS_ID), skin);
        lCredits.setFontScale(1.5f);
        lCredits.setAlignment(Align.center);
        lCredits.setY(stage.getHeight()-lCredits.getHeight()*2);
        lCredits.setWidth(stage.getWidth());

        lEnterprise = new Label(ENTERPRISE, skin);
        lEnterprise.setFontScale(1.25f);
        lEnterprise.setAlignment(Align.center);
        lEnterprise.setY(stage.getHeight()-lEnterprise.getHeight()*3.5f);
        lEnterprise.setWidth(stage.getWidth());

        lJUnitSupremeLider = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_LEADER_ID),skin);
        lJUnitSupremeLider.setFontScale(1.1f);
        lJUnitSupremeLider.setAlignment(Align.center);
        lJUnitSupremeLider.setY(stage.getHeight()-lEnterprise.getHeight()*5f);
        lJUnitSupremeLider.setWidth(stage.getWidth());

        lJuan = new Label(JUAN,skin);
        lJuan.setAlignment(Align.center);
        lJuan.setY(stage.getHeight()-lEnterprise.getHeight()*6.25f);
        lJuan.setWidth(stage.getWidth());

        lHideoKojima1 = new Label(KOJIMA,skin);
        lHideoKojima1.setAlignment(Align.center);
        lHideoKojima1.setY(stage.getHeight()-lEnterprise.getHeight()*7.25f);
        lHideoKojima1.setWidth(stage.getWidth());

        lJUnitGigaChad = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_WORKER_ID), skin);
        lJUnitGigaChad.setFontScale(1.1f);
        lJUnitGigaChad.setAlignment(Align.center);
        lJUnitGigaChad.setY(stage.getHeight()-lEnterprise.getHeight()*8.5f);
        lJUnitGigaChad.setWidth(stage.getWidth());

        lMiguel = new Label(MIGUEL, skin);
        lMiguel.setAlignment(Align.center);
        lMiguel.setY(stage.getHeight()-lEnterprise.getHeight()*9.75f);
        lMiguel.setWidth(stage.getWidth());

        lDavid = new Label(DAVID, skin);
        lDavid.setAlignment(Align.center);
        lDavid.setY(stage.getHeight()-lEnterprise.getHeight()*10.75f);
        lDavid.setWidth(stage.getWidth());

        lFelipe = new Label(FELIPE, skin);
        lFelipe.setAlignment(Align.center);
        lFelipe.setY(stage.getHeight()-lEnterprise.getHeight()*11.75f);
        lFelipe.setWidth(stage.getWidth());

        lHideoKojima2 = new Label(KOJIMA, skin);
        lHideoKojima2.setAlignment(Align.center);
        lHideoKojima2.setY(stage.getHeight()-lEnterprise.getHeight()*12.75f);
        lHideoKojima2.setWidth(stage.getWidth());

        lHonorableMentions = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_HONOURS_ID), skin);
        lHonorableMentions.setFontScale(1.1f);
        lHonorableMentions.setAlignment(Align.center);
        lHonorableMentions.setY(stage.getHeight()-lEnterprise.getHeight()*14);
        lHonorableMentions.setWidth(stage.getWidth());

        lJunit = new Label(JUNIT, skin);
        lJunit.setAlignment(Align.center);
        lJunit.setY(stage.getHeight()-lEnterprise.getHeight()*15.25f);
        lJunit.setWidth(stage.getWidth());

        lPotato = new Label(LanguageManager.getSingleton().getString(LanguageManager.LBL_POTATO_ID), skin);
        lPotato.setAlignment(Align.center);
        lPotato.setY(stage.getHeight()-lEnterprise.getHeight()*16.25f);
        lPotato.setWidth(stage.getWidth());

        lTeacher = new Label(TEACHER, skin);
        lTeacher.setAlignment(Align.center);
        lTeacher.setY(stage.getHeight()-lEnterprise.getHeight()*17.25f);
        lTeacher.setWidth(stage.getWidth());

        lHideoKojima3 = new Label(KOJIMA, skin);
        lHideoKojima3.setAlignment(Align.center);
        lHideoKojima3.setY(stage.getHeight()-lEnterprise.getHeight()*18.25f);
        lHideoKojima3.setWidth(stage.getWidth());

        lChulhu = new Label(CTHULHU, skin);
        lChulhu.setAlignment(Align.center);
        lChulhu.setY(stage.getHeight()-lEnterprise.getHeight()*19.25f);
        lChulhu.setWidth(stage.getWidth());


        //STAGE ACTORS
        stage.addActor(lCredits);
        stage.addActor(lEnterprise);
        stage.addActor(lJUnitSupremeLider);
        stage.addActor(lJuan);
        stage.addActor(lHideoKojima1);
        stage.addActor(lJUnitGigaChad);
        stage.addActor(lMiguel);
        stage.addActor(lDavid);
        stage.addActor(lFelipe);
        stage.addActor(lHideoKojima2);
        stage.addActor(lHonorableMentions);
        stage.addActor(lJunit);
        stage.addActor(lPotato);
        stage.addActor(lTeacher);
        stage.addActor(lHideoKojima3);
        stage.addActor(lChulhu);

        //TO EXIT THE SCREEN BY PRESSING IT
        stage.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.SPLASH));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    //AssetsManager.getSingleton().getTextSkin();



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


