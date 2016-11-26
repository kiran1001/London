package testcases;

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

public class FirstDDT 
{
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeClass
	public void setup(String browser)
	{
		
		System.out.println("====browser is getting ready====");
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.get("https://enterprise-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		System.out.println("===browser and application is ready===");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(dataProvider="CRMAppData")
	public void loginDiffUser(String username, String password) throws Exception
	{
		System.out.println("===Test started====");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		System.out.println("====Test end===");
	}
	
	
	@DataProvider(name="CRMAppData")
	public Object[][] getDataApp() throws Exception
	{
		System.out.println("===Test dada is getting ready====");
		
		Object[][] logins=new Object[2][2];
		
		logins[0][0]="Admin";
		logins[0][1]="admin";
		
		logins[1][0]="sysadmin";
		logins[1][1]="sysadmin";

		
		System.out.println("===Test Data is ready===");
			
		return logins;
		
	}
	

}
