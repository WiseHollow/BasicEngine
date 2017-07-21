package net.johnbrooks.basicengine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

/**
 * Created by ieatl on 7/21/2017.
 */
public class Shader
{
    private int program;

    public Shader()
    {
        program = glCreateProgram();

        if (program == 0)
        {
            System.out.println("Shader initialization failed: Could not find valid memory location in constructor.");
            System.exit(1);
        }
    }

    public void bind()
    {
        glUseProgram(program);
    }

    public void addVertexShader(String text)
    {
        addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text)
    {
        addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text)
    {
        addProgram(text, GL_FRAGMENT_SHADER);
    }

    public void compileShader()
    {
        glLinkProgram(program);

        if (glGetProgrami(program, GL_LINK_STATUS) == 0)
        {
            System.err.println(glGetShaderInfoLog(program, 1024));
            System.exit(1);
        }

        glValidateProgram(program);

        if (glGetProgrami(program, GL_VALIDATE_STATUS) == 0)
        {
            System.err.println(glGetShaderInfoLog(program, 1024));
            System.exit(1);
        }
    }

    public void addProgram(String text, int type)
    {
        int shader = glCreateShader(type);
        if (shader == 0)
        {
            System.out.println("Shader addProgram() failed: Could not find valid memory location when adding shader.");
            System.exit(1);
        }

        glShaderSource(shader, text);
        glCompileShader(shader);

        if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0)
        {
            System.err.println(glGetShaderInfoLog(shader, 1024));
            System.exit(1);
        }

        glAttachShader(program, shader);
    }
}
