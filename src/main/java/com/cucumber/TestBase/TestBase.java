package com.cucumber.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	public Properties prop;
	
	public TestBase() {
		prop = new Properties();
		File file = new File("C:\\Users\\ABHISHEK\\eclipse-workspace\\CucumberDemo\\src\\main\\java\\com\\properties\\cucumber.properties");
		FileReader obj= null;;
		try {
			obj = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			prop.load(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public  void openBrowser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://ebiz.licindia.in/D2CPM/#Login");
		driver.manage().window().maximize();
		
		String Url =prop.getProperty("URL");
		driver.get(Url);
		Thread.sleep(2000);
		
	}

}
