package game.pieces;

import game.util.TextureLoader;

public class King extends Piece
{
    public King(Position position, Color color)
    {
        super(position, color, new String[] {"♔", "♚"});
        switch(color)
        {
            case White -> texture = TextureLoader.KING_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.KING_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "K" + position.toString();
    }

    public void update()
    {

    }
}