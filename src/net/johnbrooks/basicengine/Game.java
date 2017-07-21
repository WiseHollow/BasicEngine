package net.johnbrooks.basicengine;

import org.lwjgl.input.Keyboard;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Game
{
    private Mesh meshTest;
    private Shader shader;

    public Game()
    {
        meshTest = new Mesh();
        shader = new Shader();
        Vertex[] data = new Vertex[] {
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0, 1, 0)),
                new Vertex(new Vector3f(1, -1, 0))};

        meshTest.addVertices(data);

        shader.addVertexShader(ResourceLoader.loadShaders("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShaders("basicFragment.fs"));
        shader.compileShader();
    }

    public void draw()
    {
        shader.bind();
        meshTest.draw();
    }

    public void update()
    {
        input();
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
