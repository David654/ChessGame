package game.pieces;

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
            case 1 -> c = "A";
            case 2 -> c = "B";
            case 3 -> c = "C";
            case 4 -> c = "D";
            case 5 -> c = "E";
            case 6 -> c = "F";
            case 7 -> c = "G";
            case 8 -> c = "H";
        }
        return c + file;
    }

    public boolean equals(Object o)
    {
        Position position = (Position) o;
        return rank == position.getRank() && file == position.getFile();
    }
}