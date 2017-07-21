package net.johnbrooks.basicengine;

import org.lwjgl.input.Keyboard;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Game
{
    private Mesh meshTest;
    private Shader shader;
    private Transform transform;
    private float temp = 0f;

    public Game()
    {
        meshTest = new Mesh();
        shader = new Shader();
        Vertex[] data = new Vertex[] {
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0, 1, 0)),
                new Vertex(new Vector3f(1, -1, 0))};

        meshTest.addVertices(data);

        transform = new Transform();

        shader.addVertexShader(ResourceLoader.loadShaders("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShaders("basicFragment.fs"));
        shader.compileShader();

        shader.addUniform("transform");
    }

    public void draw()
    {
        shader.bind();
        shader.setUniform("transform", transform.getTransformation());
        meshTest.draw();
    }

    public void update()
    {
        input();
        temp += Time.getDelta();
        //transform.setTranslation((float) Math.sin(temp), 0, 0);
        transform.setRotation(0, 0, (float) Math.sin(temp) * 180);
    }

    private void input()
    {
        if (Input.getKeyDown(Keyboard.KEY_UP))
            System.out.println("Key is down");
        if (Input.getKeyUp(Keyboard.KEY_UP))
            System.out.println("Key is up");

        if (Input.getMouseDown(0))
            System.out.println(Input.getMousePosition());
        if (Input.getMouseUp(0))
            System.out.println("Mouse press released");
    }
}
