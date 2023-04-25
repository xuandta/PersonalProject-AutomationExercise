package com.automation.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.inject.spi.Element;
import com.automation.library.*;

public class P5_AfterSignup {
	WebDriver driver;
	PageActions action;
	public P5_AfterSignup(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
//ENTER ACCOUNT INFORMATION
	@FindBy(xpath="//h2[.='Enter Account Information']") @CacheLookup private WebElement E_Enter_Account_Information;
	@FindBy(xpath="//div[@class='clearfix']//input") @CacheLookup private List<WebElement> E_List_Title ; 
	@FindBy(xpath="//input[@name='name']") @CacheLookup private WebElement E_name;
	@FindBy(xpath="//input[@name='password']") @CacheLookup private WebElement E_Password;
	@FindBy(xpath="//select[@name='days']") @CacheLookup private WebElement E_select_day;
	@FindBy(xpath="//select[@name='years']") @CacheLookup private WebElement E_select_year;
	@FindBy(xpath="//select[@name='months']") @CacheLookup private WebElement E_select_month;
	@FindBy(xpath="//input[@name='newsletter']") @CacheLookup private WebElement E_checkbox_newsletter;
	@FindBy(xpath="//input[@name='optin']") @CacheLookup private WebElement E_checkbox_optin;
//ADDRESS INFORMATION
	@FindBy(xpath="//input[@name='first_name']") @CacheLookup private WebElement E_first_name;
	@FindBy(xpath="//input[@name='last_name']") @CacheLookup private WebElement E_last_name;
	@FindBy(xpath="//input[@name='company']") @CacheLookup private WebElement E_company;
	@FindBy(xpath="//input[@name='address1']") @CacheLookup private WebElement E_address1;
	@FindBy(xpath="//input[@name='address2']") @CacheLookup private WebElement E_address2;
	@FindBy(xpath="//select[@name='country']") @CacheLookup private WebElement E_country;
	@FindBy(xpath="//input[@name='state']") @CacheLookup private WebElement E_state;
	@FindBy(xpath="//input[@name='city']") @CacheLookup private WebElement E_city;
	@FindBy(xpath="//input[@name='zipcode']") @CacheLookup private WebElement E_zipcode;
	@FindBy(xpath="//input[@name='mobile_number']") @CacheLookup private WebElement E_mobile_number;
	@FindBy(xpath="//button[normalize-space()='Create Account']") @CacheLookup private WebElement E_submit;
// After submit	
	@FindBy(xpath="//h2[@class='title text-center']") @CacheLookup private WebElement E_ACCOUNT_CREATED;
	@FindBy(xpath="//a[@class='btn btn-primary']")  private WebElement E_button_continue;

// After delete delete account
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']") @CacheLookup private WebElement E_Account_Deleted ;

	
	public void fullfill_form_signup(int TitleIndex, String name, String password, String day, String month, String year, 
	Boolean Checkbox1, Boolean Checkbox2, String FirstName, String LastName, String company, String Address, String Address2,
	String Country, String State ,String City ,String Zipcode ,String MobileNumber ) {
		E_List_Title.get(TitleIndex).click();
		E_name.clear();
		E_name.sendKeys(name);
		E_Password.sendKeys(password);
		action.A_selectDropDownByText(E_select_day, day);
		action.A_selectDropDownByText(E_select_month, month);
		action.A_selectDropDownByText(E_select_year, year);
		if(Checkbox1==true) {E_checkbox_newsletter.click();};
		if(Checkbox2==true) {E_checkbox_optin.click();};
		E_first_name.sendKeys(FirstName);
		E_last_name.sendKeys(LastName);
		E_company.sendKeys(company);
		E_address1.sendKeys(Address);
		E_address2.sendKeys(Address2);
		E_country.sendKeys(Country);
		E_state.sendKeys(State);
		E_city.sendKeys(City);
		E_zipcode.sendKeys(Zipcode);
		E_mobile_number.sendKeys(MobileNumber);
		E_submit.click();
	}


	
	
// ----------------------------------------------------------------------------------->>>>>>>>>>
	public WebElement getE_Enter_Account_Information() {
		return E_Enter_Account_Information;
	}


	public List<WebElement> getE_List_Title() {
		return E_List_Title;
	}


	public WebElement getE_name() {
		return E_name;
	}


	public WebElement getE_Password() {
		return E_Password;
	}


	public WebElement getE_select_day() {
		return E_select_day;
	}


	public WebElement getE_select_year() {
		return E_select_year;
	}


	public WebElement getE_select_month() {
		return E_select_month;
	}


	public WebElement getE_checkbox_newsletter() {
		return E_checkbox_newsletter;
	}


	public WebElement getE_checkbox_optin() {
		return E_checkbox_optin;
	}


	public WebElement getE_first_name() {
		return E_first_name;
	}


	public WebElement getE_last_name() {
		return E_last_name;
	}


	public WebElement getE_company() {
		return E_company;
	}


	public WebElement getE_address1() {
		return E_address1;
	}


	public WebElement getE_address2() {
		return E_address2;
	}


	public WebElement getE_country() {
		return E_country;
	}


	public WebElement getE_state() {
		return E_state;
	}


	public WebElement getE_city() {
		return E_city;
	}


	public WebElement getE_zipcode() {
		return E_zipcode;
	}


	public WebElement getE_mobile_number() {
		return E_mobile_number;
	}


	public WebElement getE_submit() {
		return E_submit;
	}


	public WebElement getE_ACCOUNT_CREATED() {
		return E_ACCOUNT_CREATED;
	}


	public WebElement getE_button_continue() {
		return E_button_continue;
	}


	public WebElement getE_Account_Deleted() {
		return E_Account_Deleted;
	}

	
}
	

