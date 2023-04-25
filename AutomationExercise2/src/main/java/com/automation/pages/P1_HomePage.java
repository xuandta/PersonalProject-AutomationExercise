package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.library.PageActions;

public class P1_HomePage {
	WebDriver driver;
	PageActions action;
	public P1_HomePage(WebDriver driver) {
	this.driver = driver;
	action = new PageActions(driver);
	}
	
//	public String Web_Title () { return driver.findElement(By.xpath("")); }
	public String Web_URL () {  String url =  "https://automationexercise.com"; return url; }
//	public WebElement E_ () { return driver.findElement(By.xpath("")); }
//	public WebElement E_ () { return driver.findElement(By.xpath("")); }
//	public WebElement E_ () { return driver.findElement(By.xpath("")); }
//	public WebElement E_ () { return driver.findElement(By.xpath("")); }
	

}
