package pageobjects;

import org.openqa.selenium.By;
import utilities.ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Checkout extends BaseClass {

    public static void Payment() throws IOException
    {
        WaitForElement(ReadData.ReadObjectRepository("Summary"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("CheckOutSummary"))).click();
        WaitForElement(ReadData.ReadObjectRepository("ProcessAddress"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("ProcessAddress"))).click();
        WaitForElement(ReadData.ReadObjectRepository("ProcessCarrier"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("Terms"))).click();
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("ProcessCarrier"))).click();
        WaitForElement(ReadData.ReadObjectRepository("PaymentCheck"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("PaymentCheck"))).click();
        WaitForElement(ReadData.ReadObjectRepository("ConfirmOrder"));
        driver.findElement(By.xpath(ReadData.ReadObjectRepository("ConfirmOrder"))).click();
    }

    public static String confirm() throws IOException
    {
        WaitForElement(ReadData.ReadObjectRepository("OrderConfirmation"));
        String value = driver.findElement(By.xpath(ReadData.ReadObjectRepository("OrderConfirmation"))).getText();
        return value;
    }


}
