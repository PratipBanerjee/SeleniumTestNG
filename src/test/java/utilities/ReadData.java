package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadData {

    static String projectdirectory = System.getProperty("user.dir");

    public static String ReadEnvironmentParameters(String key) throws IOException
    {
        Properties setupenvironment = new Properties();
        FileInputStream filepath = new FileInputStream(new File(projectdirectory+"\\Environment.properties"));
        setupenvironment.load(filepath);
        String value = setupenvironment.getProperty(key);
        return value;

    }


    public static String ReadObjectRepository(String key) throws IOException
    {
        Properties objectrepository = new Properties();
        FileInputStream filepath = new FileInputStream(new File(projectdirectory+"\\ORProductRepository.properties"));
        objectrepository.load(filepath);
        String value = objectrepository.getProperty(key);
        return value;
    }



    public static String GetTestData(String testcasetorun, String columnname) throws FilloException
    {
        String testdatavalue = null;
        Fillo TestData = new Fillo();
        Connection gettestdata = TestData.getConnection(projectdirectory+"\\TestData.xlsx");
        String testdataquery = "Select * from TestData where Testcase = '"+testcasetorun+"'";
        Recordset teststepdata = gettestdata.executeQuery(testdataquery);
        teststepdata.next();
        ArrayList<String> TestDataList = teststepdata.getFieldNames();
        Iterator<String> TestDataIterator = TestDataList.iterator();
            while(TestDataIterator.hasNext())
            {
                for(int i = 0; i<TestDataList.size()-0; i++)
                {
                    String data = TestDataIterator.next();
                    String datavalue = teststepdata.getField(data);
                    if(data.equalsIgnoreCase(columnname))
                    {
                        i=i+0;
                        String testData=TestDataList.get(i);
                        String testValue= teststepdata.getField(testData);
                        testdatavalue = testValue;
                        break;

                    }

                }

                break;

            }

        return testdatavalue;
    }
}
