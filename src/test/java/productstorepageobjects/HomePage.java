package productstorepageobjects;

import org.openqa.selenium.By;
import utilities.ReadData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    public static void BrokerLogin() throws IOException
    {
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginLink"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginLink"))).click();
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("Username"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Username"))).
             sendKeys(ReadData.ReadEnvironmentParameters("BrokerUsername"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Password"))).
             sendKeys(ReadData.ReadEnvironmentParameters("BrokerPassword"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginButton"))).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginValidation"));

    }

    public static void UnderwriterLogin() throws IOException
    {

        BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginLink"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginLink"))).click();
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("Username"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Username"))).
                sendKeys(ReadData.ReadEnvironmentParameters("UndereriterUsername"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Password"))).
                sendKeys(ReadData.ReadEnvironmentParameters("UnderwriterPassword"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginButton"))).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginValidation"));

    }

    public static void SelectProduct() throws IOException
    {
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("SelectProduct"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("SelectProduct"))).click();
    }

    public static void Logout() throws IOException
    {
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("Logout"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Logout"))).click();

    }


}
