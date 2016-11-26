package testcases.hybridTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AdminUserManagement;
import pages.BaseClass;
import pages.LogOutPage;
import pages.LoginPage;


public class AddUser1 extends BaseClass {

	@Test
	public void addUserToApplication() throws InterruptedException
	{
		driver.get("https://enterprise-demo.orangehrmlive.com/");
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
		login.login_To_Application_As_Admin("Admin", "admin");
	
	
		AdminUserManagement admin=PageFactory.initElements(driver, AdminUserManagement.class);
		
		Thread.sleep(2000);

		admin.addUserToApplication("Alice Duvval", "SeleniumWD", "kiran", "kiran");
		
		
		
		LogOutPage logout=PageFactory.initElements(driver, LogOutPage.class);	
		
		logout.logout_From_Application();
	}
}
