package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminUserManagement 
{
	WebDriver driver;
	
 public AdminUserManagement(WebDriver ldriver)
 {
	 this.driver=ldriver;
	 
 }
 
 @FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']/b") WebElement adminLink;
 
 @FindBy(id="btnAdd") WebElement addUser;
 
 @FindBy(xpath=".//*[@id='systemUser_employeeName_empName']") WebElement empName;
 
 @FindBy(id="systemUser_userName") WebElement uName;
 
 @FindBy(how=How.XPATH, using =".//*[@id='systemUser_password']") WebElement password;
 
 @FindBy(how=How.ID, using="systemUser_confirmPassword") WebElement confirmPassword;
 
 @FindBy(xpath=".//*[@id='btnSave']") WebElement clickOnSave;
 
 
 public void addUserToApplication(String empName1,String username,String pass, String cpass) throws InterruptedException
 {
	 adminLink.click();
	 verifyAdminPanel();
	 addUser.click();
	 Thread.sleep(2000);
	 uName.sendKeys(username);
	 Thread.sleep(2000);
	 empName.sendKeys(empName1);
	 Thread.sleep(2000);
	 password.sendKeys(pass);
	 Thread.sleep(2000);
	 confirmPassword.sendKeys(cpass);
	 Thread.sleep(2000);
	 clickOnSave.click();
	 
	 System.out.println("User created");
 }
 
 
 public void verifyAdminPanel()
 {
	 boolean status =driver.getCurrentUrl().contains("admin");
	 
	Assert.assertTrue(status);
	 
	System.out.println("=====congrats we are on admin page=====");
 }
 
 
 
 public void clickOnAdminLink()
 {
	 adminLink.click();
 }
 
public void clickOnAddUser()
{
	addUser.click();
	
	
}

public void typeEmpName()
{
	empName.sendKeys("Alice Duval");
}

public void typeUserName()
{
	uName.sendKeys("MukeshSelenium1");
}


public void typePassword()
{
	password.sendKeys("Selenium");
}

public void typeConfirmPassword()
{
	confirmPassword.sendKeys("Selenium");
}

public void clickOnSaveButton()
{
	clickOnSave.click();
}
}


