package productstorepageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadData;

import java.io.IOException;


public class AddCart extends TestBase {

    public static void AddProductToCart() throws IOException, InterruptedException
    {
        TestBase.WaitForElement(ReadData.ReadObjectRepository("AddToCart"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("AddToCart"))).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }

    public static void SelectCart() throws IOException
    {
        TestBase.WaitForElement(ReadData.ReadObjectRepository("Cart"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Cart"))).click();
        TestBase.WaitForElement(ReadData.ReadObjectRepository("CartValidate"));

    }
}
