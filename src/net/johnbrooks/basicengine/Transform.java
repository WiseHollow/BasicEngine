package net.johnbrooks.basicengine;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Transform
{
    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;


    public Transform()
    {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }

    public Matrix4f getTransformation()
    {
        Matrix4f translationMatrix = new Matrix4f();
        translationMatrix.initTranslation(this.translation.getX(), this.translation.getY(), this.translation.getZ());

        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.initRotation(rotation.getX(), rotation.getY(), rotation.getZ());

        Matrix4f scaleMatrix = new Matrix4f();
        scaleMatrix.initScale(scale.getX(), scale.getY(), scale.getZ());

        return translationMatrix.multiply(rotationMatrix.multiply(scaleMatrix));
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

    public Vector3f getScale()
    {
        return scale;
    }

    public void setScale(Vector3f scale)
    {
        this.scale = scale;
    }

    public void setScale(float x, float y, float z)
    {
        this.scale.x = x;
        this.scale.y = y;
        this.scale.z = z;
    }
}
