package com.automation.testcase;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.CaptureScreenshot;
import com.automation.library.PageActions;
import com.automation.library.PropertiesReader;
import com.automation.pages.*;

public class TC_001 extends DriverInstance { 
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException {
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
	private void TC_001() throws InterruptedException {
		PageActions action = new PageActions(driver);
		Actions act = new Actions(driver);
		P0_Menu P0_Menu = PageFactory.initElements(driver,P0_Menu.class);
		P1_HomePage P1_HomePage = PageFactory.initElements(driver,P1_HomePage.class);
		P2_Login P2_Login = PageFactory.initElements(driver,P2_Login.class);
		P3_Products P3_Products = PageFactory.initElements(driver,P3_Products.class);
		P4_Cart P4_Cart = PageFactory.initElements(driver,P4_Cart.class);	
		P5_AfterSignup P5_AfterSignup = PageFactory.initElements(driver,P5_AfterSignup.class);
// ------------------------------------------------------------------
		driver.get(P0_Menu.URL());
		assertEquals(driver.getTitle().equals(P0_Menu.getTitle()), true);
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
		action.A_Frame_closeAds();
//		try {action.A_Frame_closeAds();
//			System.out.println("Close ads hoạt động");}
//		catch (Exception e) {
//			System.out.println("Close ads không hoạt động");
//			driver.navigate().refresh(); P5_AfterSignup.E_button_continue().click();
//			P5_AfterSignup.E_button_continue().click();
//		}
		action.A_click(P0_Menu.getE_DeleteAccount());
		assertEquals(P5_AfterSignup.getE_Account_Deleted().isDisplayed(), true);
		assertEquals(P5_AfterSignup.getE_Account_Deleted().getText().equalsIgnoreCase("Account Deleted!"), true);
//	https://automationexercise.com/account_created#google_vignette	
	}

}
