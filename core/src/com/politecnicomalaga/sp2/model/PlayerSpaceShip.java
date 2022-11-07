package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.GameManager;

public class PlayerSpaceShip extends Actor {

    private Animation<TextureRegion> skin;

    public PlayerSpaceShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/player.pack"));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions("blue"), Animation.PlayMode.LOOP);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY());
    }
}
