package net.johnbrooks.basicengine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Mesh
{
    // vbo will be a pointer/handler.
    // size is how much data we have from the pointer.
    private int vbo, size;

    public Mesh()
    {
        vbo = glGenBuffers();
        size = 0;
    }

    public void addVertices(Vertex... vertices)
    {
        size += vertices.length * Vertex.SIZE; // Changed this to += without consent first. should be proper way.

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
    }

    public void draw()
    {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
        glDrawArrays(GL_TRIANGLES, 0, size);

        glDisableVertexAttribArray(0);
    }
}
