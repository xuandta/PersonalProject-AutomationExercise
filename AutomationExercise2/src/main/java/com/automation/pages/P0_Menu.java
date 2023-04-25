package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.library.PageActions;

public class P0_Menu {
	WebDriver driver;
	PageActions action;
	public P0_Menu(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
//	"Automation Exercise - Signup / Login"
	public String URL() {String URL= "https://automationexercise.com"; return URL;}
	public String getTitle() {String title = "Automation Exercise"; return title;}
	@FindBy(xpath="//a[@href='/products']") @CacheLookup private WebElement E_Products;

	@FindBy(xpath="//div[@class='shop-menu pull-right']//a[@href='/view_cart']") @CacheLookup private WebElement E_cart;
	@FindBy(xpath="//div[@class='shop-menu pull-right']//a[@href='/view_cart']") @CacheLookup private WebElement E_cart3;
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") @CacheLookup private WebElement E_signupLogin;
	@FindBy(xpath="//a[contains(text(),'Test Cases')]") @CacheLookup private WebElement E_testCases;
	@FindBy(xpath="//a[normalize-space()='API Testing']") @CacheLookup private WebElement E_APITesting;
	@FindBy(xpath="//a[normalize-space()='Video Tutorials']") @CacheLookup private WebElement E_videoTutorials;
	@FindBy(xpath="//a[normalize-space()='Contact us']") @CacheLookup private WebElement E_contactUs;
	@FindBy(xpath="//a[normalize-space()='Home']") @CacheLookup private WebElement E_home;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/..//a[normalize-space()='Logout']") @CacheLookup private WebElement E_Logout;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/..//a[normalize-space()='Delete Account']") @CacheLookup private WebElement E_DeleteAccount ;
	@FindBy(xpath="//ul[@class='nav navbar-nav']//i[@class='fa fa-user']/parent::a") @CacheLookup private WebElement E_Logged_in_as ;

// footer 
	@FindBy(xpath="//div[@class='footer-widget']//*[contains(text(),'Subscription')]") @CacheLookup private WebElement E_Footer_Subscription;
	@FindBy(xpath="//div[@class='footer-widget']//input[@id='susbscribe_email']") @CacheLookup private WebElement E_Footer_subscribe_inputEmail;
	@FindBy(xpath="//div[@class='footer-widget']//button[@id='subscribe']") @CacheLookup private WebElement E_Footer_subscribe_buttonSubmit;
	@FindBy(xpath="//div[@class='footer-widget']//*[contains(text(),'You have been successfully subscribed!')]") @CacheLookup private WebElement E_msg_You_have_been_successfully_subscribed;
	
	@FindBy(xpath="//i[@class='fa fa-angle-up']") @CacheLookup private WebElement E_arrow_PageUp;
	


	public void FullFill_Footer_Subcribe(String Email) {
		E_Footer_subscribe_inputEmail.sendKeys(Email);
		E_Footer_subscribe_buttonSubmit.click();
	}
	
	
	
	
// -------------------------------------------------------------------------------------------------->>>>
	public WebElement getE_arrow_PageUp() {
		return E_arrow_PageUp;
	}
	public PageActions getAction() {
		return action;
	}

	public WebElement getE_Products() {
		return E_Products;
	}

	public WebElement getE_cart() {
		return E_cart;
	}

	public WebElement getE_cart3() {
		return E_cart3;
	}

	public WebElement getE_signupLogin() {
		return E_signupLogin;
	}

	public WebElement getE_testCases() {
		return E_testCases;
	}

	public WebElement getE_APITesting() {
		return E_APITesting;
	}

	public WebElement getE_videoTutorials() {
		return E_videoTutorials;
	}

	public WebElement getE_contactUs() {
		return E_contactUs;
	}

	public WebElement getE_home() {
		return E_home;
	}

	public WebElement getE_Logout() {
		return E_Logout;
	}

	public WebElement getE_DeleteAccount() {
		return E_DeleteAccount;
	}

	public WebElement getE_Logged_in_as() {
		return E_Logged_in_as;
	}

	public WebElement getE_Footer_Subscription() {
		return E_Footer_Subscription;
	}

	public WebElement getE_Footer_subscribe_inputEmail() {
		return E_Footer_subscribe_inputEmail;
	}

	public WebElement getE_Footer_subscribe_buttonSubmit() {
		return E_Footer_subscribe_buttonSubmit;
	}

	public WebElement getE_msg_You_have_been_successfully_subscribed() {
		return E_msg_You_have_been_successfully_subscribed;
	}
	
}
