package game.pieces;

import game.board.BoardView;
import game.main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Piece
{
    protected Position position;
    protected int x;
    protected int y;
    protected final Color color;
    protected BufferedImage texture = null;
    protected boolean isSelected = false;
    protected String[] symbols;
    protected Position[] possibleMoves;

    public Piece(Position position, Color color, String[] symbols)
    {
        this.position = position;
        this.color = color;
        this.symbols = symbols;
        x = Position.positionToCoordinates(position)[0];
        y = Position.positionToCoordinates(0, 9, position)[1];

        if(Game.BOARD_VIEW == BoardView.BlackView)
        {
            x = Position.positionToCoordinates(position)[0];
            y = Position.positionToCoordinates(position)[1];
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
        x = Position.positionToCoordinates(position)[0];
        y = Position.positionToCoordinates(position)[1];
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean selected)
    {
        isSelected = selected;
    }

    public String[] getSymbols()
    {
        return symbols;
    }

    public abstract String toString();

    public boolean equals(Object o)
    {
        Piece piece = (Piece) o;
        return position.equals(piece.getPosition());
    }

    public abstract void update();

    public void render(Graphics2D g2d)
    {
        g2d.drawImage(texture, x, y, Game.PIECE_SIZE, Game.PIECE_SIZE, null);
    }
}