package game.pieces;

import game.main.Game;

public class Position
{
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;

    private final int rank;
    private final int file;

    public Position()
    {
        this(1, A);
    }

    public Position(int rank, int file)
    {
        this.rank = rank;
        this.file = file;
    }

    public int getRank()
    {
        return rank;
    }

    public int getFile()
    {
        return file;
    }

    public String toString()
    {
        String c = "NULL";
        switch(rank)
        {
            case 1 -> c = "a";
            case 2 -> c = "b";
            case 3 -> c = "c";
            case 4 -> c = "d";
            case 5 -> c = "e";
            case 6 -> c = "f";
            case 7 -> c = "g";
            case 8 -> c = "h";
        }
        return c + file;
    }

    public boolean equals(Object o)
    {
        Position position = (Position) o;
        return rank == position.getRank() && file == position.getFile();
    }

    public Position flip()
    {
        return new Position(rank, 9 - file);
    }

    public static Position coordinatesToPosition(int x, int y)
    {
        return new Position(x / Game.SQUARE_SIZE, y / Game.SQUARE_SIZE);
    }

    public static int[] positionToCoordinates(Position position)
    {
        int x = (position.getRank()) * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2 - Game.SQUARE_SIZE / 2;
        int y = (position.getFile()) * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2 - Game.SQUARE_SIZE / 2;
        return new int[] {x, y};
    }

    public static int[] positionToCoordinates(int px, int py, Position position)
    {
        int x = (px - position.getRank()) * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2 - Game.SQUARE_SIZE / 2;
        int y = (py - position.getFile()) * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2 - Game.SQUARE_SIZE / 2;
        return new int[] {x, y};
    }
}