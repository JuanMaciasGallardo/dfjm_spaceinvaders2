package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

import java.util.Random;
import java.util.Stack;

public class Battalion {

    // CONSTANTS.

    private static final float WIDTH = SettingsManager.SCREEN_WIDTH;
    private static final float HEIGHT = SettingsManager.SCREEN_HEIGHT;
    private static final int NUM_SQUADS = SettingsManager.BATTALION_SIZE;

    // VARIABLES.

    private Stage bsStage;
    private Array<Squadron> squadrons;

    private Array<EnemyBullet> activeBullets;
    private Stack<EnemyBullet> inactiveBullets;
    private float deltaBullet;


    public Battalion(Stage baseStage) {
        // INITIATE ARRAY.
        squadrons = new Array<Squadron>();
        bsStage = baseStage;

        activeBullets = new Array<EnemyBullet>();
        inactiveBullets = new Stack<EnemyBullet>();

        // CREATION OF THE SQUADRONS.
        for (int i = 0; i < NUM_SQUADS; i++) {
            Squadron newSquad = new Squadron(bsStage, WIDTH, ((((HEIGHT / 2) / (NUM_SQUADS + 1)) * (i + 1)) + (HEIGHT / 2)));
            squadrons.add(newSquad);
        }

        deltaBullet = GameManager.getSingleton().getGameTime();
    }//Constructor

    public Array<Squadron> getSquads() {
        return  squadrons;
    }

    public void addActors() {
        for (Squadron sq : squadrons) {
            sq.addActors();
        }
    }

    public Array<EnemyBullet> getActiveBullets() {
        return activeBullets;
    }//GETACTIVEBULLETS

    public void shoot() {
        if (deltaBullet+SettingsManager.BULLET_ENEMY_RATIO < GameManager.getSingleton().getGameTime()) {
            deltaBullet = GameManager.getSingleton().getGameTime();
            squadronsShoot();
        }//IF

        // TO TRANSFER BULLETS
        for (int f=0; f<activeBullets.size; f++) {
            if (activeBullets.get(f).getY() < 0) {
                transferBullet(f);
            } else {
                break;
            }//IF
        }//FOR

        // PAINT
        for (int f=0; f<activeBullets.size; f++) {
            activeBullets.get(f).setY(activeBullets.get(f).getY()-SettingsManager.BULLET_ENEMY_SPEED);
        }//FOR
    }//SHOOT

    private void squadronsShoot() {
        if (inactiveBullets.size() == 0) {
            EnemyShip randomEnemyShip = getRandomEnemy();

            if (!randomEnemyShip.isShooting()) {
                EnemyBullet newEnemyBullet = new EnemyBullet(randomEnemyShip);
                randomEnemyShip.addBullet(newEnemyBullet);

                activeBullets.add(newEnemyBullet);
            }//IF
        } else {
            transferBullet();
        }//IF
    }//SQUADRONSSHOOT

    public EnemyShip getRandomEnemy() {
        Squadron randomSquadron = squadrons.get(new Random().nextInt(squadrons.size));

        Array<EnemyShip> arrayEnemyShip = randomSquadron.getTroops();
        return arrayEnemyShip.get(new Random().nextInt(arrayEnemyShip.size));
    }//GETRANDOMENEMY

    private void transferBullet(int pos) {
        EnemyBullet newBullet = activeBullets.get(pos);
        newBullet.getEnemyShip().removeBullet();
        activeBullets.removeIndex(pos);
        inactiveBullets.push(newBullet);
    }//TRANSFERBULLET

    private void transferBullet() {
        EnemyShip randomEnemyShip = getRandomEnemy();

        if (!randomEnemyShip.isShooting()) {
            EnemyBullet newBullet = inactiveBullets.pop();
            newBullet.changeOfEnemy(randomEnemyShip);
            activeBullets.add(newBullet);
        }//IF
    }//TRANSFERBULLET
}//CLASS