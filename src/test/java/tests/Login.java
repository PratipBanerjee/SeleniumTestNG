package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import org.testng.annotations.*;
import pageobjects.BaseClass;
import pageobjects.HomePage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import utilities.ReadData;

public class Login {

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
    public void logintest() throws FilloException, IOException
    {
        try
        {
            HomePage.ClickSignIn();

            HomePage.SignIn(ReadData.GetTestData("Login", "TestData1"),
                    ReadData.GetTestData("Login", "TestData2"));

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
    }

    @AfterSuite
    public void teardown()
    {
        BaseClass.CloseBrowser();
    }




}
