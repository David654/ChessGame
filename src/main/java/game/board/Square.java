package game.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.main.Game;
import game.main.TextureLoader;
import game.pieces.Color;
import game.pieces.Position;

public class Square
{
    private final Position position;
    private final Color color;
    private Texture texture;

    public Square(Position position)
    {
        this.position = position;

        color = ((position.getFile() % 2 == 0) == (position.getRank() % 2 == 0)) ? Color.Black : Color.White;

        switch(color)
        {
            case Black -> texture = TextureLoader.BLACK_SQUARE_TEXTURE;
            case White -> texture = TextureLoader.WHITE_SQUARE_TEXTURE;
        }
    }

    public Position getPosition()
    {
        return position;
    }

    public Color getColor()
    {
        return color;
    }

    public void render(SpriteBatch spriteBatch)
    {
        spriteBatch.draw(texture, position.getFile() * Game.SQUARE_SIZE, position.getRank() * Game.SQUARE_SIZE, Game.SQUARE_SIZE, Game.SQUARE_SIZE);
    }
}