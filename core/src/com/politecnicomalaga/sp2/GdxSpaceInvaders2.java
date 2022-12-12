package com.politecnicomalaga.sp2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.view.GameScreen;

public class GdxSpaceInvaders2 extends Game {

	SpriteBatch batch;
    OrthographicCamera camera;
	ScreensManager scMg;
	GameManager gmMg;
	GameScreen gs;
	Screen activeScreen;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		scMg = ScreensManager.getSingleton();
		gmMg = GameManager.getSingleton();
		camera = new OrthographicCamera();
		gs = new GameScreen(this);

		activeScreen = scMg.getScreen(this, ScreensManager.Screens.SPLASH);
		this.setScreen(activeScreen);

		camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
	}//CREATE

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		// ADD DELTA TIME
		GameManager.getSingleton().addDelta();

		// PAINT SCREEN
		batch.begin();
		this.getScreen().render(Gdx.graphics.getDeltaTime());
		batch.end();
	}//RENDER
	
	@Override
	public void dispose () {
		batch.dispose();
	}//DISPOSE
}//CLASS