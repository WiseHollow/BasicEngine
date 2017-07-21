package net.johnbrooks.basicengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by ieatl on 7/20/2017.
 */
public class Window
{
    public static void createWindow(int width, int height, String title)
    {
        Display.setTitle(title);
        try
        {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException e)
        {
            e.printStackTrace();
        }
    }

    public static void update()
    {
        Display.update();
    }

    public static boolean isCloseRequested()
    {
        return Display.isCloseRequested();
    }

    public static void dispose()
    {
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }

    public static int getWidth()
    {
        return Display.getDisplayMode().getWidth();
    }

    public static int getHeight()
    {
        return Display.getDisplayMode().getHeight();
    }

    public static String getTitle()
    {
        return Display.getTitle();
    }
}
