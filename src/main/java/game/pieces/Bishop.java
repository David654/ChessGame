package game.pieces;

import game.util.TextureLoader;

public class Bishop extends Piece
{
    public Bishop(Position position, Color color)
    {
        super(position, color, new String[] {"♗", "♝"});
        switch(color)
        {
            case White -> texture = TextureLoader.BISHOP_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.BISHOP_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "B" + position.toString();
    }

    public void update()
    {

    }
}