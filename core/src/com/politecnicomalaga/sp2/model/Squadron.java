package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Squadron {

    // CONSTANTS.

    private static final int NUM_TROOPS = SettingsManager.SQUAD_SIZE;

    // VARIABLES.

    private Stage bsStage;
    private Array<EnemyShip> troops;

    private float posX;
    private float posY;


    public Squadron(Stage baseStage, float posX, float posY) {
        this.posX = posX;
        this.posY = posY;

        // INITIATE ARRAY.

        troops = new Array<EnemyShip>();
        bsStage = baseStage;

        // CREATION OF THE SQUADRONS.

        for (int i = 0; i < NUM_TROOPS; i++) {
            EnemyShip newEnemy = new EnemyShip((((posX / (NUM_TROOPS + 1)) * (i + 1)) - 25), posY);
            baseStage.addActor(newEnemy);
            troops.add(newEnemy);
        }
    }

    public float getPosX() {
        return posX;
    }//GETPOSX

    public float getPosY() {
        return posY;
    }//GETPOSY

    public Array<EnemyShip> getTroops() {
        return troops;
    }

    public void addActors() {
        for (EnemyShip es : troops) {
            bsStage.addActor(es);
        }
    }

}