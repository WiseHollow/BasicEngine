package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Vector2f
{
    private float x, y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f r)
    {
        return x * r.getX() + y * r.getY();
    }

    public Vector2f normalize()
    {
        float length = length();
        x /= length;
        y /= length;

        return this;
    }

    public Vector2f add(Vector2f r)
    {
        return new Vector2f(x + r.getX(), y + r.getY());
    }

    public Vector2f subtract(Vector2f r)
    {
        return new Vector2f(x - r.getX(), y - r.getY());
    }

    public Vector2f add(float toAdd)
    {
        return new Vector2f(x + toAdd, y + toAdd);
    }

    public Vector2f subtract(float toSubtract)
    {
        return new Vector2f(x - toSubtract, y - toSubtract);
    }

    public Vector2f multiply(Vector2f r)
    {
        return new Vector2f(x * r.getX(), y * r.getY());
    }

    public Vector2f multiply(float toMultiply)
    {
        return new Vector2f(x * toMultiply, y * toMultiply);
    }

    public Vector2f divide(Vector2f r)
    {
        return new Vector2f(x / r.getX(), y / r.getY());
    }

    public Vector2f divide(float toDivide)
    {
        return new Vector2f(x / toDivide, y / toDivide);
    }

    public Vector2f rotate(float angle)
    {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float) (x * cos - y * sin), (float) (x * sin + y * cos));
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
