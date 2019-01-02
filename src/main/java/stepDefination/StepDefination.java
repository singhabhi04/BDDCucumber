package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.TestBase.TestBase;
import com.pageObjects.LICHomePage;
import com.pageObjects.LICLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination extends TestBase{
	
	TestBase testbase = new TestBase();

	@Given("^User hits URL\\.$")
	public void user_hits_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABHISHEK\\Desktop\\Garbage\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");

	}

	@When("^User enter valid UserId and Password$")
	public void user_enter_valid_UserId_and_Password() throws Throwable {
		try {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Naveenk");
		} catch (Exception e) {
			throw new Exception("Issue in Email");
		}
		driver.findElement(By.name("password")).sendKeys("Test@123");
		WebElement Login = driver.findElement(By.xpath("//input[@value='Login']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Login);
	}

	@Then("^Home page is displayed\\.$")
	public void home_page_is_displayed() throws Throwable {
		driver.findElement(By.xpath("//td[text()='CRMPRO']")).isDisplayed();
		System.out.println("Home Page Logo is Present");

	}

	@Then("^User click on Logout button$")
	public void user_click_on_Logout_button() throws Throwable {
		WebElement Logout = driver.findElement(By.xpath("//i[@class='fa fa-sign-out icon-2x']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Logout);

	}

	@Given("^User is on LIC Login Page$")
	public void user_is_on_LIC_Login_Page() throws Throwable {
		testbase.openBrowser();

		

	}

//	@Then("^User Enters Username as \"([^\"]*)\"$")
//	public void user_Enters_Username_as(String UserName) throws Throwable {
//		LICLoginPage login = new LICLoginPage(driver);
//		login.enterUserId(UserName);
//	
//		Thread.sleep(2000);
//
//	}
	@Then("^User Enters Username$")
	public void user_Enters_Username() throws Throwable {
		LICLoginPage login = new LICLoginPage(driver);
		login.enterUserId();
		Thread.sleep(2000);
	}

//	@Then("^User Enters password as \"([^\"]*)\"$")
//	public void user_Enters_password_as(String password) throws Throwable {
//		LICLoginPage login = new LICLoginPage(driver);
//		login.enterPassword(password);
//		
//		Thread.sleep(2000);
//	}
	
	@Then("^User Enters password$")
	public void user_Enters_password() throws Throwable {
		LICLoginPage login = new LICLoginPage(driver);
		login.enterPassword();
	}
	@Then("^User Enters DOB as \"([^\"]*)\"$")
	public void user_Enters_DOB_as(String DOB) throws Throwable {
		LICLoginPage login = new LICLoginPage(driver);
		login.enterDOB(DOB);
		
		Thread.sleep(2000);
	}

	@Then("^User Clicks on SignIn button$")
	public void user_Clicks_on_SignIn_button() throws Throwable {
		LICLoginPage login = new LICLoginPage(driver);
		login.clickOnSignIn();
		Thread.sleep(2000);
		
	}

	@Then("^User Validates UserName on Sucessfull Login$")
	public void user_Validates_UserName_on_Sucessfull_Login() throws Throwable {
		if (driver.findElement(By.xpath("//span[text()='Abhishek K Singh']")).isDisplayed()) {
			System.out.println("Sucessfully Logged In");
		}
	}

	@Given("^User is already Logged In$")
	public void user_is_already_Logged_In() throws Throwable {
		LICHomePage homepage = new LICHomePage(driver);
		homepage.checkWelcomeLabel();
		
	}

	@Then("^User Logged out from LIC portal$")
	public void user_Logged_out_from_LIC_portal() throws Throwable {
		LICHomePage homepage = new LICHomePage(driver);
		homepage.clickOnLoggedInUserName();
		
		Thread.sleep(2000);
		homepage.clickOnLogout();
				Thread.sleep(2000);
		homepage.confirmLogout();;
	

		homepage.logoutConfirmation();
		Thread.sleep(2000);
		driver.close();
	}

	@Then("^User Clicks on Self Policies Option$")
	public void user_Clicks_on_Self_Policies_Option() throws Throwable {
		LICHomePage homepage = new LICHomePage(driver);
		homepage.clickOnSelfPolicy();

		Thread.sleep(2000);
		homepage.checkSelfPolicyHeader();
		
	}

	@Then("^User Validates Number of Policies\\.$")
	public void user_Validates_Number_of_Policies() throws Throwable {
		LICHomePage homepage = new LICHomePage(driver);
		homepage.findTotalPolicy();

		
		Thread.sleep(2000);

	}

	@Then("^User Prints the Policy Numbers of all Policies\\.$")
	public void user_Prints_the_Policy_Numbers_of_all_Policies() throws Throwable {
		LICHomePage homepage = new LICHomePage(driver);
		homepage.getPolicyNumber();
		
	}

}
