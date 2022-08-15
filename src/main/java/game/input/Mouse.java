package game.input;

import com.badlogic.gdx.Gdx;
import game.board.BoardView;
import game.board.Square;
import game.main.Game;
import game.main.moves.Move;
import game.pieces.Color;
import game.pieces.Piece;
import game.pieces.Position;
import game.util.TextureLoader;
import launcher.DesktopLauncher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
    private final Game game;
    private Piece selectedPiece;
    private int dx;
    private int dy;
    private Position startPosition;

    public Mouse(Game game)
    {
        this.game = game;
    }

    public boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        if(mx > x && mx < x + width)
        {
            return my > y && my < y + height;
        }
        else
        {
            return false;
        }
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        for(int i = 0; i < game.board.getPieces().size(); i++)
        {
            Piece piece = game.board.getPieces().get(i);
            piece.setSelected(false);
            if(selectedPiece != null) selectedPiece.setSelected(false);
            if(mouseOver(e.getX(), e.getY(), piece.getX(), piece.getY(), Game.PIECE_SIZE, Game.PIECE_SIZE))
            {
                dx = e.getX() - piece.getX();
                dy = e.getY() - piece.getY();
                piece.setSelected(true);
                selectedPiece = piece;
                startPosition = selectedPiece.getPosition();
                break;
            }
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        for(Square square : game.board.getSquares())
        {
            square.setTexture(square.getColor() == Color.White ? TextureLoader.WHITE_SQUARE_TEXTURE : TextureLoader.BLACK_SQUARE_TEXTURE);
        }

        if(selectedPiece != null)
        {
            Position position = Position.coordinatesToPosition(selectedPiece.getX(), selectedPiece.getY());
            position = new Position(position.getRank() + 1, position.getFile() + 1);
            selectedPiece.setPosition(position);

            if(Game.BOARD_VIEW == BoardView.WhiteView)
            {
                position = position.flip();
            }

            if(!startPosition.equals(position))
            {
                Move move = new Move(selectedPiece, startPosition, position);
                game.moveManager.addMove(move);
                game.hud.update();
                System.out.println(game.moveManager.getMove(Move.moveNum - 1));
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e)
    {
        //Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
        if(selectedPiece != null)
        {
            selectedPiece.setX(e.getX() - dx);
            selectedPiece.setY(e.getY() - dy);

            Position currPosition = Position.coordinatesToPosition(selectedPiece.getX(), selectedPiece.getY());

            for(Square square : game.board.getSquares())
            {
                if(square.getPosition().equals(currPosition))
                {
                    square.setTexture(square.getColor() == Color.White ? TextureLoader.WHITE_HOVER_SQUARE_TEXTURE : TextureLoader.BLACK_HOVER_SQUARE_TEXTURE);
                }
                else
                {
                    square.setTexture(square.getColor() == Color.White ? TextureLoader.WHITE_SQUARE_TEXTURE : TextureLoader.BLACK_SQUARE_TEXTURE);
                }
            }
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        //Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        /*Position currPosition = Position.coordinatesToPosition(screenX, screenY + Game.SQUARE_SIZE / 2);
        currPosition = new Position(currPosition.getRank() + 1, currPosition.getFile());
        for(Square square : game.board.getSquares())
        {
            if(square.getPosition().equals(currPosition))
            {
                if(!square.isEmpty())
                {
                    Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
                }
                else
                {
                    Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
                }
            }
        }**/
    }
}