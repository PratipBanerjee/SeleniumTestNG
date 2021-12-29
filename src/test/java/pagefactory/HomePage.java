package pagefactory;

import framework.webelementutility.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends WebElementUtil {

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    private WebElement SignInLink;

    @FindBy(id = "email")
    private WebElement UsernameField;

    @FindBy(id = "passwd")
    private WebElement PasswordField;

    @FindBy(id = "SubmitLogin")
    private WebElement LoginButton;

    @FindBy(xpath = "//h1[contains(text(), 'My account')]")
    private WebElement LoginSuccessfullMessage;


    public void login(String username, String password)
    {
        try
        {
            commonClick(SignInLink);
            commonWaitForElement(UsernameField);
            commonSendTestData(UsernameField, username);
            commonSendTestData(PasswordField, password);
            commonClick(LoginButton);
            commonWaitForElement(LoginSuccessfullMessage);
        }
        catch (Exception e)
        {
            Assert.fail();
            e.printStackTrace();
        }
    }

}
