package framework.webelementutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtil {

    public WebDriver driver;

    public WebElementUtil(WebDriver driver)
    {
        this.driver=driver;
    }

    public void commonWaitForElement(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    public void commonClick(WebElement element)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    public void commonSendTestData(WebElement element, String testData)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(testData);
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }

    public void commonSelectDropdown(WebElement element, String testData)
    {
        int counter = 0;
        while(counter<=5)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                Select selectdropdown = new Select(element);
                selectdropdown.selectByVisibleText(testData);
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
            }
        }
    }
}
