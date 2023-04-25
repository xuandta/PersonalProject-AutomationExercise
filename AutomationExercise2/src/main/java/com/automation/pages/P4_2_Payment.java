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

public class P4_2_Payment {
	WebDriver driver;
	PageActions action;
	public P4_2_Payment(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
	public String URL() {String URL= "https://automationexercise.com/payment"; return URL;}
	public String getTitle() {String title = "Automation Exercise - Payment"; return title;}
	
	@FindBy(xpath="//h2[normalize-space()='Payment']") @CacheLookup private WebElement E_title_Payment;
	@FindBy(xpath="//input[@name='name_on_card']") @CacheLookup private WebElement E_name_on_card;
	@FindBy(xpath="//input[@name='card_number']") @CacheLookup private WebElement E_card_number;
	@FindBy(xpath="//input[@class='form-control card-cvc']") @CacheLookup private WebElement E_Card_CVC;
	@FindBy(xpath="//input[@name='expiry_month']") @CacheLookup private WebElement E_Card_expiry_month;
	@FindBy(xpath="//input[@name='expiry_year']") @CacheLookup private WebElement E_Cart_expiry_year; 
	@FindBy(xpath="//button[@id='submit']") @CacheLookup private WebElement E_button_Submit; 
	@FindBy(xpath="//*[contains(.,'Congratulations! Your order has been confirmed!')]") @CacheLookup private WebElement E_msg_Congratulations_Your_order_has_sbeen_confirmed;
	
//	After Submit (ORDER PLACED!)
	@FindBy(xpath="//a[@class='btn btn-default check_out']") @CacheLookup private WebElement E_Download_Invoice;
	@FindBy(xpath="//a[@data-qa='continue-button']") @CacheLookup private WebElement E_continue;
	
	
//	@FindBy(xpath="") @CacheLookup public List<WebElement> ; 
	
	public WebElement getE_continue() {
		return E_continue;
	}

	public WebElement getE_Download_Invoice() {
		return E_Download_Invoice;
	}

	public void FullFillForm(String NameOnCard, String CardNumber, String CVC, String month, String year) {
		E_name_on_card.sendKeys(NameOnCard);
		E_card_number.sendKeys(NameOnCard);
		E_Card_CVC.sendKeys(CVC);
		E_Card_expiry_month.sendKeys(month);
		E_Cart_expiry_year.sendKeys(year);
		E_button_Submit.click();
	}


	
// ----------------------------------------------->>>>>>>>>>>>
	public WebElement getE_title_Payment() {
		return E_title_Payment;
	}

	public WebElement getE_name_on_card() {
		return E_name_on_card;
	}

	public WebElement getE_card_number() {
		return E_card_number;
	}

	public WebElement getE_Card_CVC() {
		return E_Card_CVC;
	}

	public WebElement getE_Card_expiry_month() {
		return E_Card_expiry_month;
	}

	public WebElement getE_Cart_expiry_year() {
		return E_Cart_expiry_year;
	}

	public WebElement getE_button_Submit() {
		return E_button_Submit;
	}

	public WebElement getE_msg_Congratulations_Your_order_has_sbeen_confirmed() {
		return E_msg_Congratulations_Your_order_has_sbeen_confirmed;
	}


	
}
	

