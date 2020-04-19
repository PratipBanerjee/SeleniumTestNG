package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.Checkout;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderProduct {

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
    public void order() throws IOException
    {
        Checkout.Payment();

    }

    @AfterTest
    public void reportflush()
    {
        reports.flush();
    }



}
