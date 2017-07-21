package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Vertex
{
    public static final int SIZE = 3; // How many floats are in our position.

    private Vector3f position;

    public Vertex(Vector3f position)
    {
        this.position = position;
    }

    public Vector3f getPosition()
    {
        return position;
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }

    public float[] toBuffer()
    {
        float[] buffer = new float[SIZE];
        buffer[0] = position.getX();
        buffer[1] = position.getY();
        buffer[2] = position.getZ();

        return buffer;
    }
}
