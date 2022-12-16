package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
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
    private Rectangle body;

    private float deltaBullet;

    private boolean isShooting;
    private Sound sndShot;

    public PlayerSpaceShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_PATH));
        skin = new Animation<TextureRegion>(SettingsManager.PLAYER_ANIMATION_TIME, atlas.findRegions(AssetsManager.REGION_PLAYER_NAME), Animation.PlayMode.LOOP);
        this.setBounds(0, 0, SettingsManager.PLAYER_SIZE,  SettingsManager.PLAYER_SIZE);
        this.setX(SettingsManager.PLAYER_HOR_POS - SettingsManager.PLAYER_SIZE/2);
        this.setY(SettingsManager.PLAYER_VER_POS);

        // UPDATE RECTANGLE
        updateBody();

        deltaBullet = GameManager.getSingleton().getGameTime();

        sndShot = Gdx.audio.newSound(Gdx.files.internal(AssetsManager.SND_SHOT));

        // INICIALIZE THREAD SHOOT
        activeBullets = new Array<HeroBullet>();
        inactiveBullets = new Stack<HeroBullet>();
    }//PLAYERSPACESHIP

    public void canShoot(boolean canShoot) {
        isShooting = canShoot;
    }//CANSHOOT

    public void shoot() {
        sndShot.play();
        if (inactiveBullets.size() == 0) {
            activeBullets.add(new HeroBullet(this));
        } else {
            transferBullet();
        }//IF
    }//SHOOT

    public Array<HeroBullet> getBullets() {
        return activeBullets;
    }//GETBULLETS

    private void transferBullet(int pos) {
        HeroBullet newBullet = activeBullets.get(pos);
        activeBullets.removeIndex(pos);
        inactiveBullets.push(newBullet);
    }//TRANSFERBULLET

    private void transferBullet() {
        HeroBullet newBullet = inactiveBullets.pop();
        newBullet.resetPos();
        activeBullets.add(newBullet);
    }//TRANSFERBULLET

    public boolean isColliding(EnemyBullet bullet) {
        updateBody();
        return bullet.getBody().overlaps(body);
    }//ISCOLLISIONING

    private void updateBody() {
        body = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }//UPDATEBODY

    @Override
    public void act(float delta) {
        super.act(delta);

        // CHECK WHEN THE PLAYER CAN SHOOT
        if (isShooting) {
            if (deltaBullet+SettingsManager.BULLET_PLAYER_RATIO < GameManager.getSingleton().getGameTime()) {
                deltaBullet = GameManager.getSingleton().getGameTime();
                shoot();
            }//IF
        }//IF

        // TO TRANSFER BULLETS
        for (int f=0; f<activeBullets.size; f++) {
            if (activeBullets.get(f).getY() > SettingsManager.SCREEN_HEIGHT) {
                transferBullet(f);
            } else {
                break;
            }//IF
        }//FOR
    }//ACT

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // PAINT
        for (int f=0; f<activeBullets.size; f++) {
            activeBullets.get(f).setY(activeBullets.get(f).getY()+SettingsManager.BULLET_PLAYER_SPEED);
            activeBullets.get(f).draw(batch, parentAlpha);
        }//FOR

        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY(), SettingsManager.PLAYER_SIZE,  SettingsManager.PLAYER_SIZE);
    }//DRAW
}//CLASS