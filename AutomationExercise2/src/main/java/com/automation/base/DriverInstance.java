package com.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.library.PageActions;
import com.automation.pages.P0_Menu;
import com.automation.pages.P1_HomePage;
import com.automation.pages.P2_Login;
import com.automation.pages.P3_Products;
import com.automation.pages.P4_Cart;
import com.automation.pages.P5_AfterSignup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;


	@BeforeClass
	public void StartBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void CloseBrowser() {
//		driver.close();
	}
	
	
}
