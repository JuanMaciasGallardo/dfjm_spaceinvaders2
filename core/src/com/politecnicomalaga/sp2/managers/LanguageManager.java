package com.politecnicomalaga.sp2.managers;

public class LanguageManager {

    // VARIABLES
    public enum Languages {SPANISH, ENGLISH};
    private static LanguageManager singleton;

    private String[] activeLang;

    // CONSTANTS
    private static final String[] SPANISH = {"Jugar"};
    private static final String[] ENGLISH = {"Play"};

    private static final int BTN_PLAY_ID = 0;

    private LanguageManager() {}

    public static LanguageManager getSingleton() {
        if (singleton == null) {
            singleton = new LanguageManager();
        }//IF
        return singleton;
    } //GETSINGLETON
}
