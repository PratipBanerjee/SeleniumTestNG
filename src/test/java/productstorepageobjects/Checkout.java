package productstorepageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import utilities.ReadData;

import java.io.IOException;

public class Checkout extends TestBase {

    public static void PlaceOrder(String name, String country, String city,
                                  String cc, String month, String year) throws IOException, InterruptedException
    {
        TestBase.WaitForElement(ReadData.ReadObjectRepository("PlaceOrder"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("PlaceOrder"))).click();
        TestBase.WaitForElement(ReadData.ReadObjectRepository("Name"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Name"))).sendKeys(name);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Country"))).sendKeys(country);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("City"))).sendKeys(city);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("CreditCard"))).sendKeys(cc);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Month"))).sendKeys(month);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Year"))).sendKeys(year);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Purchase"))).click();
        TestBase.WaitForElement(ReadData.ReadObjectRepository("PurchaseConfirmation"));
        Thread.sleep(5000);
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("ReturnToHome"))).click();

    }

}
