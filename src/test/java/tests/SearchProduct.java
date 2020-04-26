package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.BaseClass;
import pageobjects.HomePage;
import pageobjects.SearchResult;
import utilities.ReadData;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchProduct {

    String projectdirectory = System.getProperty("user.dir");
    DateFormat datefrmat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String currentdate = datefrmat.format(date).toString();
    ExtentReports reports;
    ExtentTest test;

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
    public void searchproducttest() throws FilloException, IOException
    {
        HomePage.SearchProduct(ReadData.GetTestData("SearchProduct", "Testdata1"));
        SearchResult.SelectProduct();
        SearchResult.AddToCart();

    }

    @AfterTest
    public void reportflush()
    {
        reports.flush();
    }

    @AfterMethod
    public void failscreenshot(ITestResult result) throws IOException
    {
        if(ITestResult.FAILURE==result.getStatus())
        {
            String className = this.getClass().getSimpleName();
            BaseClass.TakeScreenShot(projectdirectory+"\\Reports\\FailedTestCase_"+className+".png");

        }
    }


}
