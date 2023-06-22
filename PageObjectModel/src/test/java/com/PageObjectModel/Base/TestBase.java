package com.PageObjectModel.Base;



import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TestBase {
	
	public static Properties prop=null;
	public static WebDriver driver;
 
  public void testBase() throws IOException {
	  try
	  {
	  prop=new Properties();
	  FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\confiq.properties");
	  prop.load(ip);
	  }
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  
  }
  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException
  {
	  if(iTestResult.getStatus()== iTestResult.FAILURE)
	  {
		  takeScreenShotOnFailure(iTestResult.getName());
	  }
  }
  public String takeScreenShotOnFailure(String name) throws IOException 
  {
	 String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 String destination= System.getProperty("user.dir")+ "\\target\\"+ name + dateName + ".jpeg";
	 File finalDestination=new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
  }

  @BeforeTest(groups={"sanity"})
  @Parameters({"browser"})
  public void beforeTest(String browser) throws IOException {
	  	testBase();
	  	
	  	if(browser.equals("chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		  }
		  
		  else if(browser.equals("edge"))
		  {
			  WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
			  
		  }
		  
		  else if(browser.equals("gecko"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
		  }
	  	driver.manage().window().maximize();
		  String baseUrl=prop.getProperty("url");
		  driver.get(baseUrl);
  }

  @AfterTest
  public void afterTest() {
  }

}
