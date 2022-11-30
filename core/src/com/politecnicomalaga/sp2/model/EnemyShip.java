package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class EnemyShip extends Actor {

    // VARIABLES.

    private Animation<TextureRegion> skin;
    private Rectangle body;

    private EnemyBullet bullet;


    public EnemyShip(float posX,float posY) {
        super();
        TextureAtlas atlas = new TextureAtlas(AssetsManager.ATLAS_PATH);
        skin = new Animation<TextureRegion>(SettingsManager.ENEMY_ANIMATION_TIME,
                atlas.findRegions(AssetsManager.REGION_ENEMY_NAME),
                Animation.PlayMode.LOOP);
        this.setBounds(0, 0, SettingsManager.ENEMY_SIZE,  SettingsManager.ENEMY_SIZE);
        setX(posX);
        setY(posY);
        body = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean isColliding(HeroBullet bullet) {
        return bullet.getBody().overlaps(body);
    }//ISCOLLISIONING

    public void addBullet(EnemyBullet bullet) {
        this.bullet = bullet;
    }//ADDBULLET

    public EnemyBullet getBullet() {
        return bullet;
    }

    public void removeBullet() {
        this.bullet = null;
    }//REMOVEBULLET

    public boolean isShooting() {
        if (bullet == null) {
            return false;
        }//IF

        return true;
    }//ISSHOOTING

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // PAINT BULLET
        if (bullet != null) {
            bullet.draw(batch, parentAlpha);
        }//IF

        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, getX(), getY(), SettingsManager.ENEMY_SIZE, SettingsManager.ENEMY_SIZE);
    }//DRAW
}//CLASS