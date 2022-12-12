package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Battalion {

    // CONSTANTS.

    private static final float WIDTH = SettingsManager.SCREEN_WIDTH;
    private static final float HEIGHT = SettingsManager.SCREEN_HEIGHT;
    private static final int NUM_SQUADS = SettingsManager.BATTALION_SIZE;

    // VARIABLES.

    private Stage bsStage;
    private Array<Squadron> squadrons;

    public Battalion(Stage baseStage) {
        // INITIATE ARRAY.
        squadrons = new Array<Squadron>();
        bsStage = baseStage;

        // CREATION OF THE SQUADRONS.
        for (int i = 0; i < NUM_SQUADS; i++) {
            Squadron newSquad = new Squadron(bsStage, WIDTH, ((((HEIGHT / 2) / (NUM_SQUADS + 1)) * (i + 1)) + (HEIGHT / 2)));
            squadrons.add(newSquad);
        }
    }

    public Array<Squadron> getSquads() {
        return  squadrons;
    }

    public void addActors() {
        for (Squadron sq : squadrons) {
            sq.addActors();
        }
    }
}
