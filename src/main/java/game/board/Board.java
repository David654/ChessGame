package game.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.pieces.Piece;
import game.pieces.Position;

import java.util.ArrayList;

public class Board
{
    private final ArrayList<Square> squares;

    public Board()
    {
        squares = new ArrayList<>();
    }

    public void addSquare(Square square)
    {
        squares.add(square);
    }

    public Piece getPiece(Position position)
    {
        for(Square square : squares)
        {
            if(square.getPosition().equals(position))
            {
                return square.getPiece();
            }
        }
        return null;
    }

    public void removePiece(Piece piece)
    {
        for(Square square : squares)
        {
            if(square.getPiece().equals(piece))
            {
                squares.remove(square);
                break;
            }
        }
    }

    public void update()
    {
        for(int i = 0; i < squares.size(); i++)
        {
            Square square = squares.get(i);
            square.update();
        }
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i = 0; i < squares.size(); i++)
        {
            Square square = squares.get(i);
            square.render(spriteBatch);
        }
    }
}