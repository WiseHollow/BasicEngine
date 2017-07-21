package net.johnbrooks.basicengine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Input
{
    private static final int NUM_KEYCODES = 256;
    private static final int NUM_MOUSEBUTTONS = 4;
    private static List<Integer> currentKeys = new ArrayList<>();
    private static List<Integer> downKeys = new ArrayList<>();
    private static List<Integer> upKeys = new ArrayList<>();

    private static List<Integer> currentMouse = new ArrayList<>();
    private static List<Integer> downMouse = new ArrayList<>();
    private static List<Integer> upMouse = new ArrayList<>();

    public static void update()
    {
        /**
         * Keyboard input update
         */
        upKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++)
            if (!getKey(i) && currentKeys.contains(i))
                upKeys.add(i);
        downKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++)
            if (getKey(i) && !currentKeys.contains(i))
                downKeys.add(i);
        currentKeys.clear();
        for (int i = 0; i < NUM_KEYCODES; i++)
            if (getKey(i))
                currentKeys.add(i);


        /**
         * Mouse input update
         */
        upMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
            if (!getMouse(i) && currentMouse.contains(i))
                upMouse.add(i);
        downMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
            if (getMouse(i) && !currentMouse.contains(i))
                downMouse.add(i);
        currentMouse.clear();
        for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
            if (getMouse(i))
                currentMouse.add(i);

    }

    public static boolean getKey(int keyCode)
    {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode)
    {
        return downKeys.contains(keyCode);
    }

    public static boolean getKeyUp(int keyCode)
    {
        return upKeys.contains(keyCode);
    }

    public static boolean getMouse(int keyCode)
    {
        return Mouse.isButtonDown(keyCode);
    }

    public static boolean getMouseDown(int keyCode)
    {
        return downMouse.contains(keyCode);
    }

    public static boolean getMouseUp(int keyCode)
    {
        return upMouse.contains(keyCode);
    }

    public static Vector2f getMousePosition()
    {
        return new Vector2f(Mouse.getX(), Mouse.getY());
    }
}
