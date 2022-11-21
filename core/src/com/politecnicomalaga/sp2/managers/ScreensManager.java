package com.politecnicomalaga.sp2.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.view.GameOverScreen;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.view.SplashScreen;

public class ScreensManager {
    // VARAIBLES
    public enum Screens {SPLASH, GAME, GAMEOVER, SETTINGS, CREDITS};
    private static ScreensManager singleton;
    private ScreensManager () {
    }
    //SINGLETON OF THE CLASS
    public static ScreensManager getSingleton(){
        if (singleton == null) {
            singleton = new ScreensManager();
        }
        return singleton;
    }//Constructor
    public Screen getScreen(Game game, Screens screen) {
        Screen activeScreen = null;

        ScreenUtils.clear(0, 0, 0, 1);
        switch (screen) {
            case SPLASH: activeScreen = new SplashScreen(game);
                break;
            case GAME: activeScreen = new GameScreen(game);
                break;
            case GAMEOVER: activeScreen= new GameOverScreen(game);
                break;
            case SETTINGS:
                break;
            case CREDITS:
                break;
                // DEFAULT WILL BE SPLASH SCREEN IN THE NEXT VERSION
            default: activeScreen= new SplashScreen(game);
        }//SWITCH

        return activeScreen;
    }//GETSCREEN
}//CLASS
