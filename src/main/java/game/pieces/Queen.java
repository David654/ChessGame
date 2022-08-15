package game.pieces;

import game.util.TextureLoader;

public class Queen extends Piece
{
    public Queen(Position position, Color color)
    {
        super(position, color, new String[] {"♕", "♛"});
        switch(color)
        {
            case White -> texture = TextureLoader.QUEEN_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.QUEEN_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "Q" + position.toString();
    }

    public void update()
    {

    }
}