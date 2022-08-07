package game.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.board.positions.ChessPosition;
import game.pieces.Piece;
import game.pieces.Position;

import java.util.ArrayList;

public class Board
{
    private final Square[] squares;
    private ArrayList<Piece> pieces;

    public Board(BoardView boardView)
    {
        squares = new Square[64];
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                squares[x * 8 + y] = new Square(boardView, new Position(x + 1, y + 1));
            }
        }

        pieces = new ArrayList<>();
    }

    public void addPiece(Piece piece)
    {
        pieces.add(piece);
    }

    public Piece getPiece(Position position)
    {
        for(Piece piece : pieces)
        {
            if(piece.getPosition().equals(position))
            {
                return piece;
            }
        }
        return null;
    }

    public void removePiece(Piece piece)
    {
        pieces.remove(piece);
    }

    public void setPosition(ChessPosition position)
    {
        pieces = position.getPosition();
    }

    public void update()
    {
        for(int i = 0; i < pieces.size(); i++)
        {
            Piece piece = pieces.get(i);
            piece.update();
        }
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i = 0; i < squares.length; i++)
        {
            Square square = squares[i];
            square.render(spriteBatch);
        }

        for(int i = 0; i < pieces.size(); i++)
        {
            Piece piece = pieces.get(i);
            piece.render(spriteBatch);
        }
    }
}