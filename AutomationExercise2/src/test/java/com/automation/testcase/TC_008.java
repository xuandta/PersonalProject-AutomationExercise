package com.automation.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.CaptureScreenshot;
import com.automation.library.PageActions;
import com.automation.library.PropertiesReader;
import com.automation.pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008 extends DriverInstance{
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException {
	System.out.println(result);
	Thread.sleep(1000);
	if (ITestResult.FAILURE == result.getStatus()) {
	try {
		CaptureScreenshot.takeScreenshot(driver, result.getName());
		System.out.println("Đã chụp màn hình: " + result.getName());
	} catch (Exception e) {
	        System.out.println("Exception while taking screenshot " + e.getMessage());
	    }
	  }  
	}
	
	@Test(priority = 0)
	private void TC008() throws InterruptedException {
		PageActions action = new PageActions(driver);
		P0_Menu P0_Menu = PageFactory.initElements(driver,P0_Menu.class);
		P1_HomePage P1_HomePage = PageFactory.initElements(driver,P1_HomePage.class);
		P2_Login P2_Login = PageFactory.initElements(driver,P2_Login.class);
		P3_Products P3_Products = PageFactory.initElements(driver,P3_Products.class);
		P4_Cart P4_Cart = PageFactory.initElements(driver,P4_Cart.class);	
		P5_AfterSignup P5_AfterSignup = PageFactory.initElements(driver,P5_AfterSignup.class);	
		P6_Contactus P6_Contactus = PageFactory.initElements(driver, P6_Contactus.class);
		P3_1_ProductDetail P3_1_ProductDetail = PageFactory.initElements(driver, P3_1_ProductDetail.class);
		 
// --------------------------------------------------------------------------------------------------->> Next here
		driver.get(P0_Menu.URL());
		assertEquals(driver.getTitle().equals(P0_Menu.getTitle()), true,"massage 01");
		P0_Menu.getE_Products().click();
		action.A_Frame_closeAds();
		assertEquals(driver.getTitle().equals(P3_Products.getTitle()), true,"massage 02");
		assertEquals(P3_Products.getE_Product_List().isDisplayed(), true);
		P3_Products.getLE_ViewProduct().get(0).click();
		assertEquals(driver.getTitle().equals(P3_1_ProductDetail.getTitle()), true,"massage 03");
		assertEquals(P3_1_ProductDetail.getE_ProductName().isDisplayed() , true,"massage 04");
		assertNotNull(P3_1_ProductDetail.getE_ProductName().getText(),"massage 05");
		assertEquals(P3_1_ProductDetail.getE_Category().isDisplayed() , true,"massage 06");
		assertNotNull(P3_1_ProductDetail.getE_Category().getText(),"massage 07");
		assertEquals(P3_1_ProductDetail.getE_Price().isDisplayed() , true,"massage 08");
		assertNotNull(P3_1_ProductDetail.getE_Price().getText(),"massage 09");
		assertEquals(P3_1_ProductDetail.getE_Availability().isDisplayed() , true,"massage 10");
		assertNotNull(P3_1_ProductDetail.getE_Availability().getText(),"massage 11");
		assertEquals(P3_1_ProductDetail.getE_condition().isDisplayed() , true,"massage 12");
		assertNotNull(P3_1_ProductDetail.getE_condition().getText(),"massage 13");
		assertEquals(P3_1_ProductDetail.getE_brand().isDisplayed() , true,"massage 14");
		assertNotNull(P3_1_ProductDetail.getE_brand().getText(),"massage 15");
	}
}
