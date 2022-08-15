package game.main.moves;

import java.util.ArrayList;

public class MoveManager
{
    private final ArrayList<Move> moves = new ArrayList<>();

    public void addMove(Move move)
    {
        Move.moveNum++;
        moves.add(move);
    }

    public Move getMove(int number)
    {
        return moves.get(number);
    }

    public ArrayList<Move> getMoves(int from, int to)
    {
        ArrayList<Move> list = new ArrayList<>();
        for(int i = from; i < to; i++)
        {
            list.add(moves.get(i));
        }
        return list;
    }

    public int getNumMoves()
    {
        return moves.size();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < moves.size(); i++)
        {
            Move move = moves.get(i);
            sb.append(i + 1).append(". ").append(move.toString()).append("\n");
        }
        return sb.toString();
    }
}