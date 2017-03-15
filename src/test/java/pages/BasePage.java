package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static void restoreImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	public static void removeImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

}
