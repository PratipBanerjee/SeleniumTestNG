package framework.drivermanager;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    public WebDriver driver;

    final String chromeDriverPath = System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe";

    final String firefoxDriverPath = System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe";

    public WebDriver createDriver(String browserType)
    {
        switch (browserType) {

            case "CHROME" :

                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver =  new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;

            case "FIREFOX" :

                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--ignore-certificate-errors");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver =  new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;

        }

        return driver;
    }

}
