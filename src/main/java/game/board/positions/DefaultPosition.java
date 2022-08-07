package game.board.positions;

import game.pieces.*;

import java.util.ArrayList;

public class DefaultPosition implements ChessPosition
{
    public ArrayList<Piece> getPosition()
    {
        ArrayList<Piece> pieces = new ArrayList<>();

        for(int i = 0; i < 8; i++)
        {
            pieces.add(new Pawn(new Position(i + 1, 2), Color.White));
        }

        pieces.add(new Rook(new Position(Position.A, 1), Color.White));
        pieces.add(new Rook(new Position(Position.H, 1), Color.White));
        pieces.add(new Knight(new Position(Position.B, 1), Color.White));
        pieces.add(new Knight(new Position(Position.G, 1), Color.White));
        pieces.add(new Bishop(new Position(Position.C, 1), Color.White));
        pieces.add(new Bishop(new Position(Position.F, 1), Color.White));
        pieces.add(new Queen(new Position(Position.D, 1), Color.White));
        pieces.add(new King(new Position(Position.E, 1), Color.White));

        for(int i = 0; i < 8; i++)
        {
            pieces.add(new Pawn(new Position(i + 1, 7), Color.Black));
        }

        pieces.add(new Rook(new Position(Position.A, 8), Color.Black));
        pieces.add(new Rook(new Position(Position.H, 8), Color.Black));
        pieces.add(new Knight(new Position(Position.B, 8), Color.Black));
        pieces.add(new Knight(new Position(Position.G, 8), Color.Black));
        pieces.add(new Bishop(new Position(Position.C, 8), Color.Black));
        pieces.add(new Bishop(new Position(Position.F, 8), Color.Black));
        pieces.add(new Queen(new Position(Position.D, 8), Color.Black));
        pieces.add(new King(new Position(Position.E, 8), Color.Black));

        return pieces;
    }
}