package net.johnbrooks.basicengine;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Util
{
    public static FloatBuffer createFloatBuffer(int size)
    {
        return BufferUtils.createFloatBuffer(size);
    }

    public static FloatBuffer createFlippedBuffer(Vertex[] vertices)
    {
        FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

        for (int i = 0; i < vertices.length; i++)
        {
            float[] vertexBuffer = vertices[i].toBuffer();
            for (int j = 0; j < vertexBuffer.length; j++)
                buffer.put(vertexBuffer[j]);
        }

        buffer.flip();
        return buffer;
    }
}
