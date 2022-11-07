package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Battalion {
    private Array<Squadron> squadrons;

    public Battalion(Stage baseStage) {
        //Initiate the arraylist
        squadrons = new Array<Squadron>();


        //We have to create all the squadrons
        for (int i=0;i<4;i++) {
            Squadron newSquad = new Squadron(baseStage);
        }
    }
}
