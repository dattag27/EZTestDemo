package step;


import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinition {
	
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	

	WebDriver driver;
	
	//LoginPage loginpage;
	
	@Before
	public void start()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Given("^I navigate to login page of EZTest$")
	public void i_navigate_to_login_page_of_EZTest() throws Throwable {
	    driver.get("http://ezto-qas.mheducation.com/mycourses.tpx");  
	}

	@When("^I enter the following for Login$")
	public void i_enter_the_following_for_Login(DataTable table) throws Throwable 
	{
		BasePage.restoreImplicitWait(driver);
		List<List<String>> data= table.raw();
		
		LoginPage login=new LoginPage(driver);
	    login.login(data.get(1).get(0),data.get(1).get(1));
	    BasePage.removeImplicitWait(driver);
	}

	@When("^I click on Login button$")
	public void i_click_on_Login_Button() throws Throwable 
	{
		LoginPage login=new LoginPage(driver);
		login.clickLogin();
	}

	@Then("^I should see the Homepage of Buddha$")
	public void i_should_see_the_Homepage_of_Buddha() throws Throwable {
		
		HomePage homepage=new HomePage(driver);
		String title=homepage.getTitle();
		LOGGER.info("Welcome Buddha to " +title);
		
	}

	@Then("^check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable 
	{
		HomePage homepage=new HomePage(driver);
		homepage.checkHomePageTitle();
	}

	@Then("^I shouldnot see the Homepage of Gaurav$")
	public void i_shouldnot_see_the_Homepage_of_Gaurav() throws Throwable {
	
		LOGGER.info("Incorrect creentials for Gaurav!!! Hence Couldnt Login");
	
	}

	@Then("^check the error message$")
	public void check_the_error_message() throws Throwable {
		
		LoginPage login=new LoginPage(driver);
		login.checkInvalidLogin();
	}
	    
	  
	
	@After
	public void shutdown()
	{
		driver.quit();
	}

}
