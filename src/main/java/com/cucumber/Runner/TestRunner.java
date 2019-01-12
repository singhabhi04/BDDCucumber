package com.cucumber.Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\ABHISHEK\\eclipse-workspace\\CucumberDemo\\src\\main\\java\\com\\cucumber\\FeatureFiles\\LICLogin.feature"},
		glue = {"stepDefination"},plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		dryRun = false,
		tags= {"@LICLogin,@ValidatesPolicies,@LICLogOut"}
)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("C:\\Users\\ABHISHEK\\BDDCucumber-Workspace\\BDDCucumber\\src\\main\\java\\com\\properties\\extent-config.xml");
	}

}
