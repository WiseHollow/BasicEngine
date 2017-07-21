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
    // ibo index buffer object (array of integers).
    // size is how much data we have from the pointer.
    private int vbo, ibo, size;

    public Mesh()
    {
        vbo = glGenBuffers();
        ibo = glGenBuffers();
        size = 0;
    }

    public void addVertices(Vertex[] vertices, int[] indices)
    {
        size += indices.length; // Changed this to += without consent first. should be proper way.

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void draw()
    {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
    }
}
