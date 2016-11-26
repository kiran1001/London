package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AdminUserManagement;
import pages.LoginPage;

public class FirstTCUsingPageObject {
	@Test
	public void loginToApplication() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://enterprise-demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.typeuserName();

		login.typePassword();

		login.clickOnLoginButton();

		AdminUserManagement admin = PageFactory.initElements(driver, AdminUserManagement.class);

		admin.clickOnAdminLink();

		admin.clickOnAddUser();

		admin.typeEmpName();

		admin.typeUserName();

		admin.typePassword();

		admin.typeConfirmPassword();

		admin.clickOnSaveButton();
	}

}
