package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Collisions {

    private PlayerSpaceShip heroShip;
    private Battalion empire;

    private Game game;


    public Collisions(PlayerSpaceShip heroShip, Battalion empire, Game game) {
        this.heroShip = heroShip;
        this.empire = empire;
        this.game = game;
    }//Constructor

    public void checkCollisionsEmemyShip() {
        // CHECK COLLISIONS
        out:
        // FOR OF BULLETS
        for (int f=0; f<heroShip.getBullets().size; f++) {
            HeroBullet bullet = heroShip.getBullets().get(f);

            // FOR OF SQUADS
            for (int d=0; d<empire.getSquads().size; d++) {
                Squadron sq = empire.getSquads().get(d);

                // IF IS NEAR OF THE SQUAD
                if (sq.getTroops().get(0).getY() - bullet.getHeight() < bullet.getY()) {
                    // FOR OF TROOPS
                    for (int c=0; c<sq.getTroops().size; c++) {
                        EnemyShip enemy = sq.getTroops().get(c);

                        // IF COLLISION
                        if (enemy.isColliding(bullet)) {
                            heroShip.getBullets().removeIndex(f);
                            bullet.remove();

                            sq.getTroops().removeIndex(c);
                            if (enemy.getBullet() != null) {
                                enemy.getBullet().setY(-10);
                            }//IF
                            enemy.remove();

                            if (empire.getSquads().get(d).getTroops().size == 0) {
                                empire.getSquads().removeIndex(d);
                            }//IF

                            if (empire.getSquads().size == 0) {
                                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.GAMEOVER));
                            }//IF
                        }//IF
                    }//FOR
                } else {
                    break out;
                }//IF
            }//FOR
        }//FOR
    }//COLLISIONS

    public void checkCollisionsPlayerSpaceShip() {
        Array<EnemyBullet> activeBullets = empire.getActiveBullets();
        for (int f=0; f<activeBullets.size; f++) {
            EnemyBullet enemyBullet = activeBullets.get(f);

            // IF IS NEAR OF THE PLAYER
            if (heroShip.getY() + enemyBullet.getHeight() > enemyBullet.getY()) {
                // IF COLLISION
                if (heroShip.isColliding(enemyBullet)) {
                    game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.Screens.GAMEOVER));
                }//IF
            }//IF
        }//FOR
    }//COLLISIONS
}//CLASS