package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Squadron {

    private Array<EnemyShip> troops;
    EnemyShip newEnemy;
    private int numTroops = 4;

    public Squadron(Stage baseStage, float posX, float posY) {
        //Initiate the arraylist
        troops = new Array<EnemyShip>();

        //We have to create all the squadrons
        for (int i = 0; i < numTroops; i++) {
            newEnemy = new EnemyShip((((posX / (numTroops + 1)) * (i + 1)) - 25), posY);
            baseStage.addActor(newEnemy);
            troops.add(newEnemy);

        }

    }

    public void draw(Batch batch, float parentAlpha){
        for (EnemyShip enemys :troops) {
            enemys.draw(batch, parentAlpha);
        }

    }

}