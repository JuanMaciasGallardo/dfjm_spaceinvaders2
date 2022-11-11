package com.politecnicomalaga.sp2.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.view.GameScreen;

public class ScreensManager extends ScreenAdapter {
    // Programar clase
    private Screens activeScreen;
    public enum Screens {START, PLAYING, END};
    private GameScreen gs;

    public ScreensManager (Game game, Screens screen) {

        gs = new GameScreen(game);
        activeScreen=screen;

    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        switch (activeScreen) {
            case START: ;
                break;
            case PLAYING: gs.render(delta);
                break;
            case END: ;
                break;
        }
    }

    public void changeScreen(Screens screen){
        activeScreen= screen;
    }


    @Override
    public void dispose () {
        gs.dispose();
    }
}
