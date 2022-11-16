package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

import java.util.Stack;

public class PlayerSpaceShip extends Actor {

    private Animation<TextureRegion> skin;
    private Array<HeroBullet> activeBullets;
    private Stack<HeroBullet> inactiveBullets;

    private float deltaBullet;

    private boolean canShoot;


    public PlayerSpaceShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_PATH));
        skin = new Animation<TextureRegion>(SettingsManager.PLAYER_ANIMATION_TIME, atlas.findRegions(AssetsManager.REGION_PLAYER_NAME), Animation.PlayMode.LOOP);
        this.setBounds(0, 0, SettingsManager.PLAYER_SIZE,  SettingsManager.PLAYER_SIZE);
        this.setX(SettingsManager.PLAYER_HOR_POS - SettingsManager.PLAYER_SIZE/2);
        this.setY(SettingsManager.PLAYER_VER_POS);

        deltaBullet = GameManager.getSingleton().getGameTime();

        // INICIALIZE THREAD SHOOT
        activeBullets = new Array<HeroBullet>();
        inactiveBullets = new Stack<HeroBullet>();
    }//PLAYERSPACESHIP

    public boolean canShoot() {
        return canShoot;
    }//CANSHOOT

    public void canShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }//CANSHOOT

    public void shoot() {
        if (inactiveBullets.size() == 0) {
            activeBullets.add(new HeroBullet(this));
        } else {
            HeroBullet newBullet = inactiveBullets.pop();
            newBullet.resetPos();
            activeBullets.add(newBullet);
        }//IF
    }//SHOOT

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // CHECK WHEN THE PLAYER CAN SHOOT
        if (canShoot()) {
            if (deltaBullet+SettingsManager.PLAYER_SHOOT_TIME < GameManager.getSingleton().getGameTime()) {
                deltaBullet = GameManager.getSingleton().getGameTime();
                shoot();
            }//IF
        }//IF

        // TO TRANSFER BULLETS
        for (int f=0; f<activeBullets.size; f++) {
            if (activeBullets.get(f).getY() > SettingsManager.SCREEN_HEIGHT) {
                HeroBullet newBullet = activeBullets.get(f);
                activeBullets.removeIndex(f);
                inactiveBullets.push(newBullet);
            } else {
                break;
            }//IF
        }//FOR

        // PAINT
        for (int f=0; f<activeBullets.size; f++) {
            activeBullets.get(f).setY(activeBullets.get(f).getY()+2);
            activeBullets.get(f).draw(batch, parentAlpha);
        }//FOR

        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY(), SettingsManager.PLAYER_SIZE,  SettingsManager.PLAYER_SIZE);
    }//DRAW
}//CLASS