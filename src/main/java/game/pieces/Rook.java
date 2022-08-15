package game.pieces;

import game.util.TextureLoader;

public class Rook extends Piece
{
    public Rook(Position position, Color color)
    {
        super(position, color, new String[] {"♖", "♜"});
        switch(color)
        {
            case White -> texture = TextureLoader.ROOK_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.ROOK_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "R" + position.toString();
    }

    public void update()
    {

    }
}