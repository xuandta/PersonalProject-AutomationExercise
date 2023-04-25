package com.automation.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.library.*;

public class P2_Login{
	WebDriver driver;
	PageActions action;
	public P2_Login(WebDriver driver) {
		this.driver = driver;
		action = new PageActions(driver);
	}
	
	public String URL() {String URL= "https://automationexercise.com/login"; return URL;}
	public String getTitle() {String title = "Automation Exercise - Signup / Login"; return title;}
	@FindBy(xpath="//input[@data-qa='login-email']") @CacheLookup private WebElement E_Login_email; 
	@FindBy(xpath="//input[@name='password']") @CacheLookup private WebElement E_Login_password;
	@FindBy(xpath="//button[@data-qa='login-button']") @CacheLookup private WebElement E_Login_submit;
	@FindBy(xpath="//input[@placeholder='Name']") @CacheLookup private WebElement E_Signup_Name;
	@FindBy(xpath="//input[@data-qa='signup-email']") @CacheLookup private WebElement E_Signup_Email;
	@FindBy(xpath="//button[normalize-space()='Signup']") @CacheLookup private WebElement E_Signup_submit;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']") @CacheLookup private WebElement E_Login_to_your_account ;
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']") @CacheLookup private WebElement E_New_User_Signup;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']") @CacheLookup private WebElement E_msg_Your_email_or_password_is_incorrect;
	
// Log in Email existed
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") @CacheLookup public WebElement E_msg_Email_Address_already_exist;
	public void fullfill_form_login(String email,String password) {
		E_Login_email.sendKeys(email);
		E_Login_password.sendKeys(password);
		E_Login_submit.click();
	}
	
	public void fullfill_form_sign_up(String name,String email) {
		E_Signup_Name.sendKeys(name);
		E_Signup_Email.sendKeys(email);
		E_Signup_submit.click();
	}

	
	
// -------------------------------------------------------------------------------------------------->>>>	
	public WebElement getE_Login_email() {
		return E_Login_email;
	}

	public WebElement getE_Login_password() {
		return E_Login_password;
	}

	public WebElement getE_Login_submit() {
		return E_Login_submit;
	}

	public WebElement getE_Signup_Name() {
		return E_Signup_Name;
	}

	public WebElement getE_Signup_Email() {
		return E_Signup_Email;
	}

	public WebElement getE_Signup_submit() {
		return E_Signup_submit;
	}

	public WebElement getE_Login_to_your_account() {
		return E_Login_to_your_account;
	}

	public WebElement getE_New_User_Signup() {
		return E_New_User_Signup;
	}

	public WebElement getE_msg_Your_email_or_password_is_incorrect() {
		return E_msg_Your_email_or_password_is_incorrect;
	}

	public WebElement getE_msg_Email_Address_already_exist() {
		return E_msg_Email_Address_already_exist;
	}
	
	
	

	
}



