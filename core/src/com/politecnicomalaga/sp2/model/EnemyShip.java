package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class EnemyShip extends Actor {

    // VARIABLES.

    private Animation<TextureRegion> skin;
    private float x;
    private float y;

    public EnemyShip(float posX,float posY) {
        super();
        TextureAtlas atlas = new TextureAtlas(AssetsManager.ATLAS_PATH);
        skin = new Animation<TextureRegion>(SettingsManager.ENEMY_ANIMATION_TIME,
                atlas.findRegions(AssetsManager.REGION_ENEMY_NAME),
                Animation.PlayMode.LOOP);
        x = posX;
        y = posY;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, x, y, SettingsManager.ENEMY_SIZE, SettingsManager.ENEMY_SIZE);
    }

}
