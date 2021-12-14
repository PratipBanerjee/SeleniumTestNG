package framework.dataprovidermanager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private String environmentParametersFile =
            System.getProperty("user.dir")+"\\src\\main\\resources\\config\\EnvironmentParameters.properties";


    public String getProperty(String keyValue)
    {
        String propertyData = "";

        Properties environmentParameters = new Properties();

        try
        {
            FileInputStream filepath = new FileInputStream(new File(environmentParametersFile));
            environmentParameters.load(filepath);
            propertyData = environmentParameters.getProperty(keyValue);
            filepath.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return propertyData;
    }

}
