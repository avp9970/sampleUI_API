package utils;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigProvider {

    public static String getKeyValue(String key)
    {
        String value = null;
        String filePath = "src/test/resources/cred.properties";
        try{
            FileReader reader = new FileReader(filePath);
            Properties p = new Properties();
            p.load(reader);
            value = p.getProperty(key);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return value;
    }
}
