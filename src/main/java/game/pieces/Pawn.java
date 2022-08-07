package game.pieces;

import game.main.TextureLoader;

public class Pawn extends Piece
{
    public Pawn(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.PAWN_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.PAWN_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}