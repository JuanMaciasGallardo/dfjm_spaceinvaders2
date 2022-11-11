package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Battalion {
    private Array<Squadron> squadrons;
    Squadron newSquad;
    float sizeX = Gdx.graphics.getWidth();
    float sizeY = Gdx.graphics.getHeight();
    private int numSquads = 4;

    public Battalion(Stage baseStage) {
        //Initiate the arraylist
        squadrons = new Array<Squadron>();

        //We have to create all the squadrons
        for (int i = 0; i < numSquads; i++) {
            newSquad = new Squadron(baseStage, sizeX, ((((sizeY / 2) / (numSquads + 1)) * (i + 1)) + (sizeY / 2)));
            squadrons.add(newSquad);

        }
    }

    public void draw(Batch batch, float parentAlpha){
        for (Squadron squads :squadrons) {
            squads.draw(batch, parentAlpha);
        }

    }
}
