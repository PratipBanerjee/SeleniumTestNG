package pageobjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import utilities.ReadData;

public class BaseClass {


    static String projectdirectory = System.getProperty("user.dir");
    static WebDriver driver;


    public static void SetupEnvironment() throws IOException
    {

        String browser = ReadData.ReadEnvironmentParameters("BROWSER");
        String url = ReadData.ReadEnvironmentParameters("URL");
        String headless = ReadData.ReadEnvironmentParameters("HEADLESS");
        if(browser.equalsIgnoreCase("chrome"))
        {
            if(headless.equalsIgnoreCase("yes"))
            {
                System.setProperty("webdriver.chrome.driver", projectdirectory+"\\Drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }
            else
            {
                System.setProperty("webdriver.chrome.driver", projectdirectory+"\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }

        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            if(headless.equalsIgnoreCase("yes"))
            {
                System.setProperty("webdriver.gecko.driver", projectdirectory+"\\Drivers\\geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }
            else
            {
                System.setProperty("webdriver.gecko.driver", projectdirectory+"\\src/test/resources\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

            }

        }
    }

    public static void CloseBrowser()
    {
        driver.quit();
    }

    public static void WaitForElement(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static void TakeScreenShot(String path) throws IOException
    {
        TakesScreenshot snapshot = (TakesScreenshot)driver;
        File source = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(path));
    }

}
