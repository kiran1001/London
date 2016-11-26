package testcases.hybridTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AdminUserManagement;
import pages.BaseClass;
import pages.LoginPage;


public class AddUser extends BaseClass {

	@Test
	public void addUserToApplication() throws InterruptedException
	{
		driver.get("https://enterprise-demo.orangehrmlive.com/");
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
		login.typeuserName();
	
		login.typePassword();
	
		login.clickOnLoginButton();
	
		AdminUserManagement admin=PageFactory.initElements(driver, AdminUserManagement.class);

		admin.clickOnAdminLink();

		admin.clickOnAddUser();

		admin.typeEmpName();
	
		Thread.sleep(2000);
	
		admin.typeUserName();
	
		Thread.sleep(2000);

		admin.typePassword();
	
		Thread.sleep(2000);
	
		admin.typeConfirmPassword();
	
		Thread.sleep(2000);

		admin.clickOnSaveButton();
		
	}
}
