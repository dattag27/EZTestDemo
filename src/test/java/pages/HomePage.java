package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	@FindBy(css=".mhe-system__name")
	public WebElement title;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	public void checkHomePageTitle()
	{
		Assert.assertEquals("Home Page Title is not correct", getTitle(), title.getText());
	}
	
	public String getTitle()
	{
		return "EZTest Authoring System";
	}
	
	
}
