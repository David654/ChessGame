package game.main;

import com.badlogic.gdx.graphics.Texture;

public class TextureLoader
{
    public static final Texture WHITE_SQUARE_TEXTURE = loadTexture("squares\\white.png");
    public static final Texture BLACK_SQUARE_TEXTURE = loadTexture("squares\\black.png");
    public static final Texture BLANK_SQUARE_TEXTURE = loadTexture("squares\\blank.png");

    public static final Texture PAWN_WHITE_TEXTURE = loadTexture("pieces\\pawn_white.png");
    public static final Texture KNIGHT_WHITE_TEXTURE = loadTexture("pieces\\knight_white.png");
    public static final Texture BISHOP_WHITE_TEXTURE = loadTexture("pieces\\bishop_white.png");
    public static final Texture ROOK_WHITE_TEXTURE = loadTexture("pieces\\rook_white.png");
    public static final Texture QUEEN_WHITE_TEXTURE = loadTexture("pieces\\queen_white.png");
    public static final Texture KING_WHITE_TEXTURE = loadTexture("pieces\\king_white.png");

    public static final Texture PAWN_BLACK_TEXTURE = loadTexture("pieces\\pawn_black.png");
    public static final Texture KNIGHT_BLACK_TEXTURE = loadTexture("pieces\\knight_black.png");
    public static final Texture BISHOP_BLACK_TEXTURE = loadTexture("pieces\\bishop_black.png");
    public static final Texture ROOK_BLACK_TEXTURE = loadTexture("pieces\\rook_black.png");
    public static final Texture QUEEN_BLACK_TEXTURE = loadTexture("pieces\\queen_black.png");
    public static final Texture KING_BLACK_TEXTURE = loadTexture("pieces\\king_black.png");

    public static Texture loadTexture(String path)
    {
        Texture texture = new Texture("src\\main\\resources\\board\\" + path);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        return texture;
    }
}