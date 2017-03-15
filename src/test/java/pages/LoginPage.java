package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LoginPage extends BasePage{
	
@FindBy(xpath="//input[@name='USER_ID']")
public WebElement userName;

@FindBy(name="USER_PW")
public WebElement password;

@FindBy(xpath="//a[@title='Sign On']")
public WebElement signInButton;

@FindBy(xpath="html/body/center/form[1]/table/tbody/tr/td[3]/table/tbody/tr[1]/td/p")
public WebElement errorMessage;

public LoginPage(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
}
public void login(String username,String pwd)
{
	userName.sendKeys(username);
	password.sendKeys(pwd);
}

public void clickLogin()
{
	signInButton.click();
}

public void checkInvalidLogin()
{
	Assert.assertEquals("Login Successful", "invalid id and/or password", errorMessage.getText());
}


}
