package net.johnbrooks.basicengine;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by ieatl on 7/21/2017.
 */
public class ResourceLoader
{
    public static String loadShaders(String filename)
    {
        StringBuilder shaderSource = new StringBuilder();
        BufferedReader shaderReader;

        try
        {
            FileReader file = new FileReader("./res/shaders/" + filename);
            shaderReader = new BufferedReader(file);

            String line;
            while ((line = shaderReader.readLine()) != null)
            {
                shaderSource.append(line).append("\n");
            }

            shaderReader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }

        return shaderSource.toString();
    }
}
