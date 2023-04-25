package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.library.CaptureScreenshot;
import com.automation.library.PageActions;
import com.automation.library.*;

public class P4_1_CheckOut {
	WebDriver driver;
	PageActions action;
	public P4_1_CheckOut(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
	public String URL() {String URL= "https://automationexercise.com/checkout"; return URL;}
//	public String getTitle() {String title = ""; return title;}
	
	@FindBy(xpath="//h2[normalize-space()='Address Details']") @CacheLookup private WebElement E_Address_Details;
	@FindBy(xpath="//h2[normalize-space()='Review Your Order']") @CacheLookup private WebElement E_Review_Your_Order;
	@FindBy(xpath="//textarea[@name='message']") @CacheLookup private WebElement E_message;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") @CacheLookup private WebElement E_Place_Order;
//	YOUR DELIVERY ADDRESS
	@FindBy(xpath="//ul[@class='address item box']//li[@class='address_phone']") @CacheLookup private WebElement E_YOUR_DELIVERY_ADDRESS_Phone;
// 	YOUR BILLING ADDRESS	
	@FindBy(xpath="//ul[@class='address alternate_item box']//li[@class='address_phone']") @CacheLookup private WebElement E_YOUR_BILLING_ADDRESS_Phone;

	
// =======================================================================>>>>>
	
	
	
	
	
public WebElement getE_YOUR_DELIVERY_ADDRESS_Phone() {
		return E_YOUR_DELIVERY_ADDRESS_Phone;
	}

	public WebElement getE_YOUR_BILLING_ADDRESS_Phone() {
		return E_YOUR_BILLING_ADDRESS_Phone;
	}


	public WebElement getE_Address_Details() {
		return E_Address_Details;
	}

	public WebElement getE_Review_Your_Order() {
		return E_Review_Your_Order;
	}

	public WebElement getE_message() {
		return E_message;
	}

	public WebElement getE_Place_Order() {
		return E_Place_Order;
	}
 


	
}
	

