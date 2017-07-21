package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Vector3f
{
    protected float x, y, z;

    public Vector3f(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float length()
    {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public float dot(Vector2f r)
    {
        return x * r.getX() + y * r.getY();
    }

    public Vector3f normalize()
    {
        float length = length();
        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    public Vector3f add(Vector3f r)
    {
        return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
    }

    public Vector3f add(float toAdd)
    {
        return new Vector3f(x + toAdd, y + toAdd, z + toAdd);
    }

    public Vector3f subtract(Vector3f r)
    {
        return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
    }

    public Vector3f subtract(float toSubtract)
    {
        return new Vector3f(x - toSubtract, y - toSubtract, z - toSubtract);
    }

    public Vector3f multiply(Vector3f r)
    {
        return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
    }

    public Vector3f multiply(float toMultiply)
    {
        return new Vector3f(x * toMultiply, y * toMultiply, z * toMultiply);
    }

    public Vector3f divide(Vector3f r)
    {
        return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
    }

    public Vector3f divide(float toDivide)
    {
        return new Vector3f(x / toDivide, y / toDivide, z / toDivide);
    }

    public Vector3f cross(Vector3f r)
    {
        float _x = y * r.getZ() - z * r.getY();
        float _y = z * r.getX() - x * r.getZ();
        float _z = x * r.getY() - y * r.getX();

        return new Vector3f(_x, _y, _z);
    }

    public Vector3f rotate(float angle)
    {
        return null;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getZ()
    {
        return z;
    }
}
