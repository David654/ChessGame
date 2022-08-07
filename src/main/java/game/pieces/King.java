package game.pieces;

import game.main.TextureLoader;

public class King extends Piece
{
    public King(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.KING_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.KING_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}