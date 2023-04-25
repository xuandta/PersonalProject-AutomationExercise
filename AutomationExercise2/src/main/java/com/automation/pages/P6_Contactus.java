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

public class P6_Contactus {
	WebDriver driver;
	PageActions action;
	public P6_Contactus(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']") @CacheLookup private WebElement E_Title_Get_In_Touch;
	@FindBy(xpath="//input[@name='name']") @CacheLookup private WebElement E_textbox_name;
	@FindBy(xpath="//input[@name='email']") @CacheLookup private WebElement E_textbox_email;
	@FindBy(xpath="//input[@name='subject']") @CacheLookup private WebElement E_textbox_subject;
	@FindBy(xpath="//textarea[@name='message']") @CacheLookup private WebElement E_textarea_message;
	@FindBy(xpath="//input[@name='submit']") @CacheLookup private WebElement E_submit;
	@FindBy(xpath="//input[@name='upload_file']") @CacheLookup private WebElement E_choose_file;
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']") @CacheLookup private WebElement E_mgs_Get_In_Touch;
	

	public void FullFillForm(String name, String email, String subject, String message, String FilePath) throws InterruptedException {
		E_textbox_name.sendKeys(name);
		E_textbox_email.sendKeys(email);
		E_textbox_subject.sendKeys(subject);
		E_textarea_message.sendKeys(message);
		E_choose_file.sendKeys(FilePath);
		E_submit.click();
	}
	
	// after submit success
	@FindBy(xpath="//div[contains(text(),'Success! Your details have been submitted successfully.')]") @CacheLookup public WebElement E_msg_Success_Your_details_have_been_submitted_successfully;
	@FindBy(xpath="//a[@class='btn btn-success']") @CacheLookup public WebElement  E_HomeBack;

	
// -------------------------------------------------------->>>>>>>>>>>>
	public WebElement getE_Title_Get_In_Touch() {
		return E_Title_Get_In_Touch;
	}
	public WebElement getE_textbox_name() {
		return E_textbox_name;
	}
	public WebElement getE_textbox_email() {
		return E_textbox_email;
	}
	public WebElement getE_textbox_subject() {
		return E_textbox_subject;
	}
	public WebElement getE_textarea_message() {
		return E_textarea_message;
	}
	public WebElement getE_submit() {
		return E_submit;
	}
	public WebElement getE_choose_file() {
		return E_choose_file;
	}
	public WebElement getE_mgs_Get_In_Touch() {
		return E_mgs_Get_In_Touch;
	}
	public WebElement getE_msg_Success_Your_details_have_been_submitted_successfully() {
		return E_msg_Success_Your_details_have_been_submitted_successfully;
	}
	public WebElement getE_HomeBack() {
		return E_HomeBack;
	}
	
	
	
}
	

