package productstoretests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import productstorepageobjects.AddCart;
import productstorepageobjects.BaseClass;
import productstorepageobjects.Checkout;
import productstorepageobjects.HomePage;
import utilities.ReadData;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderProductWithTwoUsers {

    String projectdirectory = System.getProperty("user.dir");
    DateFormat datefrmat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String currentdate = datefrmat.format(date).toString();
    ExtentReports reports;
    ExtentTest test;

    @BeforeSuite
    public void setUp() throws IOException
    {
        BaseClass.SetupEnvironment();
    }

    @BeforeTest
    public void setUpReport() throws IOException
    {
        reports = new ExtentReports();
        String className = this.getClass().getSimpleName();
        ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(projectdirectory+"\\Reports\\AutomationReport_"+className+".html");
        htmlreport.loadConfig(projectdirectory+"\\extent-config.xml");
        reports.attachReporter(htmlreport);

    }

    @BeforeMethod
    public void beforemethod()
    {
        String className = this.getClass().getSimpleName();
        test = reports.createTest(className, " Date = "+currentdate+"");

    }

    @Test
    public void Orderwithdualuser() throws IOException, InterruptedException, FilloException
    {
        try
        {
            String className = this.getClass().getSimpleName();
            HomePage.BrokerLogin();
            test.log(Status.PASS, "Broker Logged In Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.SelectProduct();
            test.log(Status.PASS, "Product Selected Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            AddCart.AddProductToCart();
            test.log(Status.PASS, "Product Added to Cart Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.Logout();
            test.log(Status.PASS, "Broker Logged Out Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.UnderwriterLogin();
            test.log(Status.PASS, "Underwriter Logged In Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.SelectProduct();
            test.log(Status.PASS, "Product Selected Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            AddCart.AddProductToCart();
            test.log(Status.PASS, "Product Added to Cart Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.Logout();
            test.log(Status.PASS, "Underwriter Logged Out Successfully" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.BrokerLogin();
            test.log(Status.PASS, "Broker Logged In Successfully" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            AddCart.SelectCart();
            Checkout.PlaceOrder(ReadData.GetTestData(className, "Name"),
                    ReadData.GetTestData(className, "Country"),
                    ReadData.GetTestData(className, "City"),
                    ReadData.GetTestData(className, "CreditCard"),
                    ReadData.GetTestData(className, "Month"),
                    ReadData.GetTestData(className, "Year"));
            test.log(Status.PASS, "Order Placed By Broker Successfully" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.Logout();
            test.log(Status.PASS, "Broker Logged Out Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build()) ;
            HomePage.UnderwriterLogin();
            test.log(Status.PASS, "Underwriter Logged In Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            AddCart.SelectCart();
            Checkout.PlaceOrder(ReadData.GetTestData(className, "Name"),
                    ReadData.GetTestData(className, "Country"),
                    ReadData.GetTestData(className, "City"),
                    ReadData.GetTestData(className, "CreditCard"),
                    ReadData.GetTestData(className, "Month"),
                    ReadData.GetTestData(className, "Year"));
            test.log(Status.PASS, "Order Placed By Underwriter Successfully" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());
            HomePage.Logout();
            test.log(Status.PASS, "Underwriter Logged Out Successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.CaptureScreen()).build());

        }
        catch(IOException e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, e);
        }
    }


    @AfterTest
    public void reportflush()
    {
        reports.flush();
        BaseClass.CloseBrowser();
    }

    @AfterMethod
    public void failscreenshot(ITestResult result) throws IOException
    {
        if(ITestResult.FAILURE==result.getStatus())
        {
            String className = this.getClass().getSimpleName();
            pageobjects.BaseClass.TakeScreenShot(projectdirectory+"\\Reports\\FailedTestCase_"+className+".png");

        }
    }



}
