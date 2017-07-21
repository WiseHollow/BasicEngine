package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Matrix4f
{
    private float[][] m;

    public Matrix4f()
    {
        m = new float[4][4];
    }

    public Matrix4f initIdentity()
    {
        m[0][0] = 1;    m[0][1] = 0;    m[0][2] = 0;    m[0][3] = 0;
        m[1][0] = 1;    m[1][1] = 0;    m[1][2] = 0;    m[1][3] = 0;
        m[2][0] = 1;    m[2][1] = 0;    m[2][2] = 0;    m[2][3] = 0;
        m[3][0] = 1;    m[3][1] = 0;    m[3][2] = 0;    m[3][3] = 0;

        return this;
    }

    public Matrix4f multiply(Matrix4f matrix4f)
    {
        Matrix4f result = new Matrix4f();

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                result.set(i, j,
                        m[i][0] * result.get(0, j) +
                                m[i][1] * result.get(1, j) +
                                m[i][2] * result.get(2, j) +
                                m[i][3] * result.get(3, j)
                );
            }
        }

        return result;
    }

    public float[][] getM()
    {
        return m;
    }

    public float get(int x, int y)
    {
        return m[x][y];
    }

    public void setM(float[][] m)
    {
        this.m = m;
    }

    public void set(int x, int y, float value)
    {
        this.m[x][y] = value;
    }
}
