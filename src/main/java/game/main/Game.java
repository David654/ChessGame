package game.main;

import game.board.Board;
import game.board.BoardView;
import game.board.positions.DefaultPosition;
import game.input.Mouse;
import game.main.moves.MoveManager;
import hud.HUD;
import launcher.DesktopLauncher;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel
{
    public static final int SQUARE_SIZE = DesktopLauncher.WINDOW_WIDTH / 16;
    public static final int PIECE_SIZE = DesktopLauncher.WINDOW_WIDTH / 16;
    public static final BoardView BOARD_VIEW = BoardView.WhiteView;

    public static Board board;
    public static Mouse mouse;
    public static MoveManager moveManager;
    public static HUD hud;

    public static Font basicFont;

    public Game()
    {
        initGraphics();
        initGameElements();

        Timer timer = new Timer(1, e -> this.repaint());
        timer.start();
    }

    private void initGraphics()
    {
        basicFont = new Font("src\\main\\resources\\fonts\\font.ttf", Font.PLAIN, 26);
    }

    private void initGameElements()
    {
        this.setPreferredSize(new Dimension(9 * Game.SQUARE_SIZE, DesktopLauncher.WINDOW_HEIGHT));

        board = new Board(BOARD_VIEW);
        board.setPosition(new DefaultPosition());


        mouse = new Mouse();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        moveManager = new MoveManager();
        hud = new HUD();
    }

    private void update()
    {
        board.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        update();

        g2d.setFont(basicFont);
        board.render(g2d);

        g2d.dispose();
    }
}