package game.board;

import game.main.Game;
import game.pieces.Color;
import game.pieces.Position;
import game.util.TextureLoader;

import java.awt.*;

public class Border extends Square
{
    private int x;
    private int y;
    private String text;
    private final int width;
    private final int height;

    public Border(Board board, int x, int y, String text)
    {
        super(board, new Position(0, 0));
        this.x = x;
        this.y = y;
        this.text = text;

        if(Character.isDigit(text.charAt(0)))
        {
            width = Game.SQUARE_SIZE / 2;
            height = Game.SQUARE_SIZE;
        }
        else if(text.equals(" "))
        {
            width = Game.SQUARE_SIZE / 2;
            height = Game.SQUARE_SIZE / 2;
        }
        else
        {
            width = Game.SQUARE_SIZE;
            height = Game.SQUARE_SIZE / 2;
        }

        texture = TextureLoader.BORDER_SQUARE_TEXTURE;
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

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setColor(Color color)
    {
        this.color = color;
        if(color == Color.Border)
        {
            texture = TextureLoader.BORDER_SQUARE_TEXTURE;
        }
    }

    public void render(Graphics2D g2d)
    {
        g2d.setColor(java.awt.Color.WHITE);
        g2d.drawImage(texture, x, y, width, height, null);

        FontMetrics fontMetrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString(text, x + width / 2 - fontMetrics.stringWidth(text) / 2, y + height / 2 + fontMetrics.getHeight() / 4);
    }
}