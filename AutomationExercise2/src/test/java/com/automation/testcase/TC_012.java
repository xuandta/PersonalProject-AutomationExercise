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

public class TC_012 extends DriverInstance{
	private String keyword = "TSHIRT";//"Tshirt";
	
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
	private void TC012() throws InterruptedException {
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
		assertEquals(driver.getTitle().equals(P0_Menu.getTitle()), true,"message 01");
		P0_Menu.getE_Products().click();
		action.A_Frame_closeAds();
		String ProductName0=P3_Products.getLE_ProductName().get(0).getText();
		String ProductPrice0=P3_Products.getLE_ProductPrice().get(0).getText();
		int	productPrice0 = Integer.parseInt(P3_Products.getLE_ProductPrice().get(0).getText().substring(4));
		P3_Products.getLE_AddToCart().get(0).click();
		P3_Products.getE_ContinueShopping().click();
		P3_Products.getLE_AddToCart().get(0).click();
		P3_Products.getE_ContinueShopping().click();
		String ProductName1=P3_Products.getLE_ProductName().get(1).getText();
		String ProductPrice1=P3_Products.getLE_ProductPrice().get(1).getText();
		int	productPrice1 = Integer.parseInt(P3_Products.getLE_ProductPrice().get(1).getText().substring(4));
		P3_Products.getLE_AddToCart().get(1).click();
		P3_Products.getE_ViewCart().click();
		assertEquals(P4_Cart.getLE_product().size()== 2, true, "msg 02");
		// Kiểm tra sản phẩm 1
		assertEquals(P4_Cart.getLE_NameProduct().get(0).getText().equals(ProductName0), true, "msg 03"+P4_Cart.getLE_NameProduct().get(0).getText()+"----"+ProductName0);
		assertEquals(P4_Cart.getLE_Quantity().get(0).getText().equals("2"), true, "msg 04");
		int TotalPrice0 = Integer.parseInt(P4_Cart.getLE_TotalPrice().get(0).getText().substring(4));
		int quatity0 = 2;
		assertEquals(TotalPrice0, productPrice0*quatity0, "msg 01");
		// Kiểm tra sản phẩm 2
		assertEquals(P4_Cart.getLE_NameProduct().get(1).getText().equals(ProductName1), true, "msg 05");
		assertEquals(P4_Cart.getLE_Quantity().get(1).getText().equals("1"), true, "msg 06");
		int TotalPrice1 = Integer.parseInt(P4_Cart.getLE_TotalPrice().get(1).getText().substring(4));
		int quatity1 = 1;
		assertEquals(TotalPrice1, productPrice1*quatity1,"msg 07");
		}
		
	}

