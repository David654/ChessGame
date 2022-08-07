package game.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.pieces.Piece;
import game.pieces.Position;

public class Square
{
    private final Position position;
    private Piece piece = null;

    public Square(Position position)
    {
        this.position = position;
    }

    public Position getPosition()
    {
        return position;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public void update()
    {
        piece.update();
    }

    public void render(SpriteBatch spriteBatch)
    {
        piece.render(spriteBatch);
    }
}