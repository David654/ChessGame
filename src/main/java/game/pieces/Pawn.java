package game.pieces;

import game.util.TextureLoader;

public class Pawn extends Piece
{
    public Pawn(Position position, Color color)
    {
        super(position, color, new String[] {"", ""});
        switch(color)
        {
            case White -> texture = TextureLoader.PAWN_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.PAWN_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "P" + position.toString();
    }

    public void update()
    {

    }
}