package game.pieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Piece
{
    private Position position;
    private final Color color;

    public Piece(Position position, Color color)
    {
        this.position = position;
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public Position getPosition()
    {
        return position;
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

    public abstract void render(SpriteBatch spriteBatch);
}