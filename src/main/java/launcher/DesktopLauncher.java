package launcher;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import game.main.Game;

import javax.swing.*;
import java.awt.*;

public class DesktopLauncher extends JFrame
{
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_WIDTH = SCREEN_SIZE.width / 2;
    public static final int WINDOW_HEIGHT = SCREEN_SIZE.height / 2 + Game.SQUARE_SIZE / 2;
    public static final boolean RESIZABLE = false;
    public static final String TITLE = "Chess Game";

    public DesktopLauncher()
    {
        configure();
        Game game = new Game();
        this.add(game, BorderLayout.CENTER);
        this.add(game.getHud(), BorderLayout.EAST);
    }

    private void configure()
    {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle(TITLE);
        this.setResizable(RESIZABLE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void launch()
    {
        this.setVisible(true);
    }

    public static void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        FlatLaf.setup(new FlatLightLaf());
        DesktopLauncher desktopLauncher = new DesktopLauncher();
        desktopLauncher.launch();
    }
}