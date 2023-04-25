package com.automation.pages;

import java.util.List;

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

public class P4_Cart {
	WebDriver driver;
	PageActions action;
	public P4_Cart(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	public String URL() {String URL= "https://automationexercise.com/view_cart"; return URL;}
	public String getTitle() {String title = "Automation Exercise - Checkout"; return title;}
		
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr") @CacheLookup private List<WebElement> LE_product; 
	@FindBy(xpath="//table[@id='cart_info_table']//td[@class='cart_description']//a")  private List<WebElement> LE_NameProduct; 
	@FindBy(xpath="//table[@id='cart_info_table']//td[@class='cart_quantity']") @CacheLookup private List<WebElement> LE_Quantity; 
	@FindBy(xpath="//table[@id='cart_info_table']//p[@class='cart_total_price']") @CacheLookup private List<WebElement> LE_TotalPrice; 
	@FindBy(xpath="//a[@class='cart_quantity_delete']") @CacheLookup private List<WebElement> LE_deleteProduct;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") @CacheLookup private WebElement E_ProceedToCheckout;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") @CacheLookup private WebElement E_ProceedToCheckout2;

// 	Cart is empty!
	@FindBy(xpath="//span[@id='empty_cart']") @CacheLookup public WebElement E_msg_Cart_is_empty;
	
	
// after click Proceed To Checkout
	@FindBy(xpath="//u[normalize-space()='Register / Login']") @CacheLookup private WebElement E_Checkout_RegisterLogin;
	@FindBy(xpath="//button[@class='btn btn-success close-checkout-modal btn-block']") @CacheLookup private WebElement E_Checkout_ButtonContinueOnCart;


	
	
//--------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>
	public List<WebElement> getLE_product() {
		return LE_product;
	}
	public WebElement getE_msg_Cart_is_empty() {
		return E_msg_Cart_is_empty;
	}
	public List<WebElement> getLE_NameProduct() {
		return LE_NameProduct;
	}
	public List<WebElement> getLE_Quantity() {
		return LE_Quantity;
	}
	public List<WebElement> getLE_TotalPrice() {
		return LE_TotalPrice;
	}
	public List<WebElement> getLE_deleteProduct() {
		return LE_deleteProduct;
	}
	public WebElement getE_ProceedToCheckout() {
		return E_ProceedToCheckout;
	}
	public WebElement getE_Checkout_RegisterLogin() {
		return E_Checkout_RegisterLogin;
	}
	public WebElement getE_Checkout_ButtonContinueOnCart() {
		return E_Checkout_ButtonContinueOnCart;
	}
	public WebElement getE_ProceedToCheckout2() {
		return E_ProceedToCheckout2;
	}
	
	
}
	

