package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Transform
{
    private Vector3f translation;
    private Vector3f rotation;

    public Transform()
    {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
    }

    public Matrix4f getTransformation()
    {
        Matrix4f translationMatrix = new Matrix4f();
        translationMatrix.initTranslation(this.translation.getX(), this.translation.getY(), this.translation.getZ());

        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.initRotation(rotation.getX(), rotation.getY(), rotation.getZ());

        return translationMatrix.multiply(rotationMatrix);
    }

    public Vector3f getTranslation()
    {
        return translation;
    }

    public void setTranslation(Vector3f translation)
    {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z)
    {
        this.translation.x = x;
        this.translation.y = y;
        this.translation.z = z;
    }

    public Vector3f getRotation()
    {
        return rotation;
    }

    public void setRotation(Vector3f rotation)
    {
        this.rotation = rotation;
    }

    public void setRotation(float x, float y, float z)
    {
        this.rotation.x = x;
        this.rotation.y = y;
        this.rotation.z = z;
    }
}
