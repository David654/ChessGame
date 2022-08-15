package game.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureLoader
{
    public static final BufferedImage WHITE_SQUARE_TEXTURE = loadTexture("squares\\white.png");
    public static final BufferedImage WHITE_HOVER_SQUARE_TEXTURE = loadTexture("squares\\white_hover.png");
    public static final BufferedImage BLACK_SQUARE_TEXTURE = loadTexture("squares\\black.png");
    public static final BufferedImage BLACK_HOVER_SQUARE_TEXTURE = loadTexture("squares\\black_hover.png");
    public static final BufferedImage BORDER_SQUARE_TEXTURE = loadTexture("squares\\border.png");

    public static final BufferedImage PIECE_ATLAS = loadTexture("pieces\\pieces.png");

    public static final BufferedImage PAWN_WHITE_TEXTURE = getTextureRegion(5, 0);
    public static final BufferedImage KNIGHT_WHITE_TEXTURE = getTextureRegion(3, 0);
    public static final BufferedImage BISHOP_WHITE_TEXTURE = getTextureRegion(2, 0);
    public static final BufferedImage ROOK_WHITE_TEXTURE = getTextureRegion(4, 0);
    public static final BufferedImage QUEEN_WHITE_TEXTURE = getTextureRegion(1, 0);
    public static final BufferedImage KING_WHITE_TEXTURE = getTextureRegion(0, 0);

    public static final BufferedImage PAWN_BLACK_TEXTURE = getTextureRegion(5, 1);
    public static final BufferedImage KNIGHT_BLACK_TEXTURE = getTextureRegion(3, 1);
    public static final BufferedImage BISHOP_BLACK_TEXTURE = getTextureRegion(2, 1);
    public static final BufferedImage ROOK_BLACK_TEXTURE = getTextureRegion(4, 1);
    public static final BufferedImage QUEEN_BLACK_TEXTURE = getTextureRegion(1, 1);
    public static final BufferedImage KING_BLACK_TEXTURE = getTextureRegion(0, 1);

    public static BufferedImage loadTexture(String path)
    {
        BufferedImage bufferedImage;
        try
        {
            bufferedImage = ImageIO.read(new File("src\\main\\resources\\board\\" + path));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return bufferedImage;
    }

    public static BufferedImage getTextureRegion(int x, int y)
    {
        int pieceWidth = PIECE_ATLAS.getWidth() / 6;
        int pieceHeight = PIECE_ATLAS.getHeight() / 2;
        return PIECE_ATLAS.getSubimage(x * pieceWidth, y * pieceHeight, pieceWidth, pieceHeight);
    }
}