package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.GameManager;

public class EnemyShip extends Actor {

    private Animation<TextureRegion> skin;
    private float x;
    private float y;

    public EnemyShip(float posX,float posY) {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("sp2.atlas"));
        skin = new Animation<TextureRegion>(2.0f, atlas.findRegions("ovni"), Animation.PlayMode.LOOP);
        x = posX;
        y = posY;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, x, y, 50,  50);
    }

}
