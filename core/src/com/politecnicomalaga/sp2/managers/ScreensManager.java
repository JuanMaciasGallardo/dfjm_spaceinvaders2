package com.politecnicomalaga.sp2.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.view.GameScreen;

public class ScreensManager {
    // VARAIBLES
    public enum Screens {START, PLAYING, END};
    private static ScreensManager singleton;
    private ScreensManager () {
    }
    //SINGLETON OF THE CLASS
    public static ScreensManager getSingleton(){
        if (singleton == null) {
            singleton = new ScreensManager();
        }
        return singleton;
    }
    public Screen getScreen(Game game, Screens screen) {
        Screen activeScreen = null;

        switch (screen) {
            case START: ;
                break;
            case PLAYING: activeScreen= new GameScreen(game);
                break;
            case END: ;
                break;
                // DEFAULT WILL BE SPLASH SCREEN IN THE NEXT VERSION
            default: activeScreen= new GameScreen(game);
        }

        return activeScreen;
    }
}
