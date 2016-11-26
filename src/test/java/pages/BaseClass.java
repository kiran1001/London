package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class BaseClass 
{
	public WebDriver driver;
	
	@Parameters("browserName")
	@BeforeClass
	public void setup(String browser) throws InterruptedException 
	{
		
		System.out.println("====browser is getting ready====");
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		
		
		System.out.println("===browser and application is ready===");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
