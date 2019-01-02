package com.cucumber.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\ABHISHEK\\eclipse-workspace\\CucumberDemo\\src\\main\\java\\com\\cucumber\\FeatureFiles\\LICLogin.feature"},
		glue = {"stepDefination"},
		dryRun = false,
		tags= {"@LICLogin,@ValidatesPolicies,@LICLogOut"}
)
public class TestRunner {

}
