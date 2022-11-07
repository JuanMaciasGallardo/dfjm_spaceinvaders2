package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Squadron {

    private Array<EnemyShip> troops;

    public Squadron(Stage baseStage) {
        //Initiate the arraylist
        troops = new Array<EnemyShip>();


        //We have to create all the squadrons
        for (int i=0;i<4;i++) {
            EnemyShip newEnemy = new EnemyShip();
            baseStage.addActor(newEnemy);
        }
    }
}
