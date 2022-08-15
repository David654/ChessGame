package game.board;

import game.board.positions.ChessPosition;
import game.main.Game;
import game.pieces.Piece;
import game.pieces.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel
{
    private final Square[] squares;
    private final ArrayList<Border> borders;
    private ArrayList<Piece> pieces;

    public Board(BoardView boardView)
    {
        squares = new Square[64];
        borders = new ArrayList<>();

        setBoardView(boardView);

        pieces = new ArrayList<>();
    }

    public void setBoardView(BoardView boardView)
    {
        String[] ranks = new String[] {" ", "a", "b", "c", "d", "e", "f", "g", "h"};

        borders.add(new Border(this, 0, 0, ranks[0]));
        borders.add(new Border(this, 0, 9 * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, ranks[0]));
        borders.add(new Border(this, 9 * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, 0, ranks[0]));
        borders.add(new Border(this, 9 * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, 9 * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, ranks[0]));
        for(int x = 1; x < 9; x++)
        {
            int index = x;
            if(boardView == BoardView.BlackView)
            {
                index = 9 - x;
            }
            borders.add(new Border(this, x * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, 0, ranks[index]));
            borders.add(new Border(this, x * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, 8 * Game.SQUARE_SIZE + Game.SQUARE_SIZE / 2, ranks[index]));
        }

        for(int y = 1; y < 9; y++)
        {
            int value = y;
            if(boardView == BoardView.BlackView)
            {
                value = 9 - y;
            }
            borders.add(new Border(this, 0, (9 - y) * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, String.valueOf(value)));
            borders.add(new Border(this, 9 * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, (9 - y) * Game.SQUARE_SIZE - Game.SQUARE_SIZE / 2, String.valueOf(value)));
        }

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                int rank = x;
                int file = y;

                if(boardView == BoardView.BlackView)
                {
                    rank = 7 - rank;
                    file = 7 - file;
                }

                squares[x * 8 + y] = new Square(this, new Position(rank, file));
            }
        }
    }

    public Square getSquare(Position position)
    {
        for(int i = 0; i < squares.length; i++)
        {
            Square square = squares[i];
            if(square.getPosition().equals(position))
            {
                return square;
            }
        }
        return null;
    }

    public Square[] getSquares()
    {
        return squares;
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

    public ArrayList<Piece> getPieces()
    {
        return pieces;
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

        pieces.sort((p1, p2) -> Boolean.compare(p1.isSelected(), p2.isSelected()));
    }

    public void render(Graphics2D g2d)
    {
        for(int i = 0; i < squares.length; i++)
        {
            Square square = squares[i];
            square.render(g2d);
        }

        for(int i = 0; i < borders.size(); i++)
        {
            Border border = borders.get(i);
            border.render(g2d);
        }

        for(int i = 0; i < pieces.size(); i++)
        {
            Piece piece = pieces.get(i);
            piece.render(g2d);
        }
    }
}