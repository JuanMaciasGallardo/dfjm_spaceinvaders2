package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class PlayerSpaceShip extends Actor {
    private Animation<TextureRegion> skin;

    public PlayerSpaceShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("sp2.atlas"));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions("player"), Animation.PlayMode.LOOP);
        this.setBounds(0, 0, 50,  50);
        this.setX(0);
        this.setY(0);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY(), 50,  50);
    }
}
