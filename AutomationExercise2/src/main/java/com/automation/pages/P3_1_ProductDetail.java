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

public class P3_1_ProductDetail {
	WebDriver driver;
	PageActions action;
	public P3_1_ProductDetail(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
//	public String URL() {String URL= ""; return URL;}
	public String getTitle() {String title = "Automation Exercise - Product Details"; return title;}
	@FindBy(xpath="//div[@class='product-information']/h2") @CacheLookup private WebElement E_ProductName;
	@FindBy(xpath="//div[@class='product-information']/p") @CacheLookup private WebElement E_Category;
	@FindBy(xpath="//div[@class='product-information']/span/span") @CacheLookup private WebElement E_Price;
	@FindBy(xpath="//div[@class='product-information']//b[.='Availability:']/parent::p") @CacheLookup private WebElement E_Availability;
	@FindBy(xpath="//div[@class='product-information']//b[.='Condition:']/parent::p") @CacheLookup private WebElement E_condition;
	@FindBy(xpath="//div[@class='product-information']//b[.='Brand:']/parent::p") @CacheLookup private WebElement E_brand;
	@FindBy(xpath="//input[@id='quantity']") @CacheLookup private WebElement E_QuantityInput;
	@FindBy(xpath="//button[@class='btn btn-default cart']") @CacheLookup private WebElement E_ButtonAddToCard;
	@FindBy(xpath="//a[.='View Cart']") @CacheLookup private WebElement E_ViewCart;

	
// Write Your Review
	@FindBy(xpath="//a[normalize-space()='Write Your Review']") @CacheLookup private WebElement E_Write_Your_Review;
	@FindBy(xpath="//input[@id='name']") @CacheLookup private WebElement E_form_name;
	@FindBy(xpath="//input[@id='email']") @CacheLookup private WebElement E_form_email;
	@FindBy(xpath="//textarea[@id='review']") @CacheLookup private WebElement E_form_review;
	@FindBy(xpath="//button[@class='btn btn-default pull-right']") @CacheLookup private WebElement E_form_submit;
	@FindBy(xpath="//span[normalize-space()='Thank you for your review.']") @CacheLookup private WebElement E_msg_Thank_you_for_your_review;
	

	
	
	
	public WebElement getE_Write_Your_Review() {
		return E_Write_Your_Review;
	}

	public WebElement getE_form_name() {
		return E_form_name;
	}

	public WebElement getE_form_email() {
		return E_form_email;
	}

	public WebElement getE_form_review() {
		return E_form_review;
	}

	public WebElement getE_form_submit() {
		return E_form_submit;
	}

	public WebElement getE_msg_Thank_you_for_your_review() {
		return E_msg_Thank_you_for_your_review;
	}

	public void fullfillform(String name, String email, String review) {
		E_form_name.sendKeys(name);
		E_form_email.sendKeys(email);
		E_form_review.sendKeys(review);
		E_form_submit.click();
	}
	
	
	
	//	@FindBy(xpath="") @CacheLookup private List<WebElement> ; 
//	@FindBy(xpath="") @CacheLookup private List<WebElement> ; 
//	@FindBy(xpath="") @CacheLookup private List<WebElement> ; 
//	@FindBy(xpath="") @CacheLookup private List<WebElement> ; 
	public WebElement getE_ViewCart() {
		return E_ViewCart;
	}
	public WebElement getE_ProductName() {
		return E_ProductName;
	}

	public WebElement getE_QuantityInput() {
		return E_QuantityInput;
	}

	public WebElement getE_ButtonAddToCard() {
		return E_ButtonAddToCard;
	}

	public WebElement getE_Category() {
		return E_Category;
	}

	public WebElement getE_Price() {
		return E_Price;
	}

	public WebElement getE_Availability() {
		return E_Availability;
	}

	public WebElement getE_condition() {
		return E_condition;
	}

	public WebElement getE_brand() {
		return E_brand;
	}

	
	
// --------------------------------------------------------------------->>	
}
	

