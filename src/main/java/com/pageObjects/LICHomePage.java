package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LICHomePage {
	public LICHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Welcome to']")
	private WebElement WelcomeLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='C_selfpolicy']")
	private WebElement selfPolicyOption;

	@FindBy(how = How.XPATH, using = "//div[@id='da_grid-1239_header-title-textEl']")
	private WebElement selfPolicyHeader;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//table[@role='presentation']/tbody/tr/td[@data-columnid='gridcolumn-1242']/div/span[2]") })
	private List<WebElement> policyNumber;

	@FindBy(how = How.XPATH, using = "//span[@id='da_button-1024-btnInnerEl']")
	private WebElement LoggedInUser;
	@FindBy(how = How.XPATH, using = "//span[text()='Logout']")
	private WebElement Logout;
	@FindBy(how = How.XPATH, using = "//span[text()='Yes']")
	private WebElement LogoutConfirmation;

	@FindBy(how = How.XPATH, using = "//label[text()='You have successfully logged out. Back to']")
	private WebElement LogoutConfirmationMessage;

	public void checkWelcomeLabel() {
		if (WelcomeLabel.isDisplayed()) {
			System.out.println("User is Already Logged In");
		} else {
			System.out.println("User is not Logged In");
		}
	}

	public void clickOnSelfPolicy() throws InterruptedException {
		selfPolicyOption.click();
		Thread.sleep(4000);
	}

	public void checkSelfPolicyHeader() {
		if (selfPolicyHeader.isDisplayed()) {
			System.out.println("Self Policy Header is Present");
		} else {
			System.out.println("Self Policy Header is Missing");
		}
	}

	public void findTotalPolicy() {
		int NumOfPolicy = policyNumber.size();
		System.out.println("Total Number Of Policy are " + NumOfPolicy);

	}

	public void getPolicyNumber() throws InterruptedException {
		System.out.println("Policy Number are :");
		int NumOfPolicy = policyNumber.size();
		for (int i = 0; i < NumOfPolicy; i++) {
			String PolicyNumber = policyNumber.get(i).getText();
			System.out.println(PolicyNumber);
			Thread.sleep(2000);
		}

	}

	public void clickOnLoggedInUserName() {
		LoggedInUser.click();

	}

	public void clickOnLogout() {
		Logout.click();

	}

	public void confirmLogout() {

		LogoutConfirmation.click();
	}

	public void logoutConfirmation() {

		if (LogoutConfirmationMessage.isDisplayed()) {
			System.out.println("User is Sucessfully Logged out");
		}
	}
}
