package game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.board.Board;
import game.board.BoardView;
import launcher.DesktopLauncher;
import org.lwjgl.opengl.GL20;

public class Game extends ScreenAdapter
{
    public static final int SQUARE_SIZE = DesktopLauncher.WINDOW_WIDTH / 16;
    public static final int PIECE_SIZE = DesktopLauncher.WINDOW_WIDTH / 20;

    private SpriteBatch spriteBatch;
    private Board board;

    public Game()
    {
        initGraphics();
        initGameElements();
    }

    private void initGraphics()
    {
        spriteBatch = new SpriteBatch();
    }

    private void initGameElements()
    {
        board = new Board(BoardView.WhiteView);
    }

    private void update()
    {
        board.update();
    }

    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        spriteBatch.begin();

        board.render(spriteBatch);

        spriteBatch.end();
    }
}