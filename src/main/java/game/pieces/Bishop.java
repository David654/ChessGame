package game.pieces;

import game.main.TextureLoader;

public class Bishop extends Piece
{
    public Bishop(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.BISHOP_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.BISHOP_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}