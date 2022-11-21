package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Gdx;

public class GameManager {

    private float gameTime;
    private static GameManager singleton;

    private GameManager() {}

    public static GameManager getSingleton() {
        if (singleton == null) {
            singleton = new GameManager();
        }//IF
        return singleton;
    }//GETSINGLETON

    public float getGameTime() {
        return gameTime;
    }//GETGAMETIME

    public float addDelta() {
        gameTime += Gdx.graphics.getDeltaTime();
        return gameTime;
    }//ADDDELTA
}//CLASS
