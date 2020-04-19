package pageobjects;

import com.aventstack.extentreports.Status;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.By;
import utilities.ReadData;

import javax.imageio.IIOException;
import java.io.IOException;

public class HomePage extends BaseClass {

public static void ClickSignIn() throws FilloException, IOException
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("SignInLink"));
            BaseClass.driver.findElement(By.xpath(ReadData.ReadObjectRepository("SignInLink"))).click();

        }
        catch(IOException e)
        {
            e.printStackTrace();

        }

    }

    public static void SignIn(String email, String password) throws FilloException, IOException
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("Email"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("Email"))).sendKeys(email);
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("Password"))).sendKeys(password);
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginButton"))).click();
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginValidation"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void ClickShoppingCart()
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("ShoppingCart"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("ShoppingCart"))).click();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void Logout()
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("LogOut"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("LogOut"))).click();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void NavigateBackToHomePage()
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("HomePageLink"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("HomePageLink"))).click();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void SearchProduct(String ProductCategory)
    {
        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("SearchField"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("SearchField"))).sendKeys(ProductCategory);
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("SearchButton"))).click();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
