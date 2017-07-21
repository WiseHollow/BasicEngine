package net.johnbrooks.basicengine;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Util
{
    public static FloatBuffer createFloatBuffer(int size)
    {
        return BufferUtils.createFloatBuffer(size);
    }
    public static IntBuffer createIntegerBuffer(int size)
    {
        return BufferUtils.createIntBuffer(size);
    }

    public static IntBuffer createFlippedBuffer(int... values)
    {
        IntBuffer buffer = createIntegerBuffer(values.length);
        buffer.put(values);
        buffer.flip();
        return buffer;
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

    public static FloatBuffer createFlippedBuffer(Matrix4f value)
    {
        FloatBuffer buffer = createFloatBuffer(4 * 4);
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                buffer.put(value.get(i, j));
            }
        }

        buffer.flip();

        return buffer;
    }
}
