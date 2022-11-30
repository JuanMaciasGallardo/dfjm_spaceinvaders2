package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class EnemyBullet extends Actor {

    private Animation<TextureRegion> skin;
    private EnemyShip enemyShip;

    private float iniX;

    private Rectangle body;


    public EnemyBullet(EnemyShip enemyShip) {
        super();
        this.enemyShip = enemyShip;
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_PATH));
        skin = new Animation<TextureRegion>(SettingsManager.BULLET_ANIMATION_TIME, atlas.findRegions(AssetsManager.REGION_ENEMY_SHOT));

        this.setBounds(0, 0, SettingsManager.ENEMY_BULLET_WIDTH,  SettingsManager.ENEMY_BULLET_HEIGHT);

        iniX = enemyShip.getWidth()/2 - getWidth()/2;
        this.setX(enemyShip.getX() + iniX);
        this.setY(enemyShip.getY());
    }//PLAYERSPACESHIP

    public void changeOfEnemy(EnemyShip enemy) {
        enemyShip.removeBullet();
        enemyShip = enemy;

        setX(enemyShip.getX() + iniX);
        setY(enemyShip.getY());
        enemyShip.addBullet(this);
    }//RESETPOS

    public EnemyShip getEnemyShip() {
        return enemyShip;
    }//GETENEMYSHIP

    public Rectangle getBody() {
        return body = new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }//GETBODY

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY(), SettingsManager.ENEMY_BULLET_WIDTH,  SettingsManager.ENEMY_BULLET_HEIGHT);
    }//DRAW
}//CLASS