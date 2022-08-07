package game.board;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.board.positions.ChessPosition;
import game.pieces.Color;
import game.pieces.Piece;
import game.pieces.Position;

import java.util.ArrayList;

public class Board
{
    private final Square[] squares;
    private ArrayList<Piece> pieces;

    public Board(BoardView boardView)
    {
        squares = new Square[81];

        setBoardView(boardView);

        pieces = new ArrayList<>();
    }

    public void setBoardView(BoardView boardView)
    {
        String[] ranks = new String[] {"", "a", "b", "c", "d", "e", "f", "g", "h"};

        for(int x = 0; x < 9; x++)
        {
            Square square = new Square(boardView, new Position(x, 0));
            square.setText(ranks[x]);
            square.setColor(Color.Blank);
            squares[x * 9] = square;
        }

        for(int y = 1; y < 9; y++)
        {
            Square square = new Square(boardView, new Position(0, y));
            square.setText(String.valueOf(y));
            square.setColor(Color.Blank);
            squares[y] = square;
        }

        for(int x = 1; x < 9; x++)
        {
            for(int y = 1; y < 9; y++)
            {
                squares[x * 9 + y] = new Square(boardView, new Position(x, y));
            }
        }
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

    public void render(SpriteBatch spriteBatch, BitmapFont font)
    {
        for(int i = 0; i < squares.length; i++)
        {
            Square square = squares[i];
            if(square != null)
            {
                square.render(spriteBatch, font);
            }
        }

        for(int i = 0; i < pieces.size(); i++)
        {
            Piece piece = pieces.get(i);
            piece.render(spriteBatch);
        }
    }
}