package com.pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.TestBase.TestBase;

public class LICLoginPage extends TestBase{

	public LICLoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='userId']")
	private WebElement UserID;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement Password;
	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	private WebElement DOB;
	@FindBy(how = How.XPATH, using = "//span[@id='da_button-1101-btnEl']")
	private WebElement SignIn;

	public void enterUserId() {
		
		
	String Username = prop.getProperty("UserName");
	System.out.println(Username);
		UserID.sendKeys(Username);
	}

	public void enterPassword() {
		Password.sendKeys(prop.getProperty("Password"));
		
	}

	public void enterDOB(String dob) {
		DOB.sendKeys(dob);
	}

	public void clickOnSignIn() {
		SignIn.click();
	}
}
