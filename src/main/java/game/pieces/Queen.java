package game.pieces;

import game.main.TextureLoader;

public class Queen extends Piece
{
    public Queen(Position position, Color color)
    {
        super(position, color);
        switch(color)
        {
            case White -> texture = TextureLoader.QUEEN_WHITE_TEXTURE;
            case Black -> texture = TextureLoader.QUEEN_BLACK_TEXTURE;
        }
    }

    public void update()
    {

    }
}