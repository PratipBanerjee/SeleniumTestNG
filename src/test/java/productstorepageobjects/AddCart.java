package productstorepageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadData;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AddCart extends BaseClass {

    public static void AddProductToCart() throws IOException, InterruptedException
    {
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("AddToCart"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("AddToCart"))).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }

    public static void SelectCart() throws IOException
    {
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("Cart"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Cart"))).click();
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("CartValidate"));

    }
}
