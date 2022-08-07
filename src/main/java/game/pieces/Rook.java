package game.pieces;

import game.main.TextureLoader;

public class Rook extends Piece
{
    public Rook(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.ROOK_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.ROOK_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}