package game.main;

import com.badlogic.gdx.graphics.Texture;

public class TextureLoader
{
    public static final Texture WHITE_SQUARE_TEXTURE = loadTexture("squares\\white.png");
    public static final Texture BLACK_SQUARE_TEXTURE = loadTexture("squares\\black.png");
    public static final Texture PAWN_WHITE_TEXTURE = loadTexture("pieces\\pawn_white.png");
    public static final Texture PAWN_BLACK_TEXTURE = loadTexture("pieces\\pawn_black.png");

    public static Texture loadTexture(String path)
    {
        return new Texture("src\\main\\resources\\board\\" + path);
    }
}