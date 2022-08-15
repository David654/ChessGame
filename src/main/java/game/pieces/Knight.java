package game.pieces;

import game.util.TextureLoader;

public class Knight extends Piece
{
    public Knight(Position position, Color color)
    {
        super(position, color, new String[] {"♘", "♞"});
        switch(color)
        {
            case White -> texture = TextureLoader.KNIGHT_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.KNIGHT_BLACK_TEXTURE;
        }
    }

    public String toString()
    {
        return "N" + position.toString();
    }

    public void update()
    {

    }
}