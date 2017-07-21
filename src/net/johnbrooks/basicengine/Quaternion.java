package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Quaternion
{
    private float x, y, z, w;

    public Quaternion(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float length()
    {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Quaternion normalize()
    {
        float length = length();

        x /= length;
        y /= length;
        z /= length;
        w /= length;

        return this;
    }

    public Quaternion conjugate()
    {
        return new Quaternion(-x, -y, -z, w);
    }

    public Quaternion multiply(Quaternion r)
    {
        float _x = x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
        float _y = y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
        float _z = z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();
        float _w = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();

        return new Quaternion(_x, _y, _z, _w);
    }

    public Quaternion multiply(Vector3f v)
    {
        float _x = w * v.getX() + y * v.getZ() - z * v.getY();
        float _y = w * v.getY() + z * v.getX() - x * v.getZ();
        float _z = w * v.getZ() + x * v.getY() - y * v.getX();
        float _w = -x * v.getX() - y * v.getY() - z * v.getZ();

        return new Quaternion(_x, _y, _z, _w);
    }

    public Quaternion multiply(float multiply)
    {
        return new Quaternion(x * multiply, y * multiply, z * multiply, w * multiply);
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getZ()
    {
        return z;
    }

    public void setZ(float z)
    {
        this.z = z;
    }

    public float getW()
    {
        return w;
    }

    public void setW(float w)
    {
        this.w = w;
    }
}
