package launcher;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.awt.*;

public class DesktopLauncher
{
    private final Lwjgl3ApplicationConfiguration config;
    private static Lwjgl3Application application;

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_WIDTH = SCREEN_SIZE.width / 2;
    public static final int WINDOW_HEIGHT = SCREEN_SIZE.height / 2;
    public static final boolean MAXIMIZED = false;
    public static final boolean DECORATED = true;
    public static final String TITLE = "Chess Game";

    public static final int TICK_RATE = 60;
    public static final boolean VSYNC = false;

    public DesktopLauncher()
    {
        config = new Lwjgl3ApplicationConfiguration();
        configure();
    }

    private void configure()
    {
        config.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
        config.setMaximized(MAXIMIZED);
        config.setDecorated(DECORATED);
        config.setTitle(TITLE);
        config.setIdleFPS(TICK_RATE);
        config.useVsync(VSYNC);
    }

    public void launch()
    {
        application = new Lwjgl3Application(new Boot(), config);
    }

    public static void exit()
    {
        application.exit();
    }

    public static void main(String[] args)
    {
        DesktopLauncher desktopLauncher = new DesktopLauncher();
        desktopLauncher.launch();
    }
}