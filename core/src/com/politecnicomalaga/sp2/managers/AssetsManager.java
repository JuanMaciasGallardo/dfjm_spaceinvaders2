package com.politecnicomalaga.sp2.managers;

///////////////
// CONSTANTS //
///////////////

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetsManager {

    // VARIABLES
    private static Skin skin;

    // SPRITE
    public static final String NUMBERS_SPRITES ="numbers/digito";
    public static final String NUMBERS_EXT_SPRITES =".png";

    // ATLAS
    public static final String ATLAS_PATH ="sp2.atlas";
    public static final String ATLAS_CUSTOM_PATH ="sp2_Custom.atlas";
    public static final String REGION_PLAYER_NAME ="player";
    public static final String REGION_ENEMY_NAME ="ovni";
    public static final String REGION_EXPLOSION_NAME ="explosion";

    // SOUND
    public static final String SOUND_PATH ="sounds/";
    public static final String SOUND_DAMAGE ="damage.wav";
    public static final String SOUND_DAMAGE1 ="damage1.wav";
    public static final String OST_GAME_MUSIC ="gamemusic.ogg";
    public static final String OST_INTO ="gamemusic.ogg";
    public static final String SOUND_MOVE ="move.wav";

    // DIGITS
    public static final String DIGIT_PATH ="numbers/";
    public static final String DIGIT_NAME ="digito";
    public static final String DIGIT_EXT =".png";

    // RETURNS THE SKIN FOR LABELS, BUTTONS...
    public static Skin getTextSkin() {
        if (skin == null) {
            skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        }//IF
        return skin;
    }//GETTEXTSKIN

}//CLASS
