package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/20/2017.
 */
public class Time
{
    public static final boolean SHOW_FPS = false;
    // Time per frame
    public static final double frameCap = 1d / MainComponent.FPS;
    //Time since last frame.
    private static double delta;
    public static double unprocessedTime;
    public static double frameTime;
    public static int frames;


    private static double mTime;
    private static boolean shouldRender;

    /**
     * Returns the time in seconds.
     * @return
     */
    public static double getTime()
    {
        return System.nanoTime() / 1000000000d;
    }

    public static boolean needsRender()
    {
        return shouldRender;
    }

    public static boolean isTimeToUpdate()
    {
        boolean isTime = Time.unprocessedTime >= Time.frameCap;

        if (isTime)
        {
            shouldRender = true;
            Time.unprocessedTime -= Time.frameCap;
        }

        return isTime;
    }

    public static void init()
    {
        mTime = getTime();
        shouldRender = false;
        unprocessedTime = 0;
        frameTime = 0;
        frames = 0;
    }

    public static void update()
    {
        shouldRender = false;
        double mNewTime = Time.getTime();
        double passed = mNewTime - mTime;
        Time.unprocessedTime += passed;
        Time.frameTime += passed;
        mTime = mNewTime;
    }
}
