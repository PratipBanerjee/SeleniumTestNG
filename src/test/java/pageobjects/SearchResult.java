package pageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import utilities.ReadData;

import java.io.IOException;

public class SearchResult extends TestBase {

    public static void SelectProduct() throws IOException
    {
        WaitForElement(ReadData.ReadObjectRepository("SearchResultValidation"));
        /*Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(ReadData.ReadObjectRepository("SelectProduct"))))
               .build().perform();
        WaitForElement(ReadData.ReadObjectRepository("More"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("More"))).click();*/
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("SelectProduct"))).click();

    }

    public static void AddToCart()throws IOException
    {
        WaitForElement(ReadData.ReadObjectRepository("ProductName"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("AddToCart"))).click();
        WaitForElement(ReadData.ReadObjectRepository("CheckOut"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("CheckOut"))).click();

    }

}
