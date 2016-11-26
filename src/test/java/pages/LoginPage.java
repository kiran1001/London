package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="txtUsername")  WebElement uName;
	
	@FindBy(id="txtPassword")  WebElement pass;

	@FindBy(xpath=("//Input[@value='LOGIN']")) WebElement loginButton;
	
	
	public void login_To_Application_As_Admin(String username, String password)
{
		uName.sendKeys(username);
		
		pass.sendKeys(password);
		
		loginButton.click();
		
		System.out.println("Login completed");
		
		
}

	
	public void typeuserName()
	{
		uName.sendKeys("Admin");
	}
	
	public void typePassword()
	{
		pass.sendKeys("admin");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	}


