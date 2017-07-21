package net.johnbrooks.basicengine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Created by ieatl on 7/21/2017.
 */
public class RenderUtil
{
    public static void clearScreen()
    {
        //TODO: Stencil Buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics()
    {
        /**
         * Clear screen to Cornflower-Blue, and initialize the graphics environment.
         */
        System.out.println("Rendering with OpenGL version: " + getOpenGLVersion());
        glClearColor(0.392156862745098f, 0.5843137254901961f, 0.9294117647058824f, 0f);

        glFrontFace(GL_CW); // Choose the front face
        glCullFace(GL_BACK); // Don't draw the back face.
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST); // What draws on top of what

        //TODO: Depth clamp for later

        glEnable(GL_FRAMEBUFFER_SRGB); // Gamma Correction

    }

    public static String getOpenGLVersion()
    {
        return glGetString(GL_VERSION);
    }
}
