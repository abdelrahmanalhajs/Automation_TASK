import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


    //load properties file from the folder
    public static Properties userData = loadProperties(System.getProperty("user.dir")+"/Data.properties");




    private static Properties loadProperties(String path)
    {
        Properties prop =new Properties();

        //stream for reading file

        try {
            FileInputStream stream =new FileInputStream(path);
            prop.load(stream);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

}
