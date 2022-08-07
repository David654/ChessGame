package game.pieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.board.BoardView;
import game.main.Game;

public abstract class Piece
{
    private Position position;
    private int x;
    private int y;
    private final Color color;
    protected Texture texture = null;

    public Piece(Position position, Color color)
    {
        this.position = position;
        this.color = color;
        x = position.getRank() * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2;
        y = position.getFile() * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2;

        if(Game.BOARD_VIEW == BoardView.BlackView)
        {
            y = (9 - position.getFile()) * Game.SQUARE_SIZE + (Game.SQUARE_SIZE - Game.PIECE_SIZE) / 2;
        }
    }

    public Color getColor()
    {
        return color;
    }

    public Position getPosition()
    {
        return position;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public String toString()
    {
        String className = Piece.class.getName();
        return className + ": " + position.toString();
    }

    public boolean equals(Object o)
    {
        Piece piece = (Piece) o;
        return position.equals(piece.getPosition());
    }

    public abstract void update();

    public void render(SpriteBatch spriteBatch)
    {
        spriteBatch.draw(texture, x, y, Game.PIECE_SIZE, Game.PIECE_SIZE);
    }
}