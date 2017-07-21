package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/20/2017.
 */
public class MainComponent
{
    private static final int WIDTH = 800, HEIGHT = 600;
    private static final String TITLE = "Basic Engine";
    public static final double FPS = 60;

    public static void main(String[] args)
    {
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        MainComponent main = new MainComponent();
        main.init();

        while(!Window.isCloseRequested() && main.isRunning())
        {
            // Update our time tracking.
            Time.update();

            while (Time.isTimeToUpdate())
            {
                main.update();

                // Let's talk about dat frame-rate.
                if (Time.SHOW_FPS && Time.frameTime >= 1.0d)
                {
                    Time.frameTime = 0;
                    System.out.println("FPS: " + Time.frames);
                    Time.frames = 0;
                }
            }

            if (Time.needsRender())
            {
                main.render();
                Time.frames++;
            }

            try
            {
                Thread.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        main.cleanUp();
    }

    private boolean running;
    private Game game;

    public MainComponent()
    {
        running = false;
        game = new Game();
    }

    public boolean isRunning()
    {
        return running;
    }

    public void init()
    {
        /**
         * Initialize and pull all resources needed for game engine.
         */

        if (!running)
        {
            running = true;
            Time.init();
            RenderUtil.initGraphics();
        }
    }

    public void stop()
    {
        /**
         * Completely shutdown the program.
         */

        if (running)
        {
            running = false;
        }
    }

    private void cleanUp()
    {
        /**
         * Remove all data from memory so we can have a proper shutdown.
         */

        Window.dispose();
    }

    private void update()
    {
        /**
         * Frame update
         */

        Window.update();
        Input.update();
        game.update();
    }

    private void render()
    {
        /**
         * Frame render
         */

        RenderUtil.clearScreen();
        game.draw();
    }
}
