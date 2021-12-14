package tests;

import framework.dataprovidermanager.ExcelReader;
import framework.dataprovidermanager.PropertiesReader;
import framework.drivermanager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseSetUp {

    public WebDriver driver;

    WebDriverManager webDriverManager = new WebDriverManager();

    PropertiesReader propertiesReader = new PropertiesReader();

    ExcelReader excelReader = new ExcelReader();

    public WebDriver getDriver()
    {
        return driver;
    }

    protected void setDriver()
    {
        driver = webDriverManager.createDriver(propertiesReader.getProperty("Browser"));
    }

    @BeforeTest
    public void createSession()
    {
        try
        {
            setDriver();
            driver.get(propertiesReader.getProperty("ApplicationURL"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void endSession()
    {
        driver.close();
        driver.quit();
    }

    @BeforeTest
    protected List<HashMap<String, String>> fetchTestData()
    {
        List <HashMap<String, String>> SheetData = new ArrayList<>();
        try
        {
            SheetData = excelReader.GetTestData("TestData");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return SheetData;
    }
}
