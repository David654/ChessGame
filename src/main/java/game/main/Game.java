package game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.board.Board;
import org.lwjgl.opengl.GL20;

public class Game extends ScreenAdapter
{
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
        board = new Board();
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

        board.render(spriteBatch);
    }
}