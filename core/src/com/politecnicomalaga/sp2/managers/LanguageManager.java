package com.politecnicomalaga.sp2.managers;

public class LanguageManager {

    // VARIABLES
    public enum Languages {SPANISH, ENGLISH};
    private static LanguageManager singleton;

    private Languages activeLang;
    private String[] activeStrings;

    // CONSTANTS
    private static final String[] STR_SPANISH = {
            "$ KARTOFFEL STUDIOS",
            "SPACE     INVADERS",
            "JUGAR",
            "CREDITO",
            "SPACE INVADERS",
            "Inicio",
            "Configuracion",
            "Lider Supremo de JUnit",
            "Gigachad de JUnit",
            "Volver",
            "Creditos",
            "Menciones Honorables",
            "Patatas"};

    private static final String[] STR_ENGLISH = {
            "$ KARTOFFEL STUDIOS",
            "SPACE     INVADERS",
            "PLAY",
            "CREDIT",
            "SPACE INVADERS",
            "Start",
            "Configuration",
            "JUnit's Supreme Leader",
            "JUnit's Gigachad",
            "Back",
            "Credits",
            "Honourable Mentions",
            "Potatoes"};

    // STRINGS' IDS
    public static final int LBL_STUDIOS_NAME_ID = 0;
    public static final int LBL_GAME_NAME_ID = 1;
    public static final int LBL_PLAY_ID = 2;
    public static final int LBL_MONEY_ID = 3;
    public static final int LBL_TITLE_ID = 4;
    public static final int BTN_START_ID = 5;
    public static final int BTN_CONFIG_ID = 6;
    public static final int LBL_LEADER_ID = 7;
    public static final int LBL_WORKER_ID = 8;
    public static final int BTN_BACK_ID = 9;
    public static final int LBL_CREDITS_ID = 10;
    public static final int LBL_HONOURS_ID = 11;
    public static final int LBL_POTATO_ID = 12;

    private LanguageManager() {
        activeLang = Languages.SPANISH;
        activeStrings = STR_SPANISH;
    }

    public static LanguageManager getSingleton() {
        if (singleton == null) {
            singleton = new LanguageManager();
        }//IF
        return singleton;
    } //GETSINGLETON

    public String getString(int iStr) {
        return activeStrings[iStr];
    }//GETSTRING

    public void setActiveLanguage(Languages lang) {
        switch (lang) {
            case ENGLISH: {
                activeLang = Languages.ENGLISH;
                activeStrings = STR_ENGLISH;
            }
            case SPANISH: {
                activeLang = Languages.SPANISH;
                activeStrings = STR_SPANISH;
            }
        }
    }//SETACTIVELANGUAGE
}
