package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Collisions {

    private PlayerSpaceShip heroShip;
    private Battalion empire;

    private Game game;
    private Sound sndExplosion;

    public Collisions(PlayerSpaceShip heroShip, Battalion empire, Game game) {
        this.heroShip = heroShip;
        this.empire = empire;
        this.game = game;

        sndExplosion = Gdx.audio.newSound(Gdx.files.internal(AssetsManager.SND_EXPLOSION));
    }//Constructor

    // RETURNS IF GAME ENDS.
    public boolean checkCollisionsEmemyShip() {

        // CHECK COLLISIONS
        // FOR OF BULLETS
        for (int f=0; f<heroShip.getBullets().size; f++) {
            HeroBullet bullet = heroShip.getBullets().get(f);

            // FOR OF SQUADS
            for (int d=0; d<empire.getSquads().size; d++) {
                Squadron sq = empire.getSquads().get(d);

                // IF IS NEAR OF THE SQUAD
                if (sq.getPosY() - SettingsManager.ENEMY_SIZE < bullet.getY()) {
                    // FOR OF TROOPS
                    for (int c=0; c<sq.getTroops().size; c++) {
                        EnemyShip enemy = sq.getTroops().get(c);

                        // IF COLLISION
                        if (enemy.isColliding(bullet)) {
                            heroShip.getBullets().removeIndex(f);
                            bullet.remove();

                            sndExplosion.play();
                            sq.getTroops().removeIndex(c);
                            enemy.removeWhenYouCan();

                            if (empire.getSquads().get(d).getTroops().size == 0) {
                                empire.getSquads().removeIndex(d);
                            }//IF

                            if (empire.getSquads().size == 0) {
                                return true;
                            }//IF
                        }//IF
                    }//FOR
                } else {
                    break;
                }//IF
            }//FOR
        }//FOR

        return false;
    }//COLLISIONS

    // RETURNS IF GAME ENDS
    public boolean checkCollisionsPlayerSpaceShip() {
        Array<EnemyBullet> activeBullets = empire.getActiveBullets();
        for (int f=0; f<activeBullets.size; f++) {
            EnemyBullet enemyBullet = activeBullets.get(f);

            // IF IS NEAR OF THE PLAYER
            if (heroShip.getY() + enemyBullet.getHeight() > enemyBullet.getY()) {
                // IF COLLISION
                if (heroShip.isColliding(enemyBullet)) {
                    sndExplosion.play();
                    return true;
                }//IF
            }//IF
        }//FOR

        return false;
    }//COLLISIONS
}//CLASS