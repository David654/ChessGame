package game.pieces;

import game.main.TextureLoader;

public class Knight extends Piece
{
    public Knight(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.KNIGHT_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.KNIGHT_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}