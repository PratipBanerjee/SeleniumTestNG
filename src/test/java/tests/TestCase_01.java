package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.HomePage;
import java.util.HashMap;
import java.util.List;


public class TestCase_01 extends BaseSetUp {

    public List<HashMap<String, String>> TestData;

    HomePage homePage;

    @BeforeMethod
    public void initializeElements()
    {
        TestData = fetchTestData();
        homePage = new HomePage(driver);
    }

    @Test
    public void CheckUserIsAbleToLogin()
    {
        try
        {
            homePage.login(TestData.get(0).get("Username"), TestData.get(0).get("Password"));
        }
        catch (Exception e)
        {
            Assert.fail();
            e.printStackTrace();
        }
    }


}
