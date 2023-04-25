package com.automation.testcase;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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

public class TC_023 extends DriverInstance{
	
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
	private void TC020() throws InterruptedException {
		PageActions action = new PageActions(driver);
		P0_Menu P0_Menu = PageFactory.initElements(driver,P0_Menu.class);
		P1_HomePage P1_HomePage = PageFactory.initElements(driver,P1_HomePage.class);
		P2_Login P2_Login = PageFactory.initElements(driver,P2_Login.class);
		P3_Products P3_Products = PageFactory.initElements(driver,P3_Products.class);
		P4_Cart P4_Cart = PageFactory.initElements(driver,P4_Cart.class);	
		P5_AfterSignup P5_AfterSignup = PageFactory.initElements(driver,P5_AfterSignup.class);	
		P6_Contactus P6_Contactus = PageFactory.initElements(driver, P6_Contactus.class);
		P3_1_ProductDetail P3_1_ProductDetail = PageFactory.initElements(driver, P3_1_ProductDetail.class);
		P4_1_CheckOut P4_1_CheckOut = PageFactory.initElements(driver, P4_1_CheckOut.class);
		P4_2_Payment P4_2_Payment = PageFactory.initElements(driver, P4_2_Payment.class);
	
// --------------------------------------------------------------------------------------------------->> Next here
		driver.get(P0_Menu.URL());
		assertEquals(driver.getTitle().equals(P0_Menu.getTitle()), true,"message 01");
		P0_Menu.getE_signupLogin().click();
		assertEquals(P2_Login.getE_New_User_Signup().isDisplayed(), true);
		P2_Login.fullfill_form_sign_up("xuân", action.A_getRandom_Email());
		
		int TitleIndex = action.A_getRandom_int(0, 1);
		String name = action.A_getRandomUsername();
		String password = "Matkhau1@";
		String day = "19";
		String month = "March";
		String year = "1995";
		Boolean Checkbox1 = true;
		Boolean Checkbox2 = false;
		String FirstName = action.A_getRandomFirstNameVN();
		String LastName = action.A_getRandomLastNameVN();
		String company = "Funix";
		String Address = "Hà nội";
		String Address2 = "Hòa Bình";
		String Country = "Việt Nam";
		String State = "Bang";
		String City = "Thành phố";
		String Zipcode = action.A_getRandom_Phone();
		String MobileNumber = action.A_getRandom_Phone();
		P5_AfterSignup.fullfill_form_signup(TitleIndex ,  name,  password,  day,  month,  year, 
		Checkbox1,  Checkbox2,  FirstName,  LastName,  company,  Address,  Address2,
		Country,  State , City , Zipcode , MobileNumber);
		
		assertEquals(P5_AfterSignup.getE_ACCOUNT_CREATED().isDisplayed(), true); 
		assertEquals(P5_AfterSignup.getE_ACCOUNT_CREATED().getText().equalsIgnoreCase("ACCOUNT CREATED!"), true);
		P5_AfterSignup.getE_button_continue().click();
		Thread.sleep(500);
		action.A_Frame_closeAds();
		P3_Products.getLE_AddToCart().get(5).click();
		P3_Products.getE_ContinueShopping().click();
		P0_Menu.getE_cart().click();
		assertEquals(driver.getTitle(), P4_Cart.getTitle());
		P4_Cart.getE_ProceedToCheckout().click();
		assertEquals(P4_1_CheckOut.getE_YOUR_BILLING_ADDRESS_Phone().getText(), MobileNumber);
		assertEquals(P4_1_CheckOut.getE_YOUR_DELIVERY_ADDRESS_Phone().getText(), MobileNumber);
		P0_Menu.getE_DeleteAccount().click();
		assertEquals(P5_AfterSignup.getE_Account_Deleted().isDisplayed(), true);
		
		
		
		}
	
	}

