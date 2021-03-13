package com.faronics.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.faronics.ultilities.ConfigDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    public String BaseUrl=ConfigDataProvider.getconfigdata().getApplicationUrl();
    public String UserName=ConfigDataProvider.getconfigdata().getUserEmailAddress();
    public String UserPass=ConfigDataProvider.getconfigdata().getUserEmailPassword();
	public static WebDriver driver;
	
	
	public static Logger log;
    @Parameters("Browsers")
	@BeforeClass
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please provide valid browser..!!!");
		}
        driver.get(BaseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.manage().deleteAllCookies();
		
		log=Logger.getLogger("Faronics Test");
		PropertyConfigurator.configure("log4j.properties");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String testcasename) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/Screenshots/"+testcasename+".png");
		FileUtils.copyFile(source, dest);
		System.out.println("Screenshot Taken....!!!!");
	}

}
