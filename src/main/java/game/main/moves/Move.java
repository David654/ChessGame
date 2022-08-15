package game.main.moves;

import game.pieces.*;

public record Move(Piece piece, Position from, Position to)
{
    public static int moveNum = 0;

    public String toString()
    {
        String p = "";
        if (piece instanceof Pawn) p = piece.toString().substring(0, 1);
        if (piece instanceof Knight) p = piece.toString().substring(0, 1);
        if (piece instanceof Bishop) p = piece.toString().substring(0, 1);
        if (piece instanceof Rook) p = piece.toString().substring(0, 1);
        if (piece instanceof Queen) p = piece.toString().substring(0, 1);
        if (piece instanceof King) p = piece.toString().substring(0, 1);
        return p + from + "-" + p + to;
    }
}