package game.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.main.Game;
import game.main.TextureLoader;
import game.pieces.Color;
import game.pieces.Position;

public class Square
{
    private final Position position;
    private Color color;
    private Texture texture;
    private String text = "";

    public Square(BoardView boardView, Position position)
    {
        this.position = position;

        if(boardView == BoardView.WhiteView)
        {
            color = ((position.getFile() % 2 == 0) == (position.getRank() % 2 == 0)) ? Color.Black : Color.White;
        }
        else
        {
            color = ((position.getFile() % 2 == 0) != (position.getRank() % 2 == 0)) ? Color.Black : Color.White;
        }

        switch(color)
        {
            case White -> texture = TextureLoader.WHITE_SQUARE_TEXTURE;
            case Black -> texture = TextureLoader.BLACK_SQUARE_TEXTURE;
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

    public void setColor(Color color)
    {
        this.color = color;
        switch(color)
        {
            case White -> texture = TextureLoader.WHITE_SQUARE_TEXTURE;
            case Black -> texture = TextureLoader.BLACK_SQUARE_TEXTURE;
            case Blank -> texture = TextureLoader.BLANK_SQUARE_TEXTURE;
        }
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void render(SpriteBatch spriteBatch, BitmapFont font)
    {
        spriteBatch.draw(texture, position.getRank() * Game.SQUARE_SIZE, position.getFile() * Game.SQUARE_SIZE, Game.SQUARE_SIZE, Game.SQUARE_SIZE);
        font.draw(spriteBatch, text, position.getRank() * Game.SQUARE_SIZE, (position.getFile() + 1) * Game.SQUARE_SIZE);
    }
}