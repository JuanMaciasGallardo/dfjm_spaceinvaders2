package com.politecnicomalaga.sp2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class GdxSpaceInvaders2 extends Game {
	SpriteBatch batch;
    OrthographicCamera camera;
	ScreensManager scMg;
	GameManager gmMg;
	// añadimos Screens
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		scMg = new ScreensManager(this, ScreensManager.Screens.PLAYING);
		gmMg = new GameManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		//scMg.render(gmMg.getGameTime());
		scMg.render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
