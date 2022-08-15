package game.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.main.Game;
import game.util.TextureLoader;
import game.pieces.Color;
import game.pieces.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square
{
    protected Board board;
    protected final Position position;
    protected Color color;
    protected BufferedImage texture;

    public Square(Board board, Position position)
    {
        this.board = board;
        this.position = position;

        if(Game.BOARD_VIEW == BoardView.WhiteView)
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

    public void setTexture(BufferedImage texture)
    {
        this.texture = texture;
    }

    public void setColor(Color color)
    {
        this.color = color;
        switch(color)
        {
            case White -> texture = TextureLoader.WHITE_SQUARE_TEXTURE;
            case Black -> texture = TextureLoader.BLACK_SQUARE_TEXTURE;
        }
    }

    public boolean isEmpty()
    {
        return board.getPiece(position) == null;
    }

    public void render(Graphics2D g2d)
    {
        g2d.drawImage(texture, position.getRank() * Game.SQUARE_SIZE + Game.SQUARE_SIZE / 2, position.getFile() * Game.SQUARE_SIZE + Game.SQUARE_SIZE / 2, Game.SQUARE_SIZE, Game.SQUARE_SIZE, null);
    }
}